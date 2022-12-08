package com.orchsik.object._04_movie_data_driven;

/**
 * 데이터 클래스들을 조합해서 영화 예매 절차를 구현하는 클래스
 */
public class RservationAgency {

  public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
    Money fee = screening.calcuateFee(audienceCount);
    return new Reservation(customer, screening, fee, audienceCount);
  }

}
