package be.kdg.sa.domain;

import jakarta.persistence.*;

@Entity
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderLineId;
    private int amount;

    @OneToOne
    private Material material;
    @ManyToOne
    private PurchaseOrder purchaseOrder;





}
