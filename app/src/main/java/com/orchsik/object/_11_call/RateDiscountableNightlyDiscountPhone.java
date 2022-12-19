package com.orchsik.object._11_call;

import java.time.Duration;

import com.orchsik.object._02_movie.Money;

public class RateDiscountableNightlyDiscountPhone extends NightlyDiscountPhone {
  private Money discountAmount;

  public RateDiscountableNightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds,
      Money discountAmount) {
    super(nightlyAmount, regularAmount, seconds);
    this.discountAmount = discountAmount;
  }

  @Override
  protected Money afterCalculated(Money fee) {
    return fee.minus(discountAmount);
  }
}
