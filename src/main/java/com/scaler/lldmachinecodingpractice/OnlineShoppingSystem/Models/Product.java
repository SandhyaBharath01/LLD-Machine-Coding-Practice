package com.scaler.lldmachinecodingpractice.OnlineShoppingSystem.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int id;
    private String productName;
    private String productDescription;
    private double price;
    private int quantity;
    public Product(int id, String productName, String productDescription, double price, int quantity) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.quantity = quantity;
    }
}
