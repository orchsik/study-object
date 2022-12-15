package com.orchsik.object._10_call;

import java.time.Duration;

import com.orchsik.object._02_movie.Money;

public class NightlyDiscountPhone extends Phone {
  private static final int LATE_NIGHT_HOUR = 22;

  private Money nightlyAmount; // 심야 단위요금

  public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate) {
    super(regularAmount, seconds, taxRate);
    this.nightlyAmount = nightlyAmount;
  }

  /**
   * 아래에서 볼 수 있는 것 처럼 상속을 이용해 코드를 재사용하기 위해서는 부모 클래스의 개발자가
   * 세웠던 가정이나 추론 과정을 정확하게 이해해야 한다.
   * 이것은 자식 클래스의 작성자가 부모 클래스의 구현 방법에 대한 정확한 지식을 가져야 한다는 것을 의미한다.
   * 따라서 상속은 결합도를 높인다. 그리고 상속이 초래하는 부모 클래스와 자식 클래스 사이의 강한 결합이 코드를 수정하기 어렵게 만든다.
   */
  @Override
  public Money calculateFee() {
    Money result = super.calculateFee();
    Money nightlyFee = Money.ZERO;
    for (Call call : getCalls()) {
      if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
        nightlyFee = nightlyFee.plus(getAmount().minus(nightlyAmount).times(
            call.geDuration().getSeconds() / getSeconds().getSeconds()));
      }
    }
    return result.minus(nightlyFee.plus(nightlyFee.times(getTaxRate())));
  }

}
