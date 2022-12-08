package com.orchsik.object._04_movie_data_driven;

import java.math.BigDecimal;

/**
 * 금액과 관련된 다양한 계산을 구현하는 간단한 클래스
 */
public class Money {
  public static final Money ZERO = Money.wons(0);

  private final BigDecimal amount;

  public static Money wons(long amount) {
    return new Money(BigDecimal.valueOf(amount));
  }

  public static Money wons(double amount) {
    return new Money(BigDecimal.valueOf(amount));
  }

  Money(BigDecimal amount) {
    this.amount = amount;
  }

  public Money plus(Money amount) {
    return new Money(this.amount.add(amount.amount));
  }

  public Money minus(Money amount) {
    return new Money(this.amount.subtract(amount.amount));
  }

  public Money times(double percent) {
    return new Money(this.amount.multiply(BigDecimal.valueOf(percent)));
  }

  public boolean isLessThan(Money other) {
    return amount.compareTo(other.amount) < 0;
  }

  public boolean isGreaterThanOrEqual(Money other) {
    return amount.compareTo(other.amount) >= 0;
  }

}
