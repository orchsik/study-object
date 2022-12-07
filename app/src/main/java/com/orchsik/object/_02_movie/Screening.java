package com.orchsik.object._02_movie;

import java.time.LocalDateTime;

/**
 * 사용자들이 예매하는 대상인 '상영'을 구현한다.
 * 상영할 영화(movie), 순번(sequence), 상영시작시간(whenScreened) 를 인스턴스 변수로 포함.
 */
public class Screening {
  private Movie movie;
  private int sequence;
  private LocalDateTime whenScreened;

  public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
    this.movie = movie;
    this.sequence = sequence;
    this.whenScreened = whenScreened;
  }

  public LocalDateTime getStarTime() {
    return whenScreened;
  }

  public boolean isSequence(int sequence) {
    return this.sequence == sequence;
  }

  public Money getMovieFee() {
    return movie.getFee();
  }

  /**
   * @param customer      - 예매자 정보
   * @param audienceCount - 인원수
   * @return - 영화를 예매한 후 예매 정보를 담고 있는 Reservation의 인스턴스를 생성해서 반환
   */
  public Reservation reserve(Customer customer, int audienceCount) {
    return new Reservation(customer, this, calcuateFee(audienceCount), audienceCount);
  }

  /**
   * @param audienceCount
   * @return - 1인당 예매 요금
   */
  private Money calcuateFee(int audienceCount) {
    return movie.calculateMovieFee(this).times(audienceCount);
  }

}
