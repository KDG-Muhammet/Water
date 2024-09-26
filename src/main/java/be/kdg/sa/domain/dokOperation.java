package be.kdg.sa.domain;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
public class dokOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID POid;
    private String vesselNumber;
    private Date arrivalTime;
    private Date departureTime;

    @OneToMany
    private List<inspectionOperation> ioList;

    @OneToMany
    private List<bunkerOperation> boList;

    public UUID getPOid() {
        return POid;
    }

    public void setPOid(UUID POid) {
        this.POid = POid;
    }

    public String getVesselNumber() {
        return vesselNumber;
    }

    public void setVesselNumber(String vesselNumber) {
        this.vesselNumber = vesselNumber;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public List<inspectionOperation> getIoList() {
        return ioList;
    }

    public void setIoList(List<inspectionOperation> ioList) {
        this.ioList = ioList;
    }

    public List<bunkerOperation> getBoList() {
        return boList;
    }

    public void setBoList(List<bunkerOperation> boList) {
        this.boList = boList;
    }
}
