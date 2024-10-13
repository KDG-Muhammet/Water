package be.kdg.sa.controller.dto;

import be.kdg.sa.domain.enums.Status;

import java.time.LocalDateTime;

public class IODto {
    private LocalDateTime inspectionTime;
    private String inspectionNumber;
    private Status inspectionStatus;

    public LocalDateTime getInspectionTime() {
        return inspectionTime;
    }

    public void setInspectionTime(LocalDateTime inspectionTime) {
        this.inspectionTime = inspectionTime;
    }

    public String getInspectionNumber() {
        return inspectionNumber;
    }

    public void setInspectionNumber(String inspectionNumber) {
        this.inspectionNumber = inspectionNumber;
    }

    public Status getInspectionStatus() {
        return inspectionStatus;
    }

    public void setInspectionStatus(Status inspectionStatus) {
        this.inspectionStatus = inspectionStatus;
    }
}
