package be.kdg.sa.service;

import be.kdg.sa.controller.dto.ShipDto;
import be.kdg.sa.domain.Ship;
import be.kdg.sa.repository.ShipRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ShipService {

    private final ShipRepository shipRepository;

    public ShipService(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    public Collection<ShipDto> getAllShips() {
        Collection<Ship> ships = shipRepository.findAll();
        List<ShipDto> shipDtos = new ArrayList<>();

        ships.forEach(ship -> {
            ShipDto shipDto = new ShipDto(ship);
            shipDtos.add(shipDto);
        });

        return shipDtos;

    }
    public Ship addShip(Ship ship) {
       return shipRepository.save(new Ship(ship.getVesselNumber(), ship.getName(), ship.getArrivalTime()));
    }

    public Optional<Ship> findShipByVesselNumberIfExist(String vesselNumber) {
        return shipRepository.findShipByVesselNumber(vesselNumber);
    }

    public Ship findShipByVesselNumber(String vesselNumber) {
        return shipRepository.getShipByVesselNumber(vesselNumber);
    }
}
