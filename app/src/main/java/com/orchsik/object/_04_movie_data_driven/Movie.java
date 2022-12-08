package com.orchsik.object._04_movie_data_driven;

import java.time.Duration;
import java.util.List;

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

  private MovieType movieType;
  private Money discountAmount;
  private double discountPercent;

  public MovieType getMovieType() {
    return movieType;
  }

  public void setMovieType(MovieType movieType) {
    this.movieType = movieType;
  }

  public Money getFee() {
    return fee;
  }

  public void setFee(Money fee) {
    this.fee = fee;
  }

  public Money getDiscountAmount() {
    return discountAmount;
  }

  public void setDiscountConditions(List<DiscountCondition> discountConditions) {
    this.discountConditions = discountConditions;
  }

  public List<DiscountCondition> getDiscountConditions() {
    return discountConditions;
  }

  public void setDiscountAmount(Money discountAmount) {
    this.discountAmount = discountAmount;
  }

  public double getDiscountPercent() {
    return discountPercent;
  }

  public void setDiscountPercent(double discountPercent) {
    this.discountPercent = discountPercent;
  }

}
