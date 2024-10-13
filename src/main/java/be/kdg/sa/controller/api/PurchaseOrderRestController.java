package be.kdg.sa.controller.api;

import be.kdg.sa.controller.dto.PurchaseOrderDto;
import be.kdg.sa.service.PurchaseOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/purchaseOrders")
public class PurchaseOrderRestController {

    private final PurchaseOrderService purchaseOrderService;
    private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderService.class);

    public PurchaseOrderRestController(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    @GetMapping("")
    public Collection<PurchaseOrderDto> getPurchaseOrders() {
        return purchaseOrderService.findAllOrders();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void receivePurchaseOrder(@RequestBody PurchaseOrderDto purchaseOrderDto) {
        logger.info("Receiving PurchaseOrderDto: " + purchaseOrderDto.getVesselNumber());
        purchaseOrderService.createOrder(purchaseOrderDto);

    }

}
