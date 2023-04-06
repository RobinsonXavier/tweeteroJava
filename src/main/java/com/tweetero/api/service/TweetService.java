package com.tweetero.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetero.api.dto.TweetDTO;
import com.tweetero.api.models.Account;
import com.tweetero.api.models.Tweet;
import com.tweetero.api.repository.AccountRepository;
import com.tweetero.api.repository.TweetRepository;

@Service
public class TweetService {
  
  @Autowired
  private TweetRepository repository;

  @Autowired
  private AccountRepository accountRepository;

  public String createTweet(TweetDTO req) {
    Account user = accountRepository.findByUsername(req.username());
    repository.save(new Tweet(req, user.getAvatar()));

    return "OK";
  }

  public List<Tweet> getTweets(String page) {
    List<Tweet> list = repository.findAll();
    List<Tweet> newList = new ArrayList<Tweet>();
    int size = list.size();

    for (int i = size - 1; i > 0; i--) {
      if(page != null) {
        int multi = Integer.parseInt(page);
        multi = multi * 5;
        int diff = 0;
        if(multi > 5) {
          diff = multi - 5;
        }

        for(int j = 5; j > 0; j--) {
          newList.add(list.get(i - diff));
          i--;
        }

        return newList;
      }
      
      newList.add(list.get(i));
    }

    return newList;
  }

  public List<Tweet> getTweetsByUsername(String username) {
    return repository.findByUsername(username);
  }
}
