package com.example.res.services;

import com.example.res.DAO.DishDAO;
import com.example.res.models.Dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {
    @Autowired
    DishDAO dishDAO;

    public void save(Dish dish) {
    dishDAO.save(dish);
    }

    public List<Dish> findStartWith(String sartwith) {
   return dishDAO.findAllByTitleStartsWith(sartwith);
    }
}
