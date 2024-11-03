package com.scaler.lldmachinecodingpractice.CarRentalSystem.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Payment {
    private PaymentMode paymentMode;
    private List<Payment> payments;
}
