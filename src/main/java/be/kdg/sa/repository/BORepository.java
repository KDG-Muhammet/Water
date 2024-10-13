package be.kdg.sa.repository;

import be.kdg.sa.domain.BunkerOperation;
import be.kdg.sa.domain.InspectionOperation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public interface BORepository extends JpaRepository<BunkerOperation, UUID> {

    BunkerOperation findBunkerOperationByVesselNumber(String vesselNumber);

    int countByStartTimeBetween(LocalDateTime startOfDay, LocalDateTime endOfDay);
}
