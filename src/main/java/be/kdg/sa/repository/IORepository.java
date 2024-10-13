package be.kdg.sa.repository;

import be.kdg.sa.domain.InspectionOperation;
import be.kdg.sa.domain.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IORepository extends JpaRepository<InspectionOperation, UUID>  {

    InspectionOperation findInspectionOperationByInspectionNumber(String inspectionNumber);

}
