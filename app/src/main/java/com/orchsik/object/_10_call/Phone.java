package com.orchsik.object._10_call;

import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
import com.orchsik.object._02_movie.Money;

public abstract class Phone {

  private double taxRate;
  /** 전체 통화 목록 */
  @Getter
  private List<Call> calls = new ArrayList<>();

  public Phone(double taxRate) {
    this.taxRate = taxRate;
  }

  public Money calculateFee() {
    Money result = Money.ZERO;

    for (Call call : calls) {
      result = result.plus(calculateCallFee(call));
    }
    return result.plus(result.times(taxRate));
  }

  abstract protected Money calculateCallFee(Call call);
}
