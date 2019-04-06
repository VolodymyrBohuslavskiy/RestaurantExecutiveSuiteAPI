package com.example.res.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@ToString(exclude = {"category", "accountList"})
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(unique = true, length = 30)
    String title;
    String about, image;
    boolean entree;
    double coast;
    @JsonIgnore
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Category category;
    @ManyToMany
    @JsonIgnore
    List<Account> accountList;
}
