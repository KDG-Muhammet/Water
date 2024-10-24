package be.kdg.sa.domain;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class ShippingOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID referenceUUID;

    @Column(unique = true)
    private String poNumber;

    @OneToOne
    private Ship ship;

    public ShippingOrder(String poNumber) {
        this.poNumber = poNumber;
    }

    protected ShippingOrder() {
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
