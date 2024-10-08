package be.kdg.sa.service;

import be.kdg.sa.controller.dto.PurchaseOrderDto;
import be.kdg.sa.domain.*;
import be.kdg.sa.repository.PurchaseOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PurchaseOrderService {

    private PurchaseOrderRepository purchaseOrderRepository;
    private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderService.class);

    public PurchaseOrderService(PurchaseOrderRepository purchaseOrderRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
    }


    public Collection<PurchaseOrder> getAllOrders() {
        return purchaseOrderRepository.findAll();
    }

    public void addOrder(PurchaseOrderDto purchaseOrderDto) {
        PurchaseOrder purchaseOrder = new PurchaseOrder(purchaseOrderDto.getPoNumber(),purchaseOrderDto.getVesselNumber());
        logger.info("receving po: " + "ponumber: " + purchaseOrderDto.getPoNumber() +  " vesselNumber: " +purchaseOrderDto.getVesselNumber());

        purchaseOrderRepository.save(purchaseOrder);
    }

}
