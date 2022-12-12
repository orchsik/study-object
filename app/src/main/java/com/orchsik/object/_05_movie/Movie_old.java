package com.orchsik.object._05_movie;

import java.time.Duration;
import java.util.List;

/**
 * ❌ 금액 할인 정책 영화와 비율 할인 정책 영화라는 두 가지 타입을 하나의 클래스 안에
 * 구현하고 있기 때문에 하나 이상의 이유로 변경될 수 있다. 한마디로 말해서 응집도가 낮은 것이다.
 * -> 역할 개념을 도입해서 협력을 다형적으로 만들면 된다. POLYMORPHISM 패턴을 사용해서
 * 서로 다른 행동을 타입별로 분리하면 다형성의 혜택을 누릴 수 있다.
 */
public class Movie_old {
  private String title;
  private Duration runningTime;
  private Money fee;
  private List<DiscountCondition> discountConditions;

  private MovieType movieType;
  private Money discountAmount;
  private double discountPercent;

  /**
   * 4) Screening에서 보내는 메시지에 응답하기 위해 메서드 구현
   */
  public Money calculateMovieFee(Screening screening) {
    if (isDiscountable(screening)) {
      return fee.minus(calculateDiscountAmount());
    }
    return fee;
  }

  private boolean isDiscountable(Screening screening) {
    return discountConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening));
  }

  private Money calculateDiscountAmount() {
    switch (movieType) {
      case AMOUNT_DISCOUNT:
        return calculateAmountDiscountAmount();
      case PERCENT_DISCOUNT:
        return calculatePercentDiscountAmount();
      case NONE_DISCOUNT:
        return calcuateNoneDiscountAmount();
    }
    throw new IllegalStateException();
  }

  private Money calcuateNoneDiscountAmount() {
    return Money.ZERO;
  }

  private Money calculatePercentDiscountAmount() {
    return fee.times(discountPercent);
  }

  private Money calculateAmountDiscountAmount() {
    return discountAmount;
  }

}
