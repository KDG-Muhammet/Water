package be.kdg.sa.repository;


import be.kdg.sa.domain.DokOperation;
import be.kdg.sa.domain.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DORepository extends JpaRepository<DokOperation, UUID> {
}
