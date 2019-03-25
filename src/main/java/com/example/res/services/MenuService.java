package com.example.res.services;

import com.example.res.DAO.MenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MenuService {
    @Autowired
    MenuDAO menuDAO;

}
