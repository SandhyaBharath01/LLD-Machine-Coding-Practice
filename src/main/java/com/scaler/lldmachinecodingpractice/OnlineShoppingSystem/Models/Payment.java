package com.scaler.lldmachinecodingpractice.OnlineShoppingSystem.Models;

import com.scaler.lldmachinecodingpractice.OnlineShoppingSystem.Models.PaymentMode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment {
    private int paymentId;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
}
