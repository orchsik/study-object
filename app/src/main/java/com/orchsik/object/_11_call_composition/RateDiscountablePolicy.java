package com.orchsik.object._11_call_composition;

import com.orchsik.object._02_movie.Money;

public class RateDiscountablePolicy extends AdditionalRatePolicy {
  private Money discountAmount;

  public RateDiscountablePolicy(Money discountAmount, RatePolicy next) {
    super(next);
    this.discountAmount = discountAmount;
  }

  @Override
  protected Money afterCalculate(Money fee) {
    return fee.minus(discountAmount);
  }

}
