package com.scaler.lldmachinecodingpractice.CarRentalSystem.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
    private String make;
    private String model;
    private String year;
    private String licensePlateNumber;
    private double pricePerDay;
    private boolean isAvailable;

    public Car(String make, String model, String year, String licensePlateNumber, double pricePerDay) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.licensePlateNumber = licensePlateNumber;
        this.pricePerDay = pricePerDay;
        this.isAvailable = true;
    }

}
