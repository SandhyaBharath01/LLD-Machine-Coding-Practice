package com.scaler.lldmachinecodingpractice.RideSharingApp.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class User {
    private String userId;
    private String userName;
    private String userPhoneNumber;
    private List<RideStatus> rides;

    public User(String userId, String userName, String userPhoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
    }
}

