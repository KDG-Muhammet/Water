package be.kdg.sa.service.po;

import be.kdg.sa.controller.dto.PurchaseOrderDto;
import be.kdg.sa.domain.PurchaseOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PurchaseOrderSenderService {

    private final RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderService.class);
    private static final String WAREHOUSE_APP_URL = "http://localhost:8081/api/purchaseOrder";


    public PurchaseOrderSenderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void sendFulfilledPOToWarehouse(PurchaseOrder purchaseOrder) {
        PurchaseOrderDto requestDto = new PurchaseOrderDto(purchaseOrder.getVesselNumber(), purchaseOrder.getPoNumber());
        logger.info("sending po: " + "ponumber: " + purchaseOrder.getPoNumber() +  " vesselNumber: " + purchaseOrder.getVesselNumber());

        restTemplate.postForEntity(WAREHOUSE_APP_URL, requestDto, String.class);
    }
}
