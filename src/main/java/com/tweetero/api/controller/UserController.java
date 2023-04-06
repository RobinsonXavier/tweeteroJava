package com.tweetero.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.api.dto.UserDTO;
import com.tweetero.api.models.User;
import com.tweetero.api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/sign-up")
public class UserController {

  @Autowired
  private UserRepository repository;
  
  @PostMapping
  public String create(@RequestBody UserDTO user) {
    repository.save(new User(user));
    return "OK";
  }
  
}
