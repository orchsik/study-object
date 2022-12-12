package com.orchsik.object._05_movie;

import java.time.LocalDateTime;

import lombok.Getter;

public class Screening {
  /**
   * 2) 책임이 결정됐으므로 책임을 수행하는 데 필요한 인스턴스 변수를 결정해야 한다.
   */
  private Movie movie;
  @Getter()
  private int sequence;
  @Getter()
  private LocalDateTime whenScreened;

  /**
   * 1) 협력의 관점에서 "예매하라"는 메시지에 응답할 수 있어야 한다.
   */
  public Reservation reserve(Customer customer, int audiencCount) {
    return new Reservation(customer, calculateFee(audiencCount), audiencCount);
  }

  /**
   * 3) 영화를 예매하기 위해서는 movie에게 "가격을 계산하라" 메시지를 전송해서 계산된 영화 요금을
   * 반환받아야 한다.
   * - Movie에 전송하는 메시지의 시그니처를 calculateMovieFee(Screening screening)으로 선언했다는 사실에
   * 주목하라. 이 메시지는 수신자인 Movie가 아니라 송신자인 Screening의 의도를 표현한한다. 이처럼 Movie의 구현을 고려하지
   * 않고 필요한 메시지를 결정하면 Movie의 내부 구현을 캡슐화할 수 있다.
   */
  private Money calculateFee(int audiencCount) {
    return movie.calculateMovieFee(this).times(audiencCount);
  }

}
