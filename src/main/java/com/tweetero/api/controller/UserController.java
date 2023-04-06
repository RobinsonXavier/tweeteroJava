package com.tweetero.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.api.dto.UserDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/sign-up")
public class UserController {
  
  @PostMapping
  public void create(@RequestBody UserDTO user) {
      
  }
  
}
