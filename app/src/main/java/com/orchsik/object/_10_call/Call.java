package com.orchsik.object._10_call;

import java.time.Duration;
import java.time.LocalDateTime;

import lombok.Getter;

/* 개별 통화 기간을 저장하는 클래스 */
public class Call {
  @Getter()
  private LocalDateTime from; // 통화 시작 시간
  private LocalDateTime to; // 통화 종료 시간

  public Call(LocalDateTime from, LocalDateTime to) {
    this.from = from;
    this.to = to;
  }

  public Duration geDuration() {
    return Duration.between(from, to);
  }

}
