package com.scaler.lldmachinecodingpractice.CarRentalSystem.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
public class Reservation {
    private String reservationID;
    private Customer customer;
    private Car car;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalAmount;
    public Reservation(String reservationID, Customer customer, Car car, LocalDate startDate, LocalDate endDate) {
        this.reservationID = reservationID;
        this.customer = customer;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalAmount = calculateTotalAmount();
    }
    private double calculateTotalAmount(){
        long total = 0L;
        total = ChronoUnit.DAYS.between(startDate,endDate)+1;
        return total* car.getPricePerDay();
    }
}
