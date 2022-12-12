package com.orchsik.object._05_movie;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * ❌ 아래와 같이 하나 이상의 변경 이유를 갖기 때문에 응집도가 낮다. 응집도가 낮다는 것은
 * 서로 연관성이 없는 기능이나 데이터가 하나의 클래스 안에 뭉쳐져 있다는 것을 의미한다.
 * 따라서 낮은 응집도가 초래하는 문제를 해결학 위해서는 변경의 이유에 따라 클래스를 분리해야 한다.
 * 1) 새로운 할인 조건 추가
 * 2) 순번 조건을 판단하는 로직 변경
 * 3) 기간 조건을 판단하는 로직 변경
 */
public class DiscountCondition_old {
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
