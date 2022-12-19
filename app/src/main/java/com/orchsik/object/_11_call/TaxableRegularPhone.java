package com.orchsik.object._11_call;

import java.time.Duration;
import com.orchsik.object._02_movie.Money;

public class TaxableRegularPhone extends RegularPhone {
  private double taxRate;

  public TaxableRegularPhone(Money amount, Duration seconds, double taxRate) {
    super(amount, seconds);
    this.taxRate = taxRate;
  }

  @Override
  protected Money afterCalculated(Money fee) {
    return fee.plus(fee.times(taxRate));
  }

}
