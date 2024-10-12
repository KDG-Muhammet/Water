package be.kdg.sa.controller.dto;

import be.kdg.sa.domain.Ship;

import java.util.Date;

public class ShipDto {

    private String vesselNumber;
    private String name;
    private Date arrivalTime;


    public ShipDto(Ship ship) {
        this.vesselNumber = ship.getVesselNumber();
        this.name = ship.getName();
        this.arrivalTime = ship.getArrivalTime();
    }

    public ShipDto() {

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

}
