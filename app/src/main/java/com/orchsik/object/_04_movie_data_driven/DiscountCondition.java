package com.orchsik.object._04_movie_data_driven;

import java.time.DayOfWeek;
import java.time.LocalTime;

import lombok.Getter;

/**
 * ⦿ 캡슐화 위반
 * isDiscountable 메서드의 시그니처를 보면 DiscountCondition에 속성으로 포함돼 있는
 * DayOfWeek 타입의 요일 정보와 LocalTime 타입의 시간 정보를 파라미터로 받는다. 이 메서드는 개체
 * 내부에 DayOfWeek 타입과 LocalTime 타입의 시간 정보가 인스턴스 변수로 포함돼 있다는 사실을 인터페이스를
 * 통해 외부에 노출하고 있다.
 * 만약 DiscountCondition의 속성을 변경해야 한다면 어떻게 될까?
 * 아마도 isDiscountable 메서드의 파라미터를 수정하고 해당 메서드를 사용하는 모든 클라이언트도 함께 수정해야
 * 할 것이다. 내부 구현의 변경이 외부로 퍼져나가는 파급 효과는 캡슐화가 부족하다는 명백한 증거다.
 */
public class DiscountCondition {
  @Getter()
  private DiscountConditionType type;
  private int sequence; // 상영 순번
  private DayOfWeek dayOfWeek; // 요일
  private LocalTime startTime;
  private LocalTime endTime;

  public DiscountCondition(DiscountConditionType type, int sequence) {
    this.type = type;
    this.sequence = sequence;
  }

  public DiscountCondition(DiscountConditionType type, DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
    this.type = type;
    this.dayOfWeek = dayOfWeek;
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public DiscountCondition(DiscountConditionType type, int sequence, DayOfWeek dayOfWeek, LocalTime startTime,
      LocalTime endTime) {
    this.type = type;
    this.sequence = sequence;
    this.dayOfWeek = dayOfWeek;
    this.startTime = startTime;
    this.endTime = endTime;
  }

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
