package com.scaler.lldmachinecodingpractice.CarRentalSystem;

import com.scaler.lldmachinecodingpractice.CarRentalSystem.models.Car;
import com.scaler.lldmachinecodingpractice.CarRentalSystem.models.CarRentalSystem;
import com.scaler.lldmachinecodingpractice.CarRentalSystem.models.Customer;
import com.scaler.lldmachinecodingpractice.CarRentalSystem.models.Reservation;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CarRentalSystemClient {
    public static void main(String[] args){
        CarRentalSystem crs = CarRentalSystem.getInstance();
        Scanner scanner = new Scanner(System.in);

        //create cars
        crs.addCar(new Car( "Tata", "T123", "2022", "TS12345", 130));
        crs.addCar(new Car( "Hundai", "H111", "2021", "TS3333", 100));
        crs.addCar(new Car( "BMW", "BMW190", "2020", "TS132222", 230));
        crs.addCar(new Car( "Volkswegan", "V223", "2000", "TS166666", 140));
        crs.addCar(new Car( "Maruthi", "M155", "2023", "TS127676", 150));

//        //create customers
//        System.out.println("Enter the customer name");
//        String cname = scanner.nextLine();
//        Customer c1 = new Customer("Sandhya", "9939", "S9939");
//        Customer c2 = new Customer("Bharath", "9392", "B9392");
//        Customer c3 = new Customer("Mahaan", "7989", "M7989");
//        Customer c4 = new Customer("Vihaan", "9553", "V9553");
//        Customer c5 = new Customer("Rekha", "7702", "R7702");

        // Create customers and store them in a map for easy lookup
        Map<String, Customer> customers = new HashMap<>();
        customers.put("Sandhya", new Customer("Sandhya", "9939", "S9939"));
        customers.put("Bharath", new Customer("Bharath", "9392", "B9392"));
        customers.put("Mahaan", new Customer("Mahaan", "7989", "M7989"));
        customers.put("Vihaan", new Customer("Vihaan", "9553", "V9553"));
        customers.put("Rekha", new Customer("Rekha", "7702", "R7702"));

        // Prompt user to enter the customer name
        System.out.println("Enter the customer name:");
        String cname = scanner.nextLine();
        Customer customer = customers.get(cname);

        if (customer == null) {
            System.out.println("Customer not found. Please try again.");
            return;
        }

        System.out.println("Which car brand do you want to search?");
        String carBrand = scanner.nextLine();

        System.out.println("Here are the Available " +carBrand+" Cars ");

        //registration
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(1);
        List<Car> availableCars = crs.searchCar(carBrand, null, startDate, endDate);
        if (availableCars.isEmpty()){
            System.out.println("No available cars for the brand " +carBrand+"Search for another brand");
            return;
        }
        //display available cars

        for(int i=0; i<availableCars.size(); i++){
            Car car = availableCars.get(i);
            System.out.println((i+1)+"."+car.getMake()+" " + car.getModel()+" "+ car.getYear()+" and NumberPlate " +car.getLicensePlateNumber());
        }
        System.out.println("Select Number Plate you want to rent");
        String SelectedNumberPlate = scanner.nextLine();
        Car selectedCar = availableCars.stream()
                .filter(car->car.getLicensePlateNumber().equalsIgnoreCase(SelectedNumberPlate))
                .findFirst()
                .orElse(null);

        if(selectedCar == null){
            System.out.println("Invalid number plate select another");
        }
        System.out.println("For how many days do you want to rent this car?");
        int days = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        double totalPrice = selectedCar.getPricePerDay() * days;
        System.out.println("Total price = $" + totalPrice + ". Do you want to proceed with the booking? (yes/no)");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("yes")) {
            // Proceed with reservation
            endDate = startDate.plusDays(days);
            Reservation reservation = crs.makeRegistration(customer, selectedCar, startDate, endDate);
            if (reservation != null) {
                System.out.println(selectedCar.getMake() + " car for $" + selectedCar.getPricePerDay() + " per day for " + days + " days has been successfully booked by the customer " + customer.getName() + ".");
            } else {
                System.out.println("Reservation failed. The selected car might not be available for the given dates.");
            }
        } else {
            System.out.println("Booking canceled.");
        }

        scanner.close();

    }
}
