package com.orchsik.object._05_movie;

import java.time.Duration;
import java.util.List;

public class Movie {
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
