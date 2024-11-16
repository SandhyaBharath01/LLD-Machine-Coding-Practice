package com.scaler.lldmachinecodingpractice.OnlineShoppingSystem;

import com.scaler.lldmachinecodingpractice.OnlineShoppingSystem.Models.Product;
import com.scaler.lldmachinecodingpractice.OnlineShoppingSystem.Models.User;
import com.scaler.lldmachinecodingpractice.OnlineShoppingSystem.Services.CartService;
import com.scaler.lldmachinecodingpractice.OnlineShoppingSystem.Services.OnlineShoppingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("Online Shopping System");
        Scanner scn = new Scanner(System.in);
        OnlineShoppingService os = OnlineShoppingService.getInstance();
        CartService cartService = new CartService();

        //add user
        User user1 = new User(1, "Sandhya", "sandhya@gmail.com", "1234");
        os.addUser(user1);

        //add products
        Product product1 = new Product(1, "OnePlus ne","OnePlusMobile",45000, 5);
        Product product2 = new Product(2, "Samsung s7","SamsungMobile",35000, 4);
        Product product3 = new Product(3, "iphone 16 ","IphoneMobile",48000, 6);
        Product product4 = new Product(4, "Sony Ericsion","SonyEricsionMobile",25000, 10);
        Product product5 = new Product(5, "Mi 15","MiMobile",38000, 2);
        Product sampleProduct = new Product(6, "sample","sample",38000, 2);
        os.addProduct(product1);
        os.addProduct(product2);
        os.addProduct(product3);
        os.addProduct(product4);
        os.addProduct(product5);

        //show Products
        System.out.println("availableProducts are ");
        List<Product> availableProducts = os.showProducts();
        for(Product product : availableProducts){
            System.out.println(product.getId()+" "+product.getProductName()+" "+product.getPrice());
        }

       // delete Product
        os.deleteProduct(sampleProduct);
        System.out.println(sampleProduct.getProductName()+ " is Deleted");

        //add product to cart
        System.out.println("Choose the productId you want to add to cart from available products");
        int productToCart = scn.nextInt();
        //add quantity of products
        System.out.println("Select quantity of products to add ");
        int quantityInput = scn.nextInt();

        Product selectedProduct = null;
        int quantity = 0;
        for(Product product : availableProducts){
            if(product.getId()==productToCart){
                selectedProduct = product;
                quantity = quantity+quantityInput;
                break;
            }
        }
        if(selectedProduct!=null){
            cartService.addProductToCart(selectedProduct,quantity);
        }else{
            System.out.println("Invalid product");
        }

        //show cart products
        System.out.println("Available cart items are: ");
        List<Product> availablecartItems = cartService.showCartItems();
        for(Product product:availablecartItems){
            System.out.println(product.getId()+ " "+product.getProductName()+" "+ quantity);
        }
        //delete product from cart
        System.out.println("Select product Id you want to delete from Cart ");
        int productIdToDelete = scn.nextInt();
        for(Product product:availablecartItems){
            if(product.getId() == productIdToDelete){
                quantity -= 1;
                product.setQuantity(quantity);
                if(quantity==0){
                    System.out.println("Cart is empty");
                }else {
                    System.out.println("Available cart products are " + product.getId() + " " + product.getProductName() + " " + product.getQuantity());
                    break;
                }
            }
        }
        //update product in cart
        System.out.println("Select productId to update ");
        int productIdToUpdate = scn.nextInt();
        System.out.println("Select quantity of products to update ");
        int quantityToUpdate = scn.nextInt();

        for(Product product:availablecartItems){
            if(product.getId() == productIdToUpdate){
                quantity += quantityToUpdate;
                product.setQuantity(quantity);
                System.out.println("Added quantity of "+quantityToUpdate+ " for product "+product.getProductName()+ " "+ quantity);
                break;
            }
        }


    }
}
