package be.kdg.sa.controller.dto;


public class PurchaseOrderDto {
    private String poNumber;

    public PurchaseOrderDto() {
    }

    public PurchaseOrderDto( String poNumber) {
        this.poNumber = poNumber;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

}

