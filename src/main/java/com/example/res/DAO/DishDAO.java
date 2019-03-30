package com.example.res.DAO;

import com.example.res.models.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishDAO extends JpaRepository<Dish, Integer > {
    List<Dish> findAllByTitleStartsWith(String word);
}
