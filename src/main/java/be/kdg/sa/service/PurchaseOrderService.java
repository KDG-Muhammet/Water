package be.kdg.sa.service;

import be.kdg.sa.controller.dto.PurchaseOrderDto;
import be.kdg.sa.domain.*;
import be.kdg.sa.repository.PurchaseOrderRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PurchaseOrderService {

    private final PurchaseOrderRepository purchaseOrderRepository;
    private final ShipService shipService;
    private final ModelMapper modelMapper;
    private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderService.class);

    public PurchaseOrderService(PurchaseOrderRepository purchaseOrderRepository, ShipService shipService, ModelMapper modelMapper) {
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.shipService = shipService;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public Collection<PurchaseOrderDto> findAllOrders() {
        Collection<PurchaseOrder> purchaseOrders = purchaseOrderRepository.findAll();

        purchaseOrders.forEach(purchaseOrder -> {
            if (purchaseOrder.getShip() == null) {
                Ship ship = shipService.findShipByVesselNumberIfExist(purchaseOrder.getVesselNumber())
                        .orElseGet(() -> shipService.addShip(new Ship(purchaseOrder.getVesselNumber(), "test", new Date())));
                purchaseOrder.setShip(ship);
                ship.getPurchaseOrder().add(purchaseOrder);
            }
        });
        return purchaseOrders.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private PurchaseOrderDto convertToDto(PurchaseOrder purchaseOrder) {
        return modelMapper.map(purchaseOrder, PurchaseOrderDto.class);
    }

    public void addOrder(PurchaseOrderDto purchaseOrderDto) {
        PurchaseOrder purchaseOrder = new PurchaseOrder(purchaseOrderDto.getPoNumber(),purchaseOrderDto.getVesselNumber());
        logger.info("receving po: " + "ponumber: " + purchaseOrderDto.getPoNumber() +  " vesselNumber: " +purchaseOrderDto.getVesselNumber());

        purchaseOrderRepository.save(purchaseOrder);
    }

}
