package com.orchsik.object._05_movie;

public class SequenceCondition implements DiscountCondition {

  private int sequence;

  public boolean isSatisfiedBy(Screening screening) {
    return sequence == screening.getSequence();

  }

}
