package com.orchsik.object._02_movie;

/**
 * 할인 여부를 판단하기 위해 사용할 순번(sequence)을 인스턴스 변수로 포함
 */
public class SequenceCondition implements DiscountCondition {
  private int sequence;

  public SequenceCondition(int sequence) {
    this.sequence = sequence;
  }

  @Override
  public boolean isSatisfiedBy(Screening screening) {
    return screening.isSequence(sequence);
  }

}
