package be.kdg.sa.service;

import be.kdg.sa.controller.dto.ShipDto;
import be.kdg.sa.domain.Ship;
import be.kdg.sa.repository.ShipRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class ShipService {

    private final ShipRepository shipRepository;

    public ShipService(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    @Transactional(readOnly = true)
    public Ship findShipByVesselNumber(String vesselNumber) {
        return shipRepository.getShipByVesselNumber(vesselNumber);
    }

    @Transactional(readOnly = true)
    public Collection<ShipDto> findAllShips() {
        Collection<Ship> ships = shipRepository.findAll();
        List<ShipDto> shipDtos = new ArrayList<>();

        ships.forEach(ship -> {
            ShipDto shipDto = new ShipDto(ship);
            shipDtos.add(shipDto);
        });

        return shipDtos;

    }

}
