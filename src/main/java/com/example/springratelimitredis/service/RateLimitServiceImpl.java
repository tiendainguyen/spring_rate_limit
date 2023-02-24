package com.example.springratelimitredis.service;

import com.example.springratelimitredis.entity.APIRequest;
import com.example.springratelimitredis.repository.RateLimitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RateLimitServiceImpl implements RateLimitService{
  private final RateLimitRepository rateLimitRepository;
  @Override
  public APIRequest saveRequest(APIRequest APIRequest) {
    return rateLimitRepository.save(APIRequest);
  }

  @Override
  public APIRequest findRequestById(String requestId) {
    return rateLimitRepository.findById(requestId).isPresent()?rateLimitRepository.findById(requestId).get():null;
  }
}
