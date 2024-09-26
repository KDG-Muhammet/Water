package be.kdg.sa.repository;

import be.kdg.sa.domain.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BuyerRepository extends JpaRepository<Buyer, UUID> {
}
