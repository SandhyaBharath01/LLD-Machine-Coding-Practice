package com.scaler.lldmachinecodingpractice.RideSharingApp.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ride {
    private int rideId;
    private String pickupLocation;
    private String dropLocation;
    private String pickupTime;
    private String dropTime;
    private double price;
    private User user;
    private VehicleType vehicleType;
    private RideStatus rideStatus;
    private Driver driver;
}
