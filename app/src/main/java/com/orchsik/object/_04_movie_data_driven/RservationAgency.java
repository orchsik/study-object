package com.orchsik.object._04_movie_data_driven;

/**
 * ⦿ 높은 결합도 + 닞은 응집도
 * 데이터의 타입 변경으로 인해 협력하는 클래스가 변경되기 때문에 접근자 메서드는 데이터를 정상적으로
 * 캡슐화하지 못 한다.
 * 
 * 데이터 중심의 설계는 여러 데이터 객체들을 사용하는 제어 로직이 특정 객체 안에 집중되기 때문에
 * 하나의 제어 객체가 다수의 데이터 객체에 강하게 결합된다는 것이다. 이 결합도로 인해 어떤 데이터 객체를
 * 변경하더라도 제어 객체를 함께 변경할 수 밖에 없다.
 */

/**
 * 데이터 클래스들을 조합해서 영화 예매 절차를 구현하는 클래스
 */
public class RservationAgency {

  public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
    Movie movie = screening.getMovie();

    /**
     * DiscountCondition에 대해 루프를 돌면서 할인 가능 여부를 확인
     */
    boolean discountable = false;
    for (DiscountCondition condition : movie.getDiscountConditions()) {
      if (condition.getType() == DiscountConditionType.PERIOD) {
        discountable = screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek())
            && condition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0
            && condition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
      } else {
        discountable = condition.getSequence() == screening.getSequence();
      }

      if (discountable) {
        break;
      }
    }

    /**
     * discountable 변수의 값을 체크하고 적절한 할인 정책에 따라 예매 요금을 계산
     */
    Money fee;
    if (discountable) {
      Money discountAmount = Money.ZERO;
      switch (movie.getMovieType()) {
        case AMOUNT_DISCOUNT:
          discountAmount = movie.getDiscountAmount();
          break;
        case PERCENT_DISCOUNT:
          discountAmount = movie.getFee().times(movie.getDiscountPercent());
          break;
        case NONE_DISCOUNT:
          discountAmount = Money.ZERO;
          break;
        default:
          break;
      }
      fee = movie.getFee().minus(discountAmount);
    } else {
      fee = movie.getFee();
    }

    return new Reservation(customer, screening, fee, audienceCount);
  }

}
