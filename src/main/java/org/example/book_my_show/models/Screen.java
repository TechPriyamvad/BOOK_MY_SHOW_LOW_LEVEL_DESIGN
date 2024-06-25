package org.example.book_my_show.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel{
    @ManyToOne
    @JoinColumn(name = "theatre_id")
    private Theatre theatre;
    private String name;
    @OneToMany(mappedBy = "screen",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Seat> seats;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}
