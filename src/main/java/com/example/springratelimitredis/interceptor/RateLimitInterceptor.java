package com.example.springratelimitredis.interceptor;

import com.example.springratelimitredis.constant.RateLimitConstant;
import com.example.springratelimitredis.entity.APIRequest;
import com.example.springratelimitredis.service.RateLimitService;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
@AllArgsConstructor
public class RateLimitInterceptor implements HandlerInterceptor {
  private final RateLimitService rateLimitService;
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
    var apiRequestId = request.getMethod() + ":" + request.getServletPath();
    var currentTime = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    var apiRequest = rateLimitService.findRequestById(apiRequestId);
    if (Objects.isNull(apiRequest)) {
      rateLimitService.saveRequest(
          APIRequest.of(
          apiRequestId,
          1,
          currentTime,
          RateLimitConstant.MILLI_SECONDS_OF_LIMIT,
          RateLimitConstant.MAX_REQUEST_NUMBER));
      return true;
    }
    if(currentTime - apiRequest.getBeginTime() > RateLimitConstant.MILLI_SECONDS_OF_LIMIT){
      apiRequest.setBeginTime(currentTime);
      apiRequest.setRequestCount(1);
      rateLimitService.saveRequest(apiRequest);
      return true;
    }
    if(apiRequest.getRequestCount() >= apiRequest.getMaxRequest()){
      response.sendError(429,"Many request in a time");
      return false;
    }
    apiRequest.increaseRequestByOne();
    rateLimitService.saveRequest(apiRequest);
    return true;
  }

}
