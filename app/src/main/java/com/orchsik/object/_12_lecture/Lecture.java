package com.orchsik.object._12_lecture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lecture {
  private String title;
  private int pass;
  private List<Integer> scores = new ArrayList<>();

  public Lecture(String title, int pass, List<Integer> scores) {
    this.pass = pass;
    this.title = title;
    this.scores = scores;
  }

  // 학생들의 평균 성적을 리턴한다.
  public double average() {
    return scores.stream()
        .mapToInt(Integer::intValue)
        .average()
        .orElse(0);
  }

  // 학생들의 성적을 리턴한다.
  public List<Integer> getScores() {
    return Collections.unmodifiableList(scores);
  }

  // 강의를 이수한 학생의 수와 낙제한 학생의 수를 형식에 맞게 구성한 문자열을 리턴한다.
  public String evaluate() {
    return String.format("Pass:%d Fail:%d", passCount(), failCount());
  }

  private long passCount() {
    return scores.stream().filter(score -> score >= pass).count();
  }

  private long failCount() {
    return scores.stream().filter(score -> score < pass).count();
  }

}
