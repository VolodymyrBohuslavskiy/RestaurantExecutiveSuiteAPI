package com.example.res.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Data
@ToString(exclude = "category")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title, about, image;
    boolean isActive;
    double coast;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Category category;

}
