package org.LLD.entities;

import lombok.Getter;
import lombok.Setter;
import org.LLD.utils.SpotStatus;
import org.LLD.utils.SpotType;

@Getter
@Setter
public class ParkingSpot {

    private int spotId;
    private SpotType spotType;
    private SpotStatus spotStatus;
    private Vehicle vehicle;

    public ParkingSpot(int spotId, SpotType type) {
        this.spotId = spotId;
        this.spotType = type;
        this.spotStatus = SpotStatus.VACANT;
    }

    public boolean park(Vehicle vehicle) {
        if (spotStatus == SpotStatus.VACANT) {
            this.vehicle = vehicle;
            this.spotStatus = SpotStatus.OCCUPIED;
            return true;
        }
        return false;
    }

    public int removeVehicle() {
        Vehicle removedVehicle = this.vehicle;
        int vehicleId = this.vehicle.getId();
        this.vehicle = null;
        this.spotStatus = SpotStatus.VACANT;
        return vehicleId;
    }
}
