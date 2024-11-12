package com.scaler.lldmachinecodingpractice.RideSharingApp;

import com.scaler.lldmachinecodingpractice.RideSharingApp.controllers.RideController;
import com.scaler.lldmachinecodingpractice.RideSharingApp.models.Ride;

public class Client {
    public static void main(String[] args) {
        System.out.println("Ride Sharing System staring");
        RideController rc = RideController.getInstance();
        rc.addUsers();
        rc.addDrivers();
        rc.showVehicles();
        Ride ride = rc.rideRequest();
        rc.acceptRide(ride);

    }
}
