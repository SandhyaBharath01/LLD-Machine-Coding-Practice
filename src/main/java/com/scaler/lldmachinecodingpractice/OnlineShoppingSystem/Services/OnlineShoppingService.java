package com.scaler.lldmachinecodingpractice.OnlineShoppingSystem.Services;

import com.scaler.lldmachinecodingpractice.OnlineShoppingSystem.Models.Order;
import com.scaler.lldmachinecodingpractice.OnlineShoppingSystem.Models.Product;
import com.scaler.lldmachinecodingpractice.OnlineShoppingSystem.Models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OnlineShoppingService {
    private static OnlineShoppingService instance;
    private Map<Integer, User> users;
    private Map<Integer, Product> products;
    private Map<Integer, Order> orders;

    private OnlineShoppingService(){
        users = new ConcurrentHashMap<>();
        products = new ConcurrentHashMap<>();
        orders = new ConcurrentHashMap<>();
    }
    public static synchronized OnlineShoppingService getInstance(){
        if(instance==null){
            instance = new OnlineShoppingService();
        }
        return instance;
    }

    //add User
    public void addUser(User user){
        users.put(user.getUserId(), user);
    }

    //add product
    public void addProduct(Product product){
        products.put(product.getId(),product);
    }

    //delete product
    public void deleteProduct(Product product){
        products.remove(product.getId(), product);
    }

    //show products
    public List<Product> showProducts(){
        List<Product> availableProducts = new ArrayList<>();
        for(Product product : products.values()){
            availableProducts.add(product);
        }
        return availableProducts;
    }



}
