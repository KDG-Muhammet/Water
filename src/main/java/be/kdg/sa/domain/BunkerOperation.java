package be.kdg.sa.domain;

import java.sql.Time;
import java.time.LocalDateTime;

import jakarta.persistence.*;
@Entity
public class BunkerOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String vesselNumber;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public BunkerOperation(String vesselNumber, LocalDateTime startTime) {
        this.vesselNumber = vesselNumber;
        this.startTime = startTime;
        this.endTime = startTime.plusHours(4); // bo duurt 4 uur
    }

    public BunkerOperation() {

    }

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
}
