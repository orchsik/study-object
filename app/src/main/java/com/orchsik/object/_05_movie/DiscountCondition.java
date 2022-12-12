package com.orchsik.object._05_movie;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {
  /**
   * 메시지에 응답하기 위해 필요한 변수
   */
  private DiscountConditionType type;
  private int sequence;
  private DayOfWeek dayOfWeek;
  private LocalTime startTime;
  private LocalTime endTime;

  /**
   * 5) Movie는 각 DiscountCondition에 "할인 여부를 판단하라" 메시지를 전송한다.
   */
  public boolean isSatisfiedBy(Screening screening) {
    if (type == DiscountConditionType.PERIOD) {
      return isSatisfiedByePeriod(screening);
    }
    return isSatisfiedBySequence(screening);
  }

  private boolean isSatisfiedBySequence(Screening screening) {
    return sequence == screening.getSequence();
  }

  private boolean isSatisfiedByePeriod(Screening screening) {
    return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek())
        && startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0
        && endTime.compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
  }

}
