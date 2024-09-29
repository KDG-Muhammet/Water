package be.kdg.sa.controller.api;

import be.kdg.sa.controller.dto.PurchaseOrderDto;
import be.kdg.sa.service.PurchaseOrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchaseOrders")
public class PurchaseOrderRestController {

    private PurchaseOrderService purchaseOrderService;
    public PurchaseOrderRestController(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    @GetMapping("")
    public List<PurchaseOrderDto> getPurchaseOrders() {
        return purchaseOrderService.getAllOrders().stream().map(PurchaseOrderDto::new).toList();
    }
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public PurchaseOrderDto addPurchaseOrder(@RequestBody @Valid PurchaseOrderDto purchaseOrderDto){
        return new PurchaseOrderDto(purchaseOrderService.addOrder(purchaseOrderDto.toSource()));
    }



}
