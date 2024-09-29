package be.kdg.sa.service;

import be.kdg.sa.domain.*;
import be.kdg.sa.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    public static final Map<String, PurchaseOrder> purchaseOrders = new HashMap<>(Map.of(
            "muhammet", new PurchaseOrder(123, "test1324",
                    new Date(2020, 5, 5),
                    "ship1234",
                    new Seller(1, "justin", "test-jutin"),
                    new Buyer(123, "muhammet", "straat"),
                    List.of(new OrderLine(1, new Material(999, MaterialType.CEMENT, "cement test", new BigDecimal(12), new BigDecimal(23)), 20)))
            ));


    public Collection<PurchaseOrder> getAllOrders() {
        return purchaseOrderRepository.findAll();
    }

    public PurchaseOrder addOrder(PurchaseOrder purchaseOrder) {
        return purchaseOrderRepository.save( purchaseOrder);
    }

}
