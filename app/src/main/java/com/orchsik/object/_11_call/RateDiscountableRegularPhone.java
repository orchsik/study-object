package com.orchsik.object._11_call;

import java.time.Duration;
import com.orchsik.object._02_movie.Money;

public class RateDiscountableRegularPhone extends RegularPhone {
  private Money discountAmount;

  public RateDiscountableRegularPhone(Money amount, Duration seconds, Money discountAmount) {
    super(amount, seconds);
    this.discountAmount = discountAmount;
  }

  @Override
  protected Money afterCalculated(Money fee) {
    return fee.minus(discountAmount);
  }

}
