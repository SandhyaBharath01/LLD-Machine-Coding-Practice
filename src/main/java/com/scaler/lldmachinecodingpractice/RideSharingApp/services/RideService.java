package com.scaler.lldmachinecodingpractice.RideSharingApp.services;


import com.scaler.lldmachinecodingpractice.RideSharingApp.models.*;
//import com.scaler.lldmachinecodingpractice.RideSharingApp.repositories.DriverRepo;
//import com.scaler.lldmachinecodingpractice.RideSharingApp.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RideService {

    private static RideService instance;
    private  Map<String, User> users;
    private  Map<String, Driver> drivers;
    private  Map<Integer, Ride> rides;

    private RideService(){
        users = new ConcurrentHashMap<>();
        drivers = new ConcurrentHashMap<>();
    }
    public static synchronized RideService getInstance(){
        if(instance==null){
            instance = new RideService();
        }
        return instance;
    }
    //add users
    public void addUsers(User user){
        users.put(user.getUserId(), user);
    }
    //add drivers
    public void addDrivers(Driver driver){
        drivers.put(driver.getDriverId(), driver);
    }
    //estimated price
    public double ridePrice(int kms, VehicleType vehicleType){
        double estimatedPrice = 0;
        if(vehicleType.equals(VehicleType.SUV)) {
            if (kms <= 10) {
                estimatedPrice = kms * 40;
                System.out.println("Estimated price for the Vehicle " + vehicleType + " is " + estimatedPrice);
            } else {
                estimatedPrice = kms * 60;
                System.out.println("Estimated price for the Vehicle " + vehicleType + " is " + estimatedPrice);
            }
        }

        if(vehicleType.equals(VehicleType.AUTO)) {
            if (kms <= 10) {
                estimatedPrice = kms * 30;
                System.out.println("Estimated price for the Vehicle " + vehicleType + " is " + estimatedPrice);
            } else {
                estimatedPrice = kms * 50;
                System.out.println("Estimated price for the Vehicle " + vehicleType + "is " + estimatedPrice);
            }
        }

        if(vehicleType.equals(VehicleType.BIKE)) {
            if (kms <= 10) {
                estimatedPrice = kms * 20;
                System.out.println("Estimated price for the Vehicle " + vehicleType + " is " + estimatedPrice);
            } else {
                estimatedPrice = kms * 40;
                System.out.println("Estimated price for the Vehicle " + vehicleType + " is " + estimatedPrice);
            }
        }

        if(vehicleType.equals(VehicleType.INDICA)) {
            if (kms <= 10) {
                estimatedPrice = kms * 10;
                System.out.println("Estimated price for the Vehicle " + vehicleType + " is " + estimatedPrice);
            } else {
                estimatedPrice = kms * 30;
                System.out.println("Estimated price for the Vehicle " + vehicleType + " is " + estimatedPrice);
            }
        }
        return estimatedPrice;
    }

    public void acceptRide(){
        Ride ride = new Ride();
        ride.setRideStatus(RideStatus.ACCEPTED);
        ride.setPickupLocation(ride.getPickupLocation());
        ride.setDropLocation(ride.getDropLocation());
        ride.setUser(ride.getUser());
        ride.setDriver(ride.getDriver());
        ride.setPrice(ride.getPrice());
    }
    public void startRide(){
        Ride ride = new Ride();
        if(ride.getRideStatus()!=null && ride.getRideStatus().equals(RideStatus.ACCEPTED)){
            ride.setRideStatus(RideStatus.ONGOING);
            System.out.println("Ride started");
        }
    }
    public void cancelRide(){
        Ride ride = new Ride();
        if(ride.getRideStatus()!=null && ride.getRideStatus().equals(RideStatus.ONGOING)){
            ride.setRideStatus(RideStatus.CANCELLED);
        }
    }
}
