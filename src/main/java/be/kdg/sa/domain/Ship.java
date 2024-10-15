package be.kdg.sa.domain;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String vesselNumber;
    private String name;
    private Date arrivalTime;

    @OneToOne(mappedBy = "ship", cascade = CascadeType.ALL)
    private PurchaseOrder purchaseOrder;

    @OneToOne
    private DokOperation dokOperation;

    protected Ship() {
    }

    public Ship(String vesselNumber, String name, Date arrivalTime) {
        this.vesselNumber = vesselNumber;
        this.name = name;
        this.arrivalTime = arrivalTime;
    }

    public UUID getId() {
        return uuid;
    }

    public void setId(UUID uuid) {
        this.uuid = uuid;
    }

    public String getVesselNumber() {
        return vesselNumber;
    }

    public void setVesselNumber(String vesselNumber) {
        this.vesselNumber = vesselNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }


    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public DokOperation getDokOperation() {
        return dokOperation;
    }

    public void setDokOperation(DokOperation dokOperation) {
        this.dokOperation = dokOperation;
    }
}
