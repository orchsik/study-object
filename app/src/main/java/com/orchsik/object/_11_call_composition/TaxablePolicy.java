package com.orchsik.object._11_call_composition;

import com.orchsik.object._02_movie.Money;

public class TaxablePolicy extends AdditionalRatePolicy {
  private double taxRatio;

  public TaxablePolicy(RatePolicy next, double taxRatio) {
    super(next);
    this.taxRatio = taxRatio;
  }

  @Override
  protected Money afterCalculate(Money fee) {
    return fee.plus(fee.times(taxRatio));
  }

}
