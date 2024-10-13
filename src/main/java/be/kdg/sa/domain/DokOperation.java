package be.kdg.sa.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import be.kdg.sa.domain.enums.Status;
import jakarta.persistence.*;

@Entity
public class DokOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToOne
    private Ship ship;

    @OneToOne(cascade = CascadeType.ALL)
    private InspectionOperation inspectionOperation;

    @OneToOne(cascade = CascadeType.ALL)
    private BunkerOperation bunkerOperation;


    public DokOperation(LocalDateTime arrivalTime, Ship ship, LocalDateTime departureTime) {
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.ship = ship;
        this.status = Status.PENDING;
    }

    protected DokOperation() {

    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public InspectionOperation getInspectionOperation() {
        return inspectionOperation;
    }

    public void setInspectionOperation(InspectionOperation inspectionOperation) {
        this.inspectionOperation = inspectionOperation;
    }

    public BunkerOperation getBunkerOperation() {
        return bunkerOperation;
    }

    public void setBunkerOperation(BunkerOperation bunkerOperation) {
        this.bunkerOperation = bunkerOperation;
    }
}
