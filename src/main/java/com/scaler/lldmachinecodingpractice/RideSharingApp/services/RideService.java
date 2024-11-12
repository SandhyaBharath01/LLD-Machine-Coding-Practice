//package com.scaler.lldmachinecodingpractice.RideSharingApp.services;
//
//import com.scaler.lldmachinecodingpractice.RideSharingApp.models.*;
//import com.scaler.lldmachinecodingpractice.RideSharingApp.repositories.UserRepository;
//import lombok.Setter;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//@Service
//public class RideService {
//    private UserRepository userRepository;
//    private static RideService instance;
//    private Map<Integer, User> users;
//    private Map<Integer, Driver> drivers;
//
//    private RideService(){
//        users = new ConcurrentHashMap<>();
//        drivers = new ConcurrentHashMap<>();
//        this.userRepository = userRepository;
//    }
//
//    public static synchronized RideService getInstance(){
//        if(instance==null){
//            instance = new RideService();
//        }
//        return instance;
//    }
//
//    //add users
//    public User addUsers(User user){
//        users.put(user.getUserId(), user);
//        return user;
//    }
//
//    //add drivers
//    public Driver addDrivers(Driver driver){
//        drivers.put(driver.getDriverId(), driver);
//        return driver;
//    }
//
//    //show vehicles
//    public List<String> showVehicles(){
//        return List.of("SUV", "Auto", "Bike", "Indica");
//    }
//
//    //req ride
//    public Ride rideRequest(User user, Driver driver, String pickupPoint, String destinationPoint, long kms, VehicleType vehicleType){
//        //calculate price
//        //below 10 = SUV = 30, auto = 20, bike = 10, indica = 25
//        double estimatedPrice = 0;
//        if(vehicleType.equals(VehicleType.SUV)){
//            if(kms<=10){
//                estimatedPrice = kms*30;
//                System.out.println("Estimated Price for the VehicleType "+vehicleType+" is "+estimatedPrice);
//            }else{
//                estimatedPrice = kms*50;
//                System.out.println("Estimated Price for the VehicleType "+vehicleType+" is "+estimatedPrice);
//            }
//        }
//        if(vehicleType.equals(VehicleType.AUTO)){
//            if(kms<=10){
//                estimatedPrice = kms*20;
//                System.out.println("Estimated Price for the VehicleType "+vehicleType+" is "+estimatedPrice);
//            }else{
//                estimatedPrice = kms*40;
//                System.out.println("Estimated Price for the VehicleType "+vehicleType+" is "+estimatedPrice);
//            }
//        }
//        if(vehicleType.equals(VehicleType.BIKE)){
//            if(kms<=10){
//                estimatedPrice = kms*10;
//                System.out.println("Estimated Price for the VehicleType "+vehicleType+" is "+estimatedPrice);
//            }else{
//                estimatedPrice = kms*30;
//                System.out.println("Estimated Price for the VehicleType "+vehicleType+" is "+estimatedPrice);
//            }
//        }
//        if(vehicleType.equals(VehicleType.INDICA)){
//            if(kms<=10){
//                estimatedPrice = kms*25;
//                System.out.println("Estimated Price for the VehicleType "+vehicleType+" is "+estimatedPrice);
//            }else{
//                estimatedPrice = kms*45;
//                System.out.println("Estimated Price for the VehicleType "+vehicleType+" is "+estimatedPrice);
//            }
//        }
//        Ride ride = new Ride();
//        ride.setUser(user);
//        ride.setDriver(driver);
//        ride.setPickupLocation(pickupPoint);
//        ride.setDropLocation(destinationPoint);
//        ride.setPrice(estimatedPrice);
//        return ride;
//    }
//
//    //acceptARide
//    public boolean acceptRide(Ride ride, boolean isAccepted){
//        if(isAccepted){
//            ride.setRideStatus(RideStatus.ACCEPTED);
//            return true;
//        } else {
//            ride.setRideStatus(RideStatus.CANCELLED);
//            return false;
//        }
//    }
//
//
//    //req ride
//
//
//    //acceptARide
//
//
//    //startARide
//
//
//    //completeARide
//
//
//    //cancelARide
//
//
//    //notifyDrivers
//
//
//    //notifyPassengers
//
//
//
//    //showPriceCalculation
//
//
//
//    //showDistanceCalculation
//
//
//    //show rideDetails
//
//
//    //paymentDetails
//}
