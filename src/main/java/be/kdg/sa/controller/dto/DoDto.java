package be.kdg.sa.controller.dto;

public class DoDto {
    private String poNumber;
    private String vesselNumber;


    public DoDto(String poNumber, String vesselNumber) {
        this.poNumber = poNumber;
        this.vesselNumber = vesselNumber;
    }

    public DoDto() {
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
