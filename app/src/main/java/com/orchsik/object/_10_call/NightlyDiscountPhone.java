package com.orchsik.object._10_call;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import com.orchsik.object._02_movie.Money;

import lombok.Getter;

/**
 * 심야 할인 요금제
 * 밤 10시를 기준으로 요금이 달라진다는 점을 제외하고 Phone과 거의 유사하다
 */
@Getter()
public class NightlyDiscountPhone {
  private static final int LATE_NIGHT_HOUR = 22;

  private Money nightlyAmount; // 심야 단위요금
  private Money regularAmount; // 단위요금
  private Duration seconds; // 단위시간
  private List<Call> calls = new ArrayList<>(); // 통화 목록

  public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
    this.nightlyAmount = nightlyAmount;
    this.regularAmount = regularAmount;
    this.seconds = seconds;
  }

  public void call(Call call) {
    calls.add(call);
  }

  public Money calculateFee() {
    Money result = Money.ZERO;
    for (Call call : calls) {
      if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
        result = result.plus(nightlyAmount.times(call.geDuration().getSeconds() / seconds.getSeconds()));
      } else {
        result = result.plus(regularAmount.times(call.geDuration().getSeconds() / seconds.getSeconds()));
      }
    }
    return result;
  }

}
