package com.orchsik.object._11_call_composition;

import com.orchsik.object._02_movie.Money;

public interface RatePolicy {
  Money calculateFee(Phone phone);
}
