package be.kdg.sa.service.po;

import be.kdg.sa.controller.dto.PurchaseOrderDto;
import be.kdg.sa.domain.*;
import be.kdg.sa.repository.ShippingOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShippingOrderService {

    private final ShippingOrderRepository shippingOrderRepository;
    private final RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(ShippingOrderService.class);

    @Value("${spring.application.warehouse.url}")
    private String WAREHOUSE_URL;

    public ShippingOrderService(ShippingOrderRepository shippingOrderRepository, RestTemplate restTemplate) {
        this.shippingOrderRepository = shippingOrderRepository;
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> sendShippingOrderToWarehouse(PurchaseOrderDto purchaseOrderDto) {
        logger.info("sending ShippingOrder with ponumber: " + purchaseOrderDto.getPoNumber());
        String fullUrl = WAREHOUSE_URL + "/shippingOrder";

        return restTemplate.postForEntity(fullUrl, purchaseOrderDto, String.class);
    }

    public ShippingOrder findShippingOrderByPoNumber(String poNumber) {
        return shippingOrderRepository.findShippingOrderByPoNumber(poNumber);
    }

}
