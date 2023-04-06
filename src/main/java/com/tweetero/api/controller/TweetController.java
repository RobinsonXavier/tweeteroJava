package com.tweetero.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweetero.api.dto.TweetDTO;
import com.tweetero.api.models.Tweet;
import com.tweetero.api.service.TweetService;

@RestController
@RequestMapping("/tweets")
public class TweetController {

  @Autowired
  private TweetService service;

  @PostMapping
  public String create(@RequestBody TweetDTO tweet) {
    return service.createTweet(tweet);
  }

  @GetMapping
  public List<Tweet> getTweets(@RequestParam(name = "page", required = false) String page) {
    return service.getTweets(page);
  }


  @GetMapping("/{username}")
  public List<Tweet> getTweetsByUsername(@PathVariable String username) {
    return service.getTweetsByUsername(username);
  }
}
