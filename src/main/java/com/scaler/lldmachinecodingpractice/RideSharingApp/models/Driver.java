package com.scaler.lldmachinecodingpractice.RideSharingApp.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Driver {
    private int DriverId;
    private String DriverName;
    private String DriverVehicleNumber;
    private String DriverVehicleModel;
    private String DriverPhoneNumber;

//    public Driver(int driverId, String driverName, String driverVehicleNumber, String driverVehicleModel, String driverPhoneNumber) {
//        DriverId = driverId;
//        DriverName = driverName;
//        DriverVehicleNumber = driverVehicleNumber;
//        DriverVehicleModel = driverVehicleModel;
//        DriverPhoneNumber = driverPhoneNumber;
//    }
}


