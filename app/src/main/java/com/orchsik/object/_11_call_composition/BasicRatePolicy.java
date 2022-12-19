package com.orchsik.object._11_call_composition;

import com.orchsik.object._02_movie.Money;

// 기본 정책을 구성하는 일반 요금제와 심야 할인 요금제는 개별 요금을 계산하는 방식을 제외한 전체 처리 로직이 거의 동일하다.
public abstract class BasicRatePolicy implements RatePolicy {

  @Override
  public Money calculateFee(Phone phone) {
    Money result = Money.ZERO;
    for (Call call : phone.getCalls()) {
      result.plus(calculateCallFee(call));
    }
    return null;
  }

  protected abstract Money calculateCallFee(Call call);

}
