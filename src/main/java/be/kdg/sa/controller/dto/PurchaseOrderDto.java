package be.kdg.sa.controller.dto;

import be.kdg.sa.domain.PurchaseOrder;

public class PurchaseOrderDto {
    private String poNumber;
    private String vesselNumber;

    // Constructors

    public PurchaseOrderDto(PurchaseOrder purchaseOrder) {
        this.poNumber = purchaseOrder.getPoNumber();
        this.vesselNumber = purchaseOrder.getVesselNumber();
    }

    public PurchaseOrderDto() {
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
}

