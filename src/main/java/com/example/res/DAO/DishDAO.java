package com.example.res.DAO;

import com.example.res.models.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishDAO extends JpaRepository<Dish, Integer > {
}
