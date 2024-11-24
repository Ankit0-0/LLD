package org.LLD;

import org.LLD.entities.ParkingLot;
import org.LLD.entities.Vehicle;
import org.LLD.utils.VehicleType;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(3, 3, 3);

        Vehicle car1 = new Vehicle(1, VehicleType.CAR);
        Vehicle car2 = new Vehicle(2, VehicleType.CAR);

        System.out.println("parking car1: " + parkingLot.parkVehicle(car1));
        System.out.println("parking car2: " + parkingLot.parkVehicle(car2));



        Vehicle bike1 = new Vehicle(3, VehicleType.BIKE);
        Vehicle bike2 = new Vehicle(4, VehicleType.BIKE);
        Vehicle bike3 = new Vehicle(5, VehicleType.BIKE);
        Vehicle bike4 = new Vehicle(6, VehicleType.BIKE);

        System.out.println("parking bike1: " + parkingLot.parkVehicle(bike1));
        System.out.println("parking bike2: " + parkingLot.parkVehicle(bike2));
        System.out.println("parking bike3: " + parkingLot.parkVehicle(bike3));
        System.out.println("parking bike4: " + parkingLot.parkVehicle(bike4));

        System.out.println("removing bike3: " + parkingLot.removeVehicle(3));

        System.out.println("parking bike4: " + parkingLot.parkVehicle(bike4));



//        Vehicle bus1 = new Vehicle(7, VehicleType.BUS);

    }
}