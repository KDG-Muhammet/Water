package be.kdg.sa.service;


import be.kdg.sa.controller.dto.DoDto;
import be.kdg.sa.domain.BunkerOperation;
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
    private final BOService boService;
    private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderService.class);

    public DOService(DORepository doRepository, ShipService shipService, IOService ioService, BOService boService) {
        this.doRepository = doRepository;
        this.shipService = shipService;
        this.ioService = ioService;
        this.boService = boService;
    }

    @Transactional
    public void createDo(DoDto doDto) {
        Ship ship = shipService.findShipByVesselNumber(doDto.getVesselNumber());
        LocalDateTime arrivalTime = LocalDateTime.now();

        DokOperation dockOperation = new DokOperation(arrivalTime, ship, arrivalTime.plusHours(4)); // voor depature + 4 want bunkeren duurt 4u
        dockOperation.setShip(ship);
        ship.setDokOperation(dockOperation);

        InspectionOperation inspection = new InspectionOperation(LocalDateTime.now(),generateInspectionNumber(doDto.getVesselNumber()));
        BunkerOperation bunkering = new BunkerOperation(doDto.getVesselNumber());

        dockOperation.setInspectionOperation(inspection);
        inspection.setDokOperation(dockOperation);
        dockOperation.setBunkerOperation(bunkering);
        bunkering.setDokOperation(dockOperation);

        ioService.createIo(inspection);
        boService.createBo(bunkering);
        doRepository.save(dockOperation);

    }

}
