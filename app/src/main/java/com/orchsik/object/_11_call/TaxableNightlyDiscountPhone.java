package com.orchsik.object._11_call;

import java.time.Duration;
import com.orchsik.object._02_movie.Money;

public class TaxableNightlyDiscountPhone extends NightlyDiscountPhone {
  private double taxRate;

  public TaxableNightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate) {
    super(nightlyAmount, regularAmount, seconds);
    this.taxRate = taxRate;
  }

  @Override
  protected Money afterCalculated(Money fee) {
    return fee.plus(fee.times(taxRate));
  }

}
