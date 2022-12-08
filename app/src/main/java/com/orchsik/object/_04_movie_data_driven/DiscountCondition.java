package com.orchsik.object._04_movie_data_driven;

import java.time.DayOfWeek;
import java.time.LocalTime;

import lombok.Getter;

public class DiscountCondition {
  @Getter()
  private DiscountConditionType type;
  private int sequence; // 상영 순번
  private DayOfWeek dayOfWeek; // 요일
  private LocalTime startTime;
  private LocalTime endTime;

  public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime time) {
    if (type != DiscountConditionType.PERIOD) {
      throw new IllegalArgumentException();
    }
    return this.dayOfWeek.equals(dayOfWeek) && this.startTime.compareTo(time) <= 0 && this.endTime.compareTo(time) >= 0;
  }

  public boolean isDiscountable(int sequence) {
    if (type != DiscountConditionType.SEQUENCE) {
      throw new IllegalArgumentException();
    }
    return this.sequence == sequence;
  }

}
