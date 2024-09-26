package be.kdg.sa.domain;

import java.sql.Time;
import jakarta.persistence.*;
@Entity
public class bunkerOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String vesselNumber;
    private Time time;

    public String getVesselNumber() {
        return vesselNumber;
    }

    public void setVesselNumber(String vesselNumber) {
        this.vesselNumber = vesselNumber;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
