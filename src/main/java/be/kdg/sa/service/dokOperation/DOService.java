package be.kdg.sa.service.dokOperation;


import be.kdg.sa.controller.dto.*;
import be.kdg.sa.domain.BunkerOperation;
import be.kdg.sa.domain.DokOperation;
import be.kdg.sa.domain.InspectionOperation;
import be.kdg.sa.domain.enums.Status;
import be.kdg.sa.repository.DORepository;
import be.kdg.sa.service.po.PurchaseOrderSenderService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
public class DOService {

    private final DORepository doRepository;
    private final PurchaseOrderSenderService purchaseOrderSenderService;
    private final ModelMapper modelMapper;

    private static final Logger logger = LoggerFactory.getLogger(DOService.class);

    public DOService(DORepository doRepository, PurchaseOrderSenderService purchaseOrderSenderService, ModelMapper modelMapper) {
        this.doRepository = doRepository;
        this.purchaseOrderSenderService = purchaseOrderSenderService;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public OperationsDto findDoByVesselNumber(String vesselNumber) {
        DokOperation dokOperation = doRepository.findDokOperationByShipVesselNumber(vesselNumber);
        InspectionOperation inspectionOperation = dokOperation.getInspectionOperation();
        BunkerOperation bunkerOperation = dokOperation.getBunkerOperation();

        IODto ioDto = modelMapper.map(inspectionOperation, IODto.class);
        BODto boDto = modelMapper.map(bunkerOperation, BODto.class);

        OperationsDto operationsDto = new OperationsDto(dokOperation.getArrivalTime(),ioDto,boDto);

        if (inspectionOperation.getInspectionStatus().equals(Status.INSPECTION_SUCCESS) && bunkerOperation.getBunkerStatus().equals(Status.BUNKER_SUCCESS)){
            dokOperation.setStatus(Status.COMPLETE);
            dokOperation.setDepartureTime(LocalDateTime.now());
            operationsDto.setStatus(dokOperation.getStatus());
            operationsDto.setDepartureTime(dokOperation.getDepartureTime());
            logger.info("Dok operatie compleet voor vessel nummer: {}", vesselNumber);

            purchaseOrderSenderService.sendFulfilledPOToWarehouse(dokOperation.getShip().getShippingOrder());
        } else {
            operationsDto.setStatus(dokOperation.getStatus());
            logger.info("Dok operatie nog niet compleet voor vessel nummer: {}", vesselNumber);
        }
        return operationsDto;
    }


    public void create(DokOperation dockOperation) {
        logger.info("Creating dock: {}", dockOperation);
        doRepository.save(dockOperation);
    }
}
