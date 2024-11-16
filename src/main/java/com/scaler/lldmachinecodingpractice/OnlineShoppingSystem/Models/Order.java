package com.scaler.lldmachinecodingpractice.OnlineShoppingSystem.Models;

import com.scaler.lldmachinecodingpractice.CarRentalSystem.models.Customer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private int orderId;
    private Customer customer;
    private Product product;
    private OrderStatus orderStatus;
}
