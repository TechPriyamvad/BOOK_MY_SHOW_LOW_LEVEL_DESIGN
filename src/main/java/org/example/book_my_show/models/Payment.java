package org.example.book_my_show.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
    private int amount;
    private String referenceNumber;
    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
}
