package org.example.book_my_show.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment extends BaseModel{
    private int amount;
    private String referenceNumber;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
}
