package com.orchsik.object._02_movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * AmountPolicy, PercentPolicy로 두 가지 할인 정책 구현
 * 두 클래스는 대부분의 코드가 유사하고 할인 요금을 계산하는 방식만 조금 다르므로, DiscountPolicy 라는 부모 클래스 사용
 * 실제 애플리케이션에서는 DiscountPolicy의 인스턴스를 생성할 필요가 없기 때문에 추상 클래스로 구현
 */
public abstract class DefaultDiscountPolicy implements DiscountPolicy {
  private List<DiscountCondition> conditions = new ArrayList<>();

  public DefaultDiscountPolicy(DiscountCondition... conditions) {
    this.conditions = Arrays.asList(conditions);
  }

  public Money calculateDiscountAmount(Screening screening) {
    for (DiscountCondition each : conditions) {
      if (each.isSatisfiedBy(screening)) {
        return getDiscountAmount(screening);
      }
    }

    return Money.ZERO;
  }

  abstract protected Money getDiscountAmount(Screening screening);
}
