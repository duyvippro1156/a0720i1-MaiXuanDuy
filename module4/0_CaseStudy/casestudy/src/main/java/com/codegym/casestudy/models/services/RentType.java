package com.codegym.casestudy.models.services;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rent_type")
public class RentType {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double cost;

    @OneToMany (mappedBy = "rentType")
    private Set<Services> services;

    public RentType() {
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Set<Services> getServices() {
        return services;
    }

    public void setServices(Set<Services> services) {
        this.services = services;
    }
}
