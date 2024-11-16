package com.scaler.lldmachinecodingpractice.OnlineShoppingSystem.Services;

import com.scaler.lldmachinecodingpractice.OnlineShoppingSystem.Models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CartService {
    private Map<Integer,Product> CartProducts;
    public CartService(){
        CartProducts = new ConcurrentHashMap<>();
    }

    //add product to cart
    public void addProductToCart(Product product, int quantity){
        if(CartProducts.containsKey(product.getId())){
            quantity += product.getQuantity();
            System.out.println("Item with ItemId "+product.getId()+ " "+product.getProductName()+" with quantity "+quantity+"added successfully");
        }else{
            CartProducts.put(product.getId(),product);
            System.out.println("Product "+product.getProductName()+" has been added successfully with quantity "+quantity);
        }

    }
    //show cart items
    public List<Product> showCartItems(){
        List<Product> cartItems = new ArrayList<>();
        for(Product product:CartProducts.values()){
            if(CartProducts.containsKey(product.getId())){
                cartItems.add(product);
            }
        }
        return cartItems;
    }


}
