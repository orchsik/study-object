package com.orchsik.object._11_call_composition;

import com.orchsik.object._02_movie.Money;

public abstract class AdditionalRatePolicy implements RatePolicy {
  private RatePolicy next;

  public AdditionalRatePolicy(RatePolicy next) {
    this.next = next;
  }

  @Override
  public Money calculateFee(Phone phone) {
    Money fee = next.calculateFee(phone);
    return afterCalculate(fee);
  }

  protected abstract Money afterCalculate(Money fee);

}
