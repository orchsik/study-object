package com.orchsik.object._04_movie_data_driven;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;

/**
 * @title - 영화제목
 * @runningTime - 상영시간
 * @fee - 기본요금
 * @discountConditions - 할인 조건 목록
 * @movieType - 영화 타입(할인 정책의 종류, 영화별로 하나만 지정, discountAmount와 discountPercent 중
 *            하나의 값만 사용)
 * @discountAmount - 할인 금액
 * @discountPercent - 학인 비율
 */
public class Movie {
  private String title;
  private Duration runningTime;
  private Money fee;
  private List<DiscountCondition> discountConditions;
  @Getter()
  private MovieType movieType;
  private Money discountAmount;
  private double discountPercent;

  public Money calculateAmountDiscountedFee() {
    if (movieType != MovieType.AMOUNT_DISCOUNT) {
      throw new IllegalArgumentException();
    }
    return fee.minus(discountAmount);
  }

  public Money calculatePercentDiscountedFee() {
    if (movieType != MovieType.PERCENT_DISCOUNT) {
      throw new IllegalArgumentException();
    }
    return fee.minus(fee.times(discountPercent));
  }

  public Money calculateNoneDiscountedFee() {
    if (movieType != MovieType.NONE_DISCOUNT) {
      throw new IllegalArgumentException();
    }
    return fee;
  }

  public boolean isDiscountable(LocalDateTime whenScreened, int sequence) {
    for (DiscountCondition condition : discountConditions) {
      if (condition.getType() == DiscountConditionType.PERIOD) {
        if (condition.isDiscountable(whenScreened.getDayOfWeek(), whenScreened.toLocalTime())) {
          return true;
        }
      } else {
        if (condition.isDiscountable(sequence)) {
          return true;
        }
      }
    }
    return false;
  }

}
