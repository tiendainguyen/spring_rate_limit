package com.example.springratelimitredis.repository;

import com.example.springratelimitredis.entity.APIRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateLimitRepository extends JpaRepository<APIRequest,String> {

}
