package com.example.springratelimitredis.service;

import com.example.springratelimitredis.entity.APIRequest;

public interface RateLimitService {
  APIRequest saveRequest(APIRequest APIRequest);

  APIRequest findRequestById(String requestId);

}
