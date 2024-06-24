package org.example.book_my_show.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Theatre extends BaseModel{
    private String name;
    private City city;
    private List<Screen> screens;
}
