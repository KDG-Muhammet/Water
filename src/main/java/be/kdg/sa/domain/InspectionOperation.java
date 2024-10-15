package be.kdg.sa.domain;

import java.time.LocalDateTime;
import java.util.UUID;
import be.kdg.sa.domain.enums.Status;
import jakarta.persistence.*;

@Entity
public class InspectionOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private LocalDateTime inspectionTime;
    private String inspectionNumber;
    @Enumerated(EnumType.STRING)
    private Status inspectionStatus;
    @OneToOne
    private DokOperation dokOperation;

    public InspectionOperation(LocalDateTime inspectionTime, String inspectionNumber) {
        this.inspectionTime = inspectionTime;
        this.inspectionNumber = inspectionNumber;
        this.inspectionStatus = Status.PENDING;

    }

    protected InspectionOperation() {

    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    public Status getInspectionStatus() {
        return inspectionStatus;
    }

    public void setInspectionStatus(Status inspectionStatus) {
        this.inspectionStatus = inspectionStatus;
    }

    public DokOperation getDokOperation() {
        return dokOperation;
    }

    public void setDokOperation(DokOperation dokOperation) {
        this.dokOperation = dokOperation;
    }
}
