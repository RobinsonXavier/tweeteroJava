package com.tweetero.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweetero.api.models.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
  
  Account findByUsername(String username);
}
