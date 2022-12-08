package com.orchsik.object._04_movie_data_driven;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

/**
 * ⦿ 캡슐화 위반
 * calculateAmountDiscountFee, calculatePercentDiscountFee, calculateNoneDiscountFee 매서드.
 * 여기서 노출시키는 것은 할인 정책의 종류다. 만약 새로운 정책이 추가되거나 제거된다면 어떻게 될 것인가?
 * 아마도 이 메서드들에 의존하는 모든 클라이언트가 영향을 받을 것이다.
 * 
 * isDiscountable 메서드.
 * 캠슐화 위반으로 DiscountCondition의 내부 구현이 외부로 노출됐기 때문에 Movie와 DiscountCondition 사이의
 * 결합도가 높을 수 밖에 없다.
 * DiscountCondition의 기간 할인 조건의 명칭이 PERIOD에서 다른 값으로 변경된다면 Movie를 수정해야 한다.
 * DiscountCondition의 종류가 추가되거나 삭제된다면 Movie 안의 if ~ else 구문을 수정해야 한다.
 * 각 DiscountCondition의 만족 여부를 판단하는 데 필요한 정보가 변경된다면 Movie의 isDiscountable 메서드로 전달된
 * 파라미터를 변경해야 한다.
 */

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
  @Getter()
  private Money fee;
  private List<DiscountCondition> discountConditions;
  @Getter()
  private MovieType movieType;
  @Getter()
  private Money discountAmount;
  @Getter()
  private double discountPercent;

  @Builder
  public Movie(String title, Duration runningTime, Money fee, List<DiscountCondition> discountConditions,
      MovieType movieType, Money discountAmount, double discountPercent) {
    this.title = title;
    this.runningTime = runningTime;
    this.fee = fee;
    this.discountConditions = discountConditions;
    this.movieType = movieType;
    this.discountAmount = discountAmount;
    this.discountPercent = discountPercent;
  }

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
