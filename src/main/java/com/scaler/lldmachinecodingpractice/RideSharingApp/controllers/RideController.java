package com.scaler.lldmachinecodingpractice.RideSharingApp.controllers;

import com.scaler.lldmachinecodingpractice.RideSharingApp.models.*;
//import com.scaler.lldmachinecodingpractice.RideSharingApp.services.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class RideController {


    private static RideController instance;
    private Map<Integer, User> users;
    private Map<Integer, Driver> drivers;

    private RideController(){
        users = new ConcurrentHashMap<>();
        drivers = new ConcurrentHashMap<>();
    }

    public static synchronized RideController getInstance(){
        if(instance==null){
            instance = new RideController();
        }
        return instance;
    }

    Scanner scn = new Scanner(System.in);

    //add users
    public User addUsers(){
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("Sandhya");
        user1.setUserPhoneNumber("123");
        users.put(user1.getUserId(), user1);
        System.out.println("List of users: \n" +user1.getUserName());
        return user1;
    }

    //add drivers
    public Driver addDrivers(){
        Driver driver = new Driver();
        driver.setDriverId(1);
        driver.setDriverName("DollyDriver");
        driver.setDriverVehicleNumber("1122");
        driver.setDriverVehicleModel("SUV");
        driver.setDriverPhoneNumber("9999");
        drivers.put(driver.getDriverId(), driver);
        System.out.println("List of drivers: \n"+driver.getDriverName());
        return driver;
    }

    //show vehicles
    public List<String> showVehicles(){
        List<String> availablevehicles = new ArrayList<>();
        availablevehicles.add("Auto");
        availablevehicles.add("Bike");
        availablevehicles.add("SUV");
        availablevehicles.add("Indica");
        System.out.println("Showing availabble Vehicles: \n" + availablevehicles);
        return availablevehicles;
    }

    //req ride
    public Ride rideRequest(){
        System.out.println("Enter Pickup point");
        String pickupPoint = scn.nextLine();
        System.out.println("Enter Destination point");
        String destinationPoint = scn.nextLine();
        System.out.println("Enter Kms");
        long kms = scn.nextLong();
        scn.nextLine();
        System.out.println("Enter VehicleType");
        String vehicleTypeInput = scn.nextLine();

        //calculate price
        //below 10 = SUV = 30, auto = 20, bike = 10, indica = 25
        double estimatedPrice = 0;
        VehicleType  vehicleType = VehicleType.valueOf(vehicleTypeInput);
        if(vehicleType.equals(VehicleType.SUV)){
            if(kms<=10){
                estimatedPrice = kms*30;
                System.out.println("Estimated Price for the VehicleType "+vehicleType+" is "+estimatedPrice);
            }else{
                estimatedPrice = kms*50;
                System.out.println("Estimated Price for the VehicleType "+vehicleType+" is "+estimatedPrice);
            }
        }
        if(vehicleType.equals(VehicleType.AUTO)){
            if(kms<=10){
                estimatedPrice = kms*20;
                System.out.println("Estimated Price for the VehicleType "+vehicleType+" is "+estimatedPrice);
            }else{
                estimatedPrice = kms*40;
                System.out.println("Estimated Price for the VehicleType "+vehicleType+" is "+estimatedPrice);
            }
        }
        if(vehicleType.equals(VehicleType.BIKE)){
            if(kms<=10){
                estimatedPrice = kms*10;
                System.out.println("Estimated Price for the VehicleType "+vehicleType+" is "+estimatedPrice);
            }else{
                estimatedPrice = kms*30;
                System.out.println("Estimated Price for the VehicleType "+vehicleType+" is "+estimatedPrice);
            }
        }
        if(vehicleType.equals(VehicleType.INDICA)){
            if(kms<=10){
                estimatedPrice = kms*25;
                System.out.println("Estimated Price for the VehicleType "+vehicleType+" is "+estimatedPrice);
            }else{
                estimatedPrice = kms*45;
                System.out.println("Estimated Price for the VehicleType "+vehicleType+" is "+estimatedPrice);
            }
        }
        Ride ride = new Ride();
        ride.setUser(users.get(1));
        ride.setDriver(drivers.get(1));
        ride.setPickupLocation(pickupPoint);
        ride.setDropLocation(destinationPoint);
        ride.setPrice(estimatedPrice);
        return ride;
    }

    //acceptARide
    public void acceptRide(Ride ride){
        System.out.println("Please confirm booking Yes or No");
        String acceptOrReject = scn.nextLine();
        if(acceptOrReject.equalsIgnoreCase("Yes")){
            ride.setRideStatus(RideStatus.ACCEPTED);
            System.out.println("Ride Accepted. Details:\n"
                    + "User: " + ride.getUser().getUserName() + "\n"
                    + "Driver: " + ride.getDriver().getDriverName()+ "\n"
                    + "Pickup Location: " + ride.getPickupLocation() + "\n"
                    + "Drop Location: " + ride.getDropLocation() + "\n"
                    + "Price: " + ride.getPrice());
        } else {
            System.out.println("Ride was not accepted.");
        }
    }


    //startARide


    //completeARide


    //cancelARide


    //notifyDrivers


    //notifyPassengers



    //showPriceCalculation



    //showDistanceCalculation


    //show rideDetails


    //paymentDetails


}
