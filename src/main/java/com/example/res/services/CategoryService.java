package com.example.res.services;

import com.example.res.DAO.CategoryDAO;
import com.example.res.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryDAO categoryDAO;

    public List<Category> getCategories() {
        return categoryDAO.findAll();
    }

    public Category getOneByName(String categoryName) {
        return categoryDAO.getByCategoryName(categoryName);
    }
}
