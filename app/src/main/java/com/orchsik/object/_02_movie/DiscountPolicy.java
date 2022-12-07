package com.orchsik.object._02_movie;

public interface DiscountPolicy {
  public Money calculateDiscountAmount(Screening screening);
}
