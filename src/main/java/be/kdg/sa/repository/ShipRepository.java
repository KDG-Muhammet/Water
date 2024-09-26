package be.kdg.sa.repository;

import be.kdg.sa.domain.Ship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShipRepository extends JpaRepository<Ship, UUID> {
}
