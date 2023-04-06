package com.tweetero.api.dto;

import jakarta.validation.constraints.NotBlank;

public record AccountDTO(

  @NotBlank
  String username,
  
  @NotBlank
  String avatar) {
  
}
