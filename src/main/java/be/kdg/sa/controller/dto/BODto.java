package be.kdg.sa.controller.dto;

import be.kdg.sa.domain.enums.Status;

import java.time.LocalDateTime;

public class BODto {

    private String vesselNumber;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Status bunkerStatus;

    public String getVesselNumber() {
        return vesselNumber;
    }

    public void setVesselNumber(String vesselNumber) {
        this.vesselNumber = vesselNumber;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Status getBunkerStatus() {
        return bunkerStatus;
    }

    public void setBunkerStatus(Status bunkerStatus) {
        this.bunkerStatus = bunkerStatus;
    }
}
