package be.kdg.sa.domain;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID referenceUUID;

    @Column(unique = true)
    private String poNumber;
    private String vesselNumber;

    @ManyToOne
    private Ship ship;

    public PurchaseOrder(String poNumber, String vesselNumber) {
        this.poNumber = poNumber;
        this.vesselNumber = vesselNumber;
    }

    protected PurchaseOrder() {
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }


    public String getVesselNumber() {
        return vesselNumber;
    }

    public void setVesselNumber(String vesselNumber) {
        this.vesselNumber = vesselNumber;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
