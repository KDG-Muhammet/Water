package be.kdg.sa.domain;

import java.util.Date;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
public class inspectionOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int inspectionOperationId;
    private Date date;

    public int getInspectionOperationId() {
        return inspectionOperationId;
    }

    public void setInspectionOperationId(int inspectionOperationId) {
        this.inspectionOperationId = inspectionOperationId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
