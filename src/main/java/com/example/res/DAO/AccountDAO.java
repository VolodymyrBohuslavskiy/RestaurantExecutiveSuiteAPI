package com.example.res.DAO;

import com.example.res.models.Account;
import com.example.res.models.AccountStatuse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AccountDAO extends JpaRepository<Account, Integer> {
    List<Account> findByAccountStatuseIsNot(AccountStatuse accountStatuse);
}
