package org.example.book_my_show.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel{
    private String name;
    @ManyToOne
    private City city;
    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Screen> screens;
}
