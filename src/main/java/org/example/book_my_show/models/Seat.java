package org.example.book_my_show.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat extends BaseModel{
    private String number;
    private SeatType seatType;
    private int rowVal;
    private int colVal;
}
