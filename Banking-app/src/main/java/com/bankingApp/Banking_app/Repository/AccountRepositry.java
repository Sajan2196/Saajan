package com.bankingApp.Banking_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankingApp.Banking_app.Entities.Account;

public interface AccountRepositry extends JpaRepository<Account, Long> {
     
}
