package be.kdg.sa.service;


import be.kdg.sa.controller.dto.*;
import be.kdg.sa.domain.BunkerOperation;
import be.kdg.sa.domain.DokOperation;
import be.kdg.sa.domain.InspectionOperation;
import be.kdg.sa.domain.enums.Status;
import be.kdg.sa.repository.DORepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
public class DOService {

    private final DORepository doRepository;
    private final ModelMapper modelMapper;

    private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderService.class);

    public DOService(DORepository doRepository, ModelMapper modelMapper) {
        this.doRepository = doRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public OperationsDto findDoByVesselNumber(String vesselNumber) {
        DokOperation dokOperation = doRepository.findDokOperationByShipVesselNumber(vesselNumber);
        if (dokOperation == null) {
            throw new IllegalArgumentException("Dok operatie niet gevonden voor vessel nummer: " + vesselNumber);
        }
        InspectionOperation inspectionOperation = dokOperation.getInspectionOperation();
        BunkerOperation bunkerOperation = dokOperation.getBunkerOperation();
        if (inspectionOperation == null || bunkerOperation == null) {
            throw new IllegalStateException("Incompleet dok operatie: zowel IO als BO moeten aanwezig zijn.");
        }

        IODto ioDto = modelMapper.map(inspectionOperation, IODto.class);
        BODto boDto = modelMapper.map(bunkerOperation, BODto.class);

        OperationsDto operationsDto = new OperationsDto(dokOperation.getArrivalTime(),ioDto,boDto);

        if (inspectionOperation.getInspectionStatus().equals(Status.INSPECTION_SUCCESS) && bunkerOperation.getBunkerStatus().equals(Status.BUNKER_SUCCESS)){
            dokOperation.setStatus(Status.COMPLETE);
            dokOperation.setDepartureTime(LocalDateTime.now());
            operationsDto.setStatus(dokOperation.getStatus());
            operationsDto.setDepartureTime(dokOperation.getDepartureTime());
            logger.info("Dok operatie compleet voor vessel nummer: {}", vesselNumber);
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
