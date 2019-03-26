package com.example.res.controller;

import com.example.res.models.Dish;
import com.example.res.services.CategoryService;
import com.example.res.services.DishService;
import com.example.res.services.MenuService;
import com.example.res.services.TransferFileService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@RestController
public class MainController {
    @Autowired
    DishService dishService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    MenuService menuService;
    @Autowired
    TransferFileService transferFileService;


    @PostMapping("/add_dish")
    public String addDish(@RequestParam String dish,
                          @RequestParam String categoryName,
                          @RequestParam MultipartFile image) throws IOException {
        Dish dishNew = new ObjectMapper().readValue(dish, Dish.class);
        dishNew.setCategory(categoryService.getOneByName(categoryName));
        dishNew.setImage(image.getOriginalFilename());
        dishService.save(dishNew);
        transferFileService.transfer(image,"D:\\Q2");
        return new ObjectMapper().writeValueAsString(dishNew);
    }

    @GetMapping("/getcategorys")
    public String getMenu() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(categoryService.getCategories());
    }


    @GetMapping("/detdish_from")
    public String detdishFromCategory(@RequestParam String categoryName) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(categoryService.getOneByName(categoryName).getDishes());
    }

}
