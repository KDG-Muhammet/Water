package be.kdg.sa.service.dokOperation;

import be.kdg.sa.controller.dto.DoDto;
import be.kdg.sa.domain.*;
import be.kdg.sa.service.*;
import be.kdg.sa.service.po.ShippingOrderService;
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
    private final ShippingOrderService shippingOrderService;
    public CreateDoService(DOService doService, ShipService shipService, IOService ioService, BOService boService, ShippingOrderService shippingOrderService) {
        this.doService = doService;
        this.shipService = shipService;
        this.ioService = ioService;
        this.boService = boService;
        this.shippingOrderService = shippingOrderService;
    }


    @Transactional
    public void createDo(DoDto doDto) {
        Ship ship = shipService.findShipByVesselNumber(doDto.getVesselNumber());
        ShippingOrder shippingOrder = shippingOrderService.findShippingOrderByPoNumber(doDto.getPoNumber());

        ship.setShippingOrder(shippingOrder);
        shippingOrder.setShip(ship);

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
