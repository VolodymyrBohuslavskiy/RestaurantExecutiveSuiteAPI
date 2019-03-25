package com.example.res.controller;

import com.example.res.models.Dish;
import com.example.res.services.CategoryService;
import com.example.res.services.DishService;
import com.example.res.services.MenuService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class MainController {
    @Autowired
    DishService dishService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    MenuService menuService;


    @PostMapping("/add_dish")
    public void addDish(@RequestBody String dish, @RequestHeader String categoryName) throws IOException {
        Dish dishNew = new ObjectMapper().readValue(dish, Dish.class);
        System.out.println(dishNew);
        dishNew.setCategory(categoryService.getOneByName(categoryName));
        dishService.save(dishNew);
    }

    @GetMapping("/getcategorys")
    public String getMenu() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(categoryService.getCategories());
    }


    @GetMapping("/detdish_from")
    public String detdishFromCategory(@RequestParam String categoryName ) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(categoryService.getOneByName(categoryName).getDishes());
    }


}
