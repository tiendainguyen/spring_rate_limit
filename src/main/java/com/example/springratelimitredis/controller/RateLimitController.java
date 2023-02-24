package com.example.springratelimitredis.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greetings")
@AllArgsConstructor
public class RateLimitController {
  @GetMapping("/sayhi")
  public String sayhi(@RequestParam String name){
    return "hello " + name;
  }
}
