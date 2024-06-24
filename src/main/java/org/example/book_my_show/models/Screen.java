package org.example.book_my_show.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Screen {
    private String name;
    private List<Seat> seats;
    private List<Feature> features;
}
