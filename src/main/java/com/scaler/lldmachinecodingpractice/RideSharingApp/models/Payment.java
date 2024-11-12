package com.scaler.lldmachinecodingpractice.RideSharingApp.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment {
    private int paymentId;
    private int customerId;
    private int paymentType;
    private String paymentDate;
    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;
}
