package com.example.res.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@ToString(exclude = {"categories"})
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    Date date = new Date();
    @JsonIgnore
    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, mappedBy = "menu")
    List<Category> categories;
}
