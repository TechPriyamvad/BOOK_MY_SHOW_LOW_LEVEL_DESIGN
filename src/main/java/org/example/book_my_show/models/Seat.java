package org.example.book_my_show.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;
    private String number;
    @ManyToOne
    private SeatType seatType;
    private int rowVal;
    private int colVal;
}
