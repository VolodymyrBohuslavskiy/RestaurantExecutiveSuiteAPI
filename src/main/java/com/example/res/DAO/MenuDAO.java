package com.example.res.DAO;

import com.example.res.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuDAO extends JpaRepository<Menu, Integer > {
}
