package com.scaler.lldmachinecodingpractice.OnlineShoppingSystem.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {
    private int UserId;
    private String UserName;
    private String UserEmail;
    private String Password;
    private List<Order> orderList;

    public User(int UserId, String UserName, String UserEmail, String Password) {
        this.UserId = UserId;
        this.UserName = UserName;
        this.UserEmail = UserEmail;
        this.Password = Password;

    }
}
