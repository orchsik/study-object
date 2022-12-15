package com.orchsik.object._10_call;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import com.orchsik.object._02_movie.Money;

import lombok.Getter;

/**
 * 통화 요금을 계산할 객체가 필요
 * 전체 통화 목록에 대해 알고 있는 정보 전문가에게 요금 계산 책임을 할당해야 한다
 * 일반적으로 통화 목록은 전화기 안에 보관된다
 * 따라서 Call 목록을 관리할 정보 전문가는 Phone 이다
 */
@Getter()
public class Phone {
  private Money amount; // 단위요금
  private Duration seconds; // 단위시간
  private List<Call> calls = new ArrayList<>(); // 통화 목록
  private double taxRate; // 세금

  public Phone(Money amount, Duration seconds, double taxRate) {
    this.amount = amount;
    this.seconds = seconds;
    this.taxRate = taxRate;
  }

  public void call(Call call) {
    calls.add(call);
  }

  public Money calculateFee() {
    Money result = Money.ZERO;
    for (Call call : calls) {
      result = result.plus(amount.times(call.geDuration().getSeconds() / seconds.getSeconds()));
    }
    return result.minus(result.times(taxRate));
  }

}
