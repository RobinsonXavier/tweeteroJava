package com.tweetero.api.controller;

import java.util.ArrayList;
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
import com.tweetero.api.models.Account;
import com.tweetero.api.repository.TweetRepository;
import com.tweetero.api.repository.AccountRepository;

@RestController
@RequestMapping("/tweets")
public class TweetController {

  @Autowired
  private TweetRepository repository;

  @Autowired
  private AccountRepository userRepository;

  @PostMapping
  public String create(@RequestBody TweetDTO tweet) {
    Account user = userRepository.findByUsername(tweet.username());

    repository.save(new Tweet(tweet, user.getAvatar()));
    return "OK";
  }

  @GetMapping
  public List<Tweet> getTweets(@RequestParam(name = "page", required = false) String page) {
    List<Tweet> list = repository.findAll();
    List<Tweet> newList = new ArrayList<Tweet>();
    int size = list.size();

    for (int i = size - 1; i > 0; i--) {
      if(page != null) {
        int multi = Integer.parseInt(page);
        multi = multi * 5;

        for(int j = multi; j > 0; j--) {
          newList.add(list.get(i));
          i--;
        }

        return newList;
      }
      
      newList.add(list.get(i));
    }

    return newList;
  }


  @GetMapping("/{username}")
  public List<Tweet> getTweetsByUsername(@PathVariable String username) {
    return repository.findByUsername(username);
  }
}
