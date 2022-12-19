package com.orchsik.object._11_call_composition;

import java.time.Duration;
import com.orchsik.object._02_movie.Money;

public class RegularPolicy extends BasicRatePolicy {
  private Money amount;
  private Duration seconds;

  public RegularPolicy(Money amount, Duration seconds) {
    this.amount = amount;
    this.seconds = seconds;
  }

  @Override
  protected Money calculateCallFee(Call call) {
    return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
  }

}
