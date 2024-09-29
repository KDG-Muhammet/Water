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

    public OrderLine(int orderLineId, Material material, int amount) {
        this.orderLineId = orderLineId;
        this.material = material;
        this.amount = amount;
    }

    public int getOrderLineId() {
        return orderLineId;
    }

    public int getAmount() {
        return amount;
    }

    public Material getMaterial() {
        return material;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

}
