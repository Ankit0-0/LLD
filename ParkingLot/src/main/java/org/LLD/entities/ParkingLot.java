package org.LLD.entities;

import org.LLD.utils.SpotStatus;
import org.LLD.utils.SpotType;
import org.LLD.utils.VehicleType;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private final List<ParkingSpot> spots;
    private final Map<Integer, ParkingSpot> occupiedSpots;

    public ParkingLot(int smallSpots, int midSpots, int largeSpots) {
        spots = new ArrayList<>();
        occupiedSpots = new HashMap<>();

        int spotId = 1;
        for (int i = 0; i < smallSpots; i++) {
            spots.add(new ParkingSpot(spotId++, SpotType.SMALL));
        }

        for (int i = 0; i < midSpots; i++) {
            spots.add(new ParkingSpot(spotId++, SpotType.MID));
        }

        for (int i = 0; i < largeSpots; i++) {
            spots.add(new ParkingSpot(spotId++, SpotType.LARGE));
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findAvailableSpot(vehicle.getType());
        if (spot != null) {
            spot.park(vehicle);
            occupiedSpots.put(vehicle.getId(), spot);
            return true;
        }
        return false;
    }

    public int removeVehicle(int vehicleId) {
        ParkingSpot occupiedSpot = this.occupiedSpots.get(vehicleId);
        if (occupiedSpot != null) {
            return occupiedSpot.removeVehicle();
        }
        return vehicleId;
    }

    public ParkingSpot findAvailableSpot(VehicleType type) {
        SpotType requiredType = switch (type) {
            case BIKE -> SpotType.SMALL;
            case CAR -> SpotType.MID;
            case BUS -> SpotType.LARGE;
        };

        return spots.stream()
                .filter(spot -> spot.getSpotType() == requiredType && spot.getSpotStatus() == SpotStatus.VACANT)
                .findFirst()
                .orElse(null);

    }

    public int getAvailableSpots() {
        return (int) spots.stream()
                .filter(spot -> spot.getSpotStatus() == SpotStatus.VACANT)
                .count();
    }
}
