package org.LLD.entities;

import lombok.Getter;
import lombok.Setter;
import org.LLD.utils.VehicleType;

@Getter
@Setter
public class Vehicle {
    private int id;
    private VehicleType type;

    public Vehicle(int id, VehicleType type) {
        this.id = id;
        this.type = type;
    }
}

