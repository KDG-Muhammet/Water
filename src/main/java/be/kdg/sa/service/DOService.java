package be.kdg.sa.service;


import be.kdg.sa.controller.dto.DoDto;
import be.kdg.sa.domain.DokOperation;
import be.kdg.sa.domain.InspectionOperation;
import be.kdg.sa.domain.Ship;
import be.kdg.sa.domain.enums.Status;
import be.kdg.sa.repository.DORepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static be.kdg.sa.util.GenerateOperationNumbers.generateInspectionNumber;

@Service
public class DOService {

    private final DORepository doRepository;
    private final ShipService shipService;
    private final IOService ioService;
    private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderService.class);

    public DOService(DORepository doRepository, ShipService shipService, IOService ioService) {
        this.doRepository = doRepository;
        this.shipService = shipService;
        this.ioService = ioService;
    }

    @Transactional
    public void createDo(DoDto doDto) {
        Ship ship = shipService.findShipByVesselNumber(doDto.getVesselNumber());
        LocalDateTime arrivalTime = LocalDateTime.now();

        DokOperation dockOperation = new DokOperation(arrivalTime, ship, arrivalTime.plusHours(4)); // voor depature + 4 want bunkeren duurt 4u
        dockOperation.setShip(ship);
        ship.setDokOperation(dockOperation);

        InspectionOperation inspection = new InspectionOperation(LocalDateTime.now(),generateInspectionNumber(doDto.getVesselNumber()));
        inspection.setInspectionStatus(Status.PENDING);

        dockOperation.setInspectionOperation(inspection);
        inspection.setDokOperation(dockOperation);
        ioService.createIo(inspection);
        doRepository.save(dockOperation);

    }
//    public DokOperation processArrival(String poId, String vesselNumber, Date arrivalTime) {
//        DokOperation dokOperation = new DokOperation();
//        dokOperation.setPOid(Integer.parseInt(poId));
//        dokOperation.setVesselNumber(vesselNumber);
//        dokOperation.setArrivalTime(arrivalTime);
//
//        DokOperation savedDO = doRepository.save(dokOperation);
//
//
//        InspectionOperation inspection = new InspectionOperation();
//        inspection.setDate(new Date());
//        ioRepository.save(inspection);
//
//
//        BunkerOperation bunkering = new BunkerOperation();
//        bunkering.setVesselNumber(vesselNumber);
//        bunkering.setTime((Time) new Date());
//        boRepository.save(bunkering);
//
//
//
//        return savedDO;
//    }

}
