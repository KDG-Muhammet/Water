package be.kdg.sa.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private MaterialType type;
    private String description;
    private BigDecimal storagePrice;
    private BigDecimal sellingPrice;

    public Material(int id, MaterialType type, String description, BigDecimal storagePrice, BigDecimal sellingPrice) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.storagePrice = storagePrice;
        this.sellingPrice = sellingPrice;
    }

    public Material() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MaterialType getType() {
        return type;
    }

    public void setType(MaterialType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getStoragePrice() {
        return storagePrice;
    }

    public void setStoragePrice(BigDecimal storagePrice) {
        this.storagePrice = storagePrice;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

}
