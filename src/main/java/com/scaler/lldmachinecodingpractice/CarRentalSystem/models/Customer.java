package com.scaler.lldmachinecodingpractice.CarRentalSystem.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    private String name;
    private String contactNumber;
    private String drivingLicenseNumber;
    public Customer(String name, String contactNumber, String drivingLicenseNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.drivingLicenseNumber = drivingLicenseNumber;
    }
}
