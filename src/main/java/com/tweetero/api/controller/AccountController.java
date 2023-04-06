package com.tweetero.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.api.dto.AccountDTO;
import com.tweetero.api.models.Account;
import com.tweetero.api.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping
public class AccountController {

  @Autowired
  private AccountRepository repository;
  
  @PostMapping("/sign-up")
  public String create(@RequestBody AccountDTO req) {
    repository.save(new Account(req));
    return "OK";
  }
  
}
