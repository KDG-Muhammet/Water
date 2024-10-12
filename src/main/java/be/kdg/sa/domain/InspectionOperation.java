package be.kdg.sa.domain;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.*;

@Entity
public class InspectionOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private LocalDateTime inspectionTime;
    private String inspectionNumber;

    public InspectionOperation(LocalDateTime inspectionTime, String inspectionNumber) {
        this.inspectionTime = inspectionTime;
        this.inspectionNumber = inspectionNumber;
    }

    public InspectionOperation() {

    }

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
}
