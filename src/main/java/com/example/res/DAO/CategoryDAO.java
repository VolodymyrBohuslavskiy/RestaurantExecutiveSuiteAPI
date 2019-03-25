package com.example.res.DAO;

import com.example.res.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Integer> {
    Category getByCategoryName(String categoryName);
}
