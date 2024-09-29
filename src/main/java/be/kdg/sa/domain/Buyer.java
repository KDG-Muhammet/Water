package be.kdg.sa.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;

    public Buyer(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Buyer() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
