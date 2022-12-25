package com.orchsik.object._12_lecture;

import java.util.List;

public class FormattedGradeLecture extends GradeLecture {
  public FormattedGradeLecture(String name, int pass, List<Integer> scores, List<Grade> grades) {
    super(name, pass, scores, grades);
  }

  public String formatAverage() {
    return String.format("Avg: %1.1f", super.average());
  }
}
