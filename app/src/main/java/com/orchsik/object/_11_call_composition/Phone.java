package com.orchsik.object._11_call_composition;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import com.orchsik.object._02_movie.Money;

@Getter()
public abstract class Phone {
  // Phone 내부에 RatePolicy에 대한 참조자가 포함돼 있다는 것에 주목하라. 이것이 바로 합성이다.
  // Phone이 다양한 요금 정채과 협력할 수 있어야 하므로 요금 정책의 타입이 RatePolicy라는 인터페이스로 정의돼 있다는 것에도
  // 주목하라.
  private RatePolicy ratePolicy;
  private List<Call> calls = new ArrayList<>();

  public Phone(RatePolicy ratePolicy) {
    this.ratePolicy = ratePolicy;
  }

  public Money calculateFee() {
    return ratePolicy.calculateFee(this);
  };

}
