package com.example.res.controller;

import com.example.res.models.Category;
import com.example.res.models.Dish;
import com.example.res.services.CategoryService;
import com.example.res.services.DishService;
import com.example.res.services.MenuService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@CrossOrigin
public class MainController {
    private String workDirectory = "D:\\Q2\\";
    @Autowired
    DishService dishService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    MenuService menuService;

    @PostMapping("/create_category")
    public void createCategory(@RequestParam String category, @RequestParam MultipartFile categoryImage) throws IOException {
        Category newCategory = new ObjectMapper().readValue(category, Category.class);
        File categoryDir = new File(workDirectory + newCategory.getCategoryName());
        if (!categoryDir.exists()) categoryDir.mkdir();
        categoryImage.transferTo(new File(workDirectory + newCategory.getCategoryName() + "\\" + categoryImage.getOriginalFilename()));
        newCategory.setCategoryImage(categoryImage.getOriginalFilename());
        categoryService.save(newCategory);
    }

    @PostMapping("/add_dish")
    public String addDish(@RequestParam String dish,
                          @RequestParam String categoryName,
                          @RequestParam MultipartFile image) throws IOException {
        Dish dishNew = new ObjectMapper().readValue(dish, Dish.class);
        Category thisCategory = categoryService.getOneByName(categoryName);
        dishNew.setCategory(thisCategory);
        dishNew.setImage(image.getOriginalFilename());
        image.transferTo(new File(thisCategory.getCategoryName() + "\\" + image.getOriginalFilename()));
        try {
            dishService.save(dishNew);
            return new ObjectMapper().writeValueAsString(dishNew);
        } catch (Exception e) {
            return "Dish with title " + dishNew.getTitle() + " contains in base";
        }
    }

    @GetMapping("/get_categoryes")
    public String getMenu() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(categoryService.getCategories());
    }


    @GetMapping("/get_dish_from")
    public String detdishFromCategory(@RequestParam String categoryName) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(categoryService.getOneByName(categoryName).getDishes());
    }

    @GetMapping("/find_dish")
    public String findDish(@RequestParam String sartingWith) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(dishService.findStartWith(sartingWith));
    }


}
