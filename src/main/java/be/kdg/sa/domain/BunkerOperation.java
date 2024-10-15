package be.kdg.sa.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import be.kdg.sa.domain.enums.Status;
import jakarta.persistence.*;
@Entity
public class BunkerOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String vesselNumber;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @Enumerated(EnumType.STRING)
    private Status bunkerStatus;
    @OneToOne
    private DokOperation dokOperation;

    public BunkerOperation(String vesselNumber) {
        this.vesselNumber = vesselNumber;
        this.bunkerStatus = Status.PENDING;
    }

    protected BunkerOperation() {

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

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Status getBunkerStatus() {
        return bunkerStatus;
    }

    public void setBunkerStatus(Status bunkerStatus) {
        this.bunkerStatus = bunkerStatus;
    }

    public DokOperation getDokOperation() {
        return dokOperation;
    }

    public void setDokOperation(DokOperation dokOperation) {
        this.dokOperation = dokOperation;
    }
}
