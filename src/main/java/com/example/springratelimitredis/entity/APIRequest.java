package com.example.springratelimitredis.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "api_request")
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class APIRequest {
  @Id
  private String id;

  @Column(name = "request_count")
  private Integer requestCount;

  @Column(name = "begin_time")
  private Long beginTime;

  @Column(name = "duration")
  private Long duration;

  @Column(name = "max_request")
  private Integer maxRequest;

  public void increaseRequestByOne() {
    this.requestCount = this.requestCount + 1;
  }
}
