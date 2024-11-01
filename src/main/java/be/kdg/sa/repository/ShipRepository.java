package be.kdg.sa.repository;

import be.kdg.sa.domain.Ship;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShipRepository extends JpaRepository<Ship, Integer> {

    Ship getShipByVesselNumber(String vesselNumber);

}
