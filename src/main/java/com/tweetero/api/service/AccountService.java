package com.tweetero.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetero.api.dto.AccountDTO;
import com.tweetero.api.models.Account;
import com.tweetero.api.repository.AccountRepository;

@Service
public class AccountService {
  
  @Autowired
  private AccountRepository repository;

  public String createAccount(AccountDTO req) {
    repository.save(new Account(req));
    return "OK";
  }
}
