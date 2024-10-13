package be.kdg.sa.service;

import be.kdg.sa.controller.dto.BODto;
import be.kdg.sa.controller.dto.IODto;
import be.kdg.sa.domain.BunkerOperation;
import be.kdg.sa.domain.InspectionOperation;
import be.kdg.sa.domain.enums.Status;
import be.kdg.sa.repository.BORepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class BOService {

    private final BORepository boRepository;
    private final ModelMapper modelMapper;

    private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderService.class);

    private static final int MAX_BUNKER_OPERATIONS = 6;

    public BOService(BORepository boRepository, ModelMapper modelMapper) {
        this.boRepository = boRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public void createBo(BunkerOperation bunkerOperation) {
        boRepository.save(bunkerOperation);

    }

    @Transactional(readOnly = true)
    public Collection<BODto> findBOs() {
        Collection<BunkerOperation> bunkerOperations = boRepository.findAll();
        return bunkerOperations.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private BODto convertToDto(BunkerOperation bunkerOperation) {
        return modelMapper.map(bunkerOperation, BODto.class);
    }

    @Transactional
    public void performBunker(String vesselNumber) {
        LocalDateTime startOfDay = LocalDateTime.now().toLocalDate().atStartOfDay();
        LocalDateTime endOfDay = startOfDay.plusDays(1);
        long bunkerCountToday = boRepository.countByStartTimeBetween(startOfDay, endOfDay);
        if (bunkerCountToday >= MAX_BUNKER_OPERATIONS) {
            logger.warn("Max bunker operations reached for today ({} operations)", MAX_BUNKER_OPERATIONS);
            throw new IllegalStateException("Max bunker operations reached for today");
        }

        BunkerOperation bunkerOperation = boRepository.findBunkerOperationByVesselNumber(vesselNumber);
        bunkerOperation.setBunkerStatus(Status.BUNKER_SUCCESS);
        bunkerOperation.setStartTime(LocalDateTime.now());
        bunkerOperation.setEndTime(LocalDateTime.now().plusHours(4));
        boRepository.save(bunkerOperation);
    }
}
