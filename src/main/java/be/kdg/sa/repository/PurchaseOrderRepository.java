package be.kdg.sa.repository;

import be.kdg.sa.domain.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Integer>  {
}
