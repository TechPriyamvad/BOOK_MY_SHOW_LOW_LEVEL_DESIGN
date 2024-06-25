package org.example.book_my_show.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel {
    @ManyToMany
    private List<ShowSeat> showSeats;
    @ManyToOne
    private User user;
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    private int amount;
    @OneToMany(mappedBy = "booking",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Payment> payments;
}
