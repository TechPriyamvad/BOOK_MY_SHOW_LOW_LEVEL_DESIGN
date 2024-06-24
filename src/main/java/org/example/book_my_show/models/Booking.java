package org.example.book_my_show.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Booking extends BaseModel {
    private List<ShowSeat> showSeats;
    private User user;
    private BookingStatus bookingStatus;
    private int amount;
    private List<Payment> payments;
}
