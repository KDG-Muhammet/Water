package be.kdg.sa.service;

import be.kdg.sa.controller.dto.IODto;
import be.kdg.sa.domain.InspectionOperation;
import be.kdg.sa.domain.enums.Status;
import be.kdg.sa.repository.IORepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class IOService {

    private final IORepository ioRepository;

    private final ModelMapper modelMapper;

    public IOService(IORepository ioRepository, ModelMapper modelMapper) {
        this.ioRepository = ioRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public void createIo(InspectionOperation inspectionOperation) {
        ioRepository.save(inspectionOperation);

    }

    @Transactional(readOnly = true)
    public Collection<IODto> findIOs() {
        Collection<InspectionOperation> inspectionOperations = ioRepository.findAll();
        return inspectionOperations.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    private IODto convertToDto(InspectionOperation inspectionOperation) {
        return modelMapper.map(inspectionOperation, IODto.class);
    }

    @Transactional
    public void performInspection(String inspectionNumber) {
       InspectionOperation inspectionOperation = ioRepository.findInspectionOperationByInspectionNumber(inspectionNumber);
       inspectionOperation.setInspectionStatus(Status.INSPECTION_SUCCESS);
       ioRepository.save(inspectionOperation);
    }
}
