package be.kdg.sa.service;


import be.kdg.sa.controller.dto.DoDto;
import be.kdg.sa.domain.DokOperation;
import be.kdg.sa.domain.Ship;
import be.kdg.sa.repository.DORepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@Service
public class DOService {

    private final DORepository doRepository;
    private final ShipService shipService;

    private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderService.class);

    public DOService(DORepository doRepository, ShipService shipService) {
        this.doRepository = doRepository;
        this.shipService = shipService;
    }

    @Transactional
    public void createDo(DoDto doDto) {
        Ship ship = shipService.findShipByVesselNumber(doDto.getVesselNumber());
        LocalDateTime arrivalTime = LocalDateTime.now();
        DokOperation dockOperation = new DokOperation(arrivalTime, ship, arrivalTime.plusHours(4)); // voor depature + 4 want bunkeren duurt 4u
        dockOperation.setShip(ship);
        ship.setDokOperation(dockOperation);
        doRepository.save(dockOperation);

    }

//
//
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
