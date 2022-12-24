package com.orchsik.object._12_lecture;

import java.util.ArrayList;
import java.util.Arrays;

public class Client {
  public static void main() {
    /**
     * 이수 기준이 70점인 객체지향 프로그래밍 과목의 수강생 5명에 대한 성정 통계를 구하는 코드
     */
    Lecture lecture = new Lecture("객체지향 프로그래밍", 70, Arrays.asList(81, 95, 75, 50, 45));
    String evaluation = lecture.evaluate(); // 결과 => "Pass:3 Fail:2"
  }
}
