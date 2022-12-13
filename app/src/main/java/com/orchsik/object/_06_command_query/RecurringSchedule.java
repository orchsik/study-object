package com.orchsik.object._06_command_query;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Getter;

public class RecurringSchedule {
  private String subject; // 일정의 주제
  @Getter()
  private DayOfWeek dayOfWeek; // 반복될 요일
  @Getter()
  private LocalTime from; // 시작 시간
  @Getter()
  private Duration duration; // 기간

  public RecurringSchedule(String subject, DayOfWeek dayOfWeek, LocalTime from, Duration duration) {
    this.subject = subject;
    this.dayOfWeek = dayOfWeek;
    this.from = from;
    this.duration = duration;
  }

}
