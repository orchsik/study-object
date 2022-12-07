package com.orchsik.object._02_movie;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * @dayOfWeek - 요일
 * @startTime - 시작 시간
 * @endTime - 종료 시간
 */
public class PeriodCondition implements DiscountCondition {
  private DayOfWeek dayOfWeek;
  private LocalTime startTime;
  private LocalTime endTime;

  public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
    this.dayOfWeek = dayOfWeek;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  /**
   * 상영 요일이 dayOfWeek와 같고 상영 시작 시간이 startTime과 endTime 사이에 있을 경우 true
   */
  @Override
  public boolean isSatisfiedBy(Screening screening) {
    return screening.getStarTime().getDayOfWeek().equals(dayOfWeek)
        && startTime.compareTo(screening.getStarTime().toLocalTime()) <= 0
        && endTime.compareTo(screening.getStarTime().toLocalTime()) >= 0;
  }

}
