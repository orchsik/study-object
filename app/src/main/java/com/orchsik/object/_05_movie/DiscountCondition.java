package com.orchsik.object._05_movie;

/**
 * 변경으로 부터 보호 됨.
 * 새로운 DiscountCondition 타입을 추가하더라도 Movie가 영향을 받지 않는다는 것을 의미한다.
 * 오직 Discount 인터페이스를 실체화하는 클래스를 추가하는 것으로 할인 조건의 종류를 확장할 수 있다.
 */
public interface DiscountCondition {
  public boolean isSatisfiedBy(Screening screening);
}
