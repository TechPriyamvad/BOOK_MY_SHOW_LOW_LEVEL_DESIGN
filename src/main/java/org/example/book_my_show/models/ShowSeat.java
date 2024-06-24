package org.example.book_my_show.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeat extends BaseModel{
    private Seat seat;
    private Show show;
    private ShowSeatStatus showSeatStatus;
}
