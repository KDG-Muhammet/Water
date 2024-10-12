package be.kdg.sa.repository;

import be.kdg.sa.domain.Ship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShipRepository extends JpaRepository<Ship, Integer> {

    Optional<Ship> findShipByVesselNumber(String vesselNumber);
    Ship getShipByVesselNumber(String vesselNumber);

}
