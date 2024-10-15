package be.kdg.sa.service.dokOperation;

import be.kdg.sa.controller.dto.DoDto;
import be.kdg.sa.domain.BunkerOperation;
import be.kdg.sa.domain.DokOperation;
import be.kdg.sa.domain.InspectionOperation;
import be.kdg.sa.domain.Ship;
import be.kdg.sa.service.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static be.kdg.sa.util.GenerateOperationNumbers.generateInspectionNumber;

@Service
public class CreateDoService {
    private final DOService doService;
    private final ShipService shipService;
    private final IOService ioService;
    private final BOService boService;
    public CreateDoService(DOService doService, ShipService shipService, IOService ioService, BOService boService) {
        this.doService = doService;
        this.shipService = shipService;
        this.ioService = ioService;
        this.boService = boService;
    }


    @Transactional
    public void createDo(DoDto doDto) {
        Ship ship = shipService.findShipByVesselNumber(doDto.getVesselNumber());
        DokOperation dockOperation = new DokOperation(LocalDateTime.now(), ship);
        dockOperation.setShip(ship);
        ship.setDokOperation(dockOperation);

        InspectionOperation inspection = new InspectionOperation(LocalDateTime.now(), generateInspectionNumber(doDto.getVesselNumber()));
        BunkerOperation bunkering = new BunkerOperation(doDto.getVesselNumber());

        dockOperation.setInspectionOperation(inspection);
        inspection.setDokOperation(dockOperation);
        dockOperation.setBunkerOperation(bunkering);
        bunkering.setDokOperation(dockOperation);

        ioService.createIo(inspection);
        boService.createBo(bunkering);
        doService.create(dockOperation);
    }

}
