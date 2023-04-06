package com.tweetero.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.api.dto.AccountDTO;
import com.tweetero.api.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping
public class AccountController {

  @Autowired
  private AccountService service;
  
  @PostMapping("/sign-up")
  public void create(@RequestBody AccountDTO req) {
    service.createAccount(req);
  }
  
}
