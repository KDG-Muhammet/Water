package be.kdg.sa.controller.api;


import be.kdg.sa.controller.dto.ShipDto;
import be.kdg.sa.service.ShipService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/ships")
public class ShipRestController {

    private final ShipService shipService;

    public ShipRestController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping("")
    public Collection<ShipDto> getPurchaseOrders() {
        return shipService.getAllShips();

    }

}
