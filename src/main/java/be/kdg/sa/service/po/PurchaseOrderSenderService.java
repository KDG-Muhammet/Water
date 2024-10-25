package be.kdg.sa.service.po;

import be.kdg.sa.controller.dto.PurchaseOrderDto;
import be.kdg.sa.domain.ShippingOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PurchaseOrderSenderService {

    private final RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderSenderService.class);

    @Value("${spring.application.warehouse.url}")
    private String WAREHOUSE_URL;


    public PurchaseOrderSenderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendFulfilledPOToWarehouse(ShippingOrder shippingOrder) {
        PurchaseOrderDto requestDto = new PurchaseOrderDto(shippingOrder.getPoNumber());
        logger.info("sending po: " + "ponumber: " + shippingOrder.getPoNumber());
        String fullUrl = WAREHOUSE_URL + "/purchaseOrder";

        restTemplate.postForEntity(fullUrl, requestDto, String.class);
    }
}
