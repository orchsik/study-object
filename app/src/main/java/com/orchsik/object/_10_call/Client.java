package com.orchsik.object._10_call;

import java.time.Duration;
import java.time.LocalDateTime;

import com.orchsik.object._02_movie.Money;

public class Client {

  /**
   * '10초당 5원'씩 부과되는 요금제에 가입한 사용자가 각각 1분 동안 두 번 통화를 한 경우의 통화 요금을 계산하는 방법을 코드로 나타낸
   * 것 이다.
   */
  public void run() {
    Phone phone = new Phone(Money.wons(5), Duration.ofSeconds(10));
    phone.call(new Call(LocalDateTime.of(2018, 1, 1, 10, 0), LocalDateTime.of(2018, 1, 1, 11, 0)));
    phone.call(new Call(LocalDateTime.of(2018, 1, 2, 10, 0), LocalDateTime.of(2018, 1, 2, 11, 0)));
    phone.calculateFee(); // => Money.wons(60)
  }

}
