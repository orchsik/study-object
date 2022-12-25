package com.orchsik.object._12_lecture;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Lecture의 출력결과에 등급별 통계를 추가
 */
public class GradeLecture extends Lecture {
  private List<Grade> grades;

  public GradeLecture(String title, int pass, List<Integer> scores, List<Grade> grades) {
    super(title, pass, scores);
    this.grades = grades;
  }

  @Override
  public String evaluate() {
    return super.evaluate() + ", " + gradesStatistics();
  }

  public double average(String gradeName) {
    return grades.stream()
        .filter(each -> each.isName(gradeName))
        .findFirst()
        .map(this::gradeAverage)
        .orElse(0d);
  }

  private double gradeAverage(Grade grade) {
    return getScores().stream()
        .filter(grade::include)
        .mapToInt(Integer::intValue)
        .average()
        .orElse(0);
  }

  private String gradesStatistics() {
    return grades.stream()
        .map(grade -> format(grade))
        .collect(Collectors.joining(" "));
  }

  private String format(Grade grade) {
    return String.format("%s:%d", grade.getName(), gradeCount(grade));
  }

  private long gradeCount(Grade grade) {
    return getScores().stream()
        .filter(grade::include)
        .count();
  }

}
