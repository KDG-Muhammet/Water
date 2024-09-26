package be.kdg.sa.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Type type;
    private String description;
    private int storagePrice;
    private int StoragePrice;

    @OneToOne
    private OrderLine orderLine;

}
