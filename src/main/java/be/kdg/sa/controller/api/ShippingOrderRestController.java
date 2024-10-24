package be.kdg.sa.controller.api;

import be.kdg.sa.controller.dto.PurchaseOrderDto;
import be.kdg.sa.service.po.ShippingOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shippingOrders")
public class ShippingOrderRestController {

    private final ShippingOrderService shippingOrderService;
    private static final Logger logger = LoggerFactory.getLogger(ShippingOrderService.class);

    public ShippingOrderRestController(ShippingOrderService shippingOrderService) {
        this.shippingOrderService = shippingOrderService;
    }
    @PostMapping("")
    @PreAuthorize("hasAuthority('captain')")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> sendShippingOrder(@RequestBody PurchaseOrderDto purchaseOrderDto) {
        logger.info("sending ShippingOrder with poNumber: " + purchaseOrderDto.getPoNumber());
       return shippingOrderService.sendShippingOrderToWarehouse(purchaseOrderDto);

    }


}
