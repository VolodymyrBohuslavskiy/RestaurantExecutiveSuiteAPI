package com.example.res.DAO;

import com.example.res.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDAO extends JpaRepository<Account, Integer > {
}
