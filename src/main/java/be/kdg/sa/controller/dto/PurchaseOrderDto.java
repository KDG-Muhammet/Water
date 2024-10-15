package be.kdg.sa.controller.dto;


public class PurchaseOrderDto {
    private String poNumber;
    private String vesselNumber;

    public PurchaseOrderDto() {
    }

    public PurchaseOrderDto(String vesselNumber, String poNumber) {
        this.poNumber = poNumber;
        this.vesselNumber = vesselNumber;
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

