package com.orchsik.object._05_movie;

import java.time.Duration;
import java.util.List;

import lombok.Getter;

public abstract class Movie {
  private String title;
  private Duration runningTime;
  @Getter()
  protected Money fee;
  private List<DiscountCondition> discountConditions;

  public Movie(String title, Duration runningTime, Money fee, List<DiscountCondition> discountConditions) {
    this.title = title;
    this.runningTime = runningTime;
    this.fee = fee;
    this.discountConditions = discountConditions;
  }

  public Money calculateMovieFee(Screening screening) {
    if (isDiscountable(screening)) {
      return fee.minus(calculateDiscountAmount());
    }
    return fee;
  }

  private boolean isDiscountable(Screening screening) {
    return discountConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening));
  }

  abstract protected Money calculateDiscountAmount();

}
