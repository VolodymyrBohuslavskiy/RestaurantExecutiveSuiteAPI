package com.example.res.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@ToString(exclude = {"dishList"})
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    Date date = new Date();
    @ManyToMany
    List<Dish> dishList;
}
