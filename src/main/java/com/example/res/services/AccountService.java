package com.example.res.services;

import com.example.res.DAO.AccountDAO;
import com.example.res.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountDAO accountDAO;

    public void save(Account newAccount) {
        accountDAO.save(newAccount);
    }

    public List<Account> findAll() {
        return accountDAO.findAll(Sort.by("id"));
    }
}
