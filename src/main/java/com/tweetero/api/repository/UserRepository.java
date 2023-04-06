package com.tweetero.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweetero.api.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
  
}
