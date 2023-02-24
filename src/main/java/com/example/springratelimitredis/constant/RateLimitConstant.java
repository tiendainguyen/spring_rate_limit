package com.example.springratelimitredis.constant;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RateLimitConstant {
  public static Integer MAX_REQUEST_NUMBER = 3;
  public static Long MILLI_SECONDS_OF_LIMIT = 60_000L;
}
