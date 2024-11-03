package com.scaler.lldmachinecodingpractice.CarRentalSystem.models;

import lombok.Getter;
import lombok.Setter;
import lombok.Synchronized;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
public class CarRentalSystem {
    private static CarRentalSystem instance;
    private Customer customer;
    private Map<String,Reservation> reservations;
    private Map<String, Car> cars;
    private Payment payment;

    public CarRentalSystem() {
        this.customer = customer;
        this.reservations = new ConcurrentHashMap<>();
        this.cars = new ConcurrentHashMap<>();
        this.payment = payment;
    }

    public static synchronized CarRentalSystem getInstance(){
        if(instance==null){
            instance = new CarRentalSystem();
        }
        return instance;
    }
    public void addCar(Car car){
        cars.put(car.getLicensePlateNumber(),car);
    }
    public void removeCar(String licensePlateNumber){
        cars.remove(licensePlateNumber);
    }
    public List<Car> searchCar(String make, String model, LocalDate startDate, LocalDate endDate) {
        List<Car> availableCars = new ArrayList<>();

        for (Car car : cars.values()) {
            // Check if car matches the specified make and model, handling cases where make or model is null
            boolean matchesMake = (make == null || make.isEmpty() || car.getMake().equalsIgnoreCase(make));
            boolean matchesModel = (model == null || model.isEmpty() || car.getModel().equalsIgnoreCase(model));

            // Only add car to available list if it matches and is available in the given date range
            if (matchesMake && matchesModel && car.isAvailable() && isCarAvailable(car, startDate, endDate)) {
                availableCars.add(car);
            }
        }
        return availableCars;
    }

    public boolean isCarAvailable(Car car, LocalDate satrtDate, LocalDate endDate){
        for(Reservation reservation: reservations.values()){
            if(reservation.getCar().equals(car)){
                if(satrtDate.isBefore(reservation.getEndDate()) && endDate.isAfter(reservation.getStartDate())){
                    return false;
                }
            }
        }
        return true;
    }
    public synchronized Reservation makeRegistration(Customer customer, Car car, LocalDate startDate, LocalDate endDate){
        if(isCarAvailable(car, startDate,endDate)){
            String reservationId = generateReservationId();
            Reservation reservation = new Reservation(reservationId, customer, car, startDate, endDate);
            reservations.put(reservationId,reservation);
            car.setAvailable(false);
            return reservation;
        }
        return null;
    }
    public String generateReservationId(){
        return "RES" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
    public synchronized void removeRegistration(String reservationId){
        Reservation reservation = reservations.remove(reservationId);
        if(reservation!=null){
            reservation.getCar().setAvailable(true);
        }
    }
}
