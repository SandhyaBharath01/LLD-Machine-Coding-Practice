package com.scaler.lldmachinecodingpractice.RideSharingApp;

//import com.scaler.lldmachinecodingpractice.RideSharingApp.controllers.RideController;
//import com.scaler.lldmachinecodingpractice.RideSharingApp.controllers.RideController;
import com.scaler.lldmachinecodingpractice.RideSharingApp.models.*;
import com.scaler.lldmachinecodingpractice.RideSharingApp.services.RideService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


public class Client {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {

        RideService rs = RideService.getInstance();
        System.out.println("Ride Sharing System staring");

        User user1 = new User("1","Sandhya", "9392");
        User user2 = new User("2", "Bharath", "9939");
        Driver driver1 = new Driver("1","Driver1", "TS2222", "SUV", "1111");
        Driver driver2 = new Driver("2","Driver2", "TS3333", "Indica", "1234");

        //add users
//        System.out.println("List of users");
        rs.addUsers(user1);
        rs.addUsers(user2);
        //add drivers
//        System.out.println("List of drivers");
        rs.addDrivers(driver1);
        rs.addDrivers(driver2);

        //req ride
        System.out.println("Enter Pickup point");
        String pickup = scn.nextLine();

        System.out.println("Enter Drop point");
        String dropPoint = scn.nextLine();

        System.out.println("Enter kms");
        int kms = scn.nextInt();
        scn.nextLine();

        //Show vehicles
        System.out.println("The available Vehicles are:- SUV, AUTO, BIKE, INDICA");
        System.out.println("Select VehicleType");
        String vehicleTypeInput = scn.nextLine();
        VehicleType vehicleType = VehicleType.valueOf(vehicleTypeInput);

        System.out.println("Vehicle Details for the User "+ user1.getUserName()+"\n"+
                "and the driver is "+driver1.getDriverName()+"\n"+
                "from "+pickup+"\n"+
                "to "+dropPoint);
        rs.ridePrice(kms, vehicleType);

        //accept Ride
        System.out.println("Do you want to accept ride say Yes/No");
        String acceptornot = scn.nextLine();
        if(acceptornot.equalsIgnoreCase("yes")){
            rs.acceptRide();
            System.out.println("Ride was " + RideStatus.ACCEPTED +" by the Driver "+driver2.getDriverName());
        }else{
            System.out.println("Ride declined");
        }
        rs.startRide();
        System.out.println("Do you want to cancel the ride ");
        String cancel = scn.nextLine();
        if(cancel.equalsIgnoreCase("yes")){
            rs.cancelRide();
            System.out.println("Ride has been cancelled");
        }else{
            System.out.println("Ride is going on ");
        }


    }
}
