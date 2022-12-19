package com.orchsik.object._11_call;

import java.util.ArrayList;
import java.util.List;
import com.orchsik.object._02_movie.Money;

public abstract class Phone {
  private List<Call> calls = new ArrayList<>();

  public Money calculateFee() {
    Money result = Money.ZERO;
    for (Call call : calls) {
      result = result.plus(calculateCallFee(call));
    }
    return result;
  }

  abstract protected Money calculateCallFee(Call call);

}
