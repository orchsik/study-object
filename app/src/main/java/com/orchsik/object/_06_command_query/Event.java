package com.orchsik.object._06_command_query;

import java.time.Duration;
import java.time.LocalDateTime;

public class Event {
  private String subject; // 이벤트 주제
  private LocalDateTime from; // 시작 일시
  private Duration duration; // 소요 시간

  public Event(String subject, LocalDateTime from, Duration duration) {
    this.subject = subject;
    this.from = from;
    this.duration = duration;
  }

  /**
   * 버그가 발생할 수 있음.
   * 명령과 쿼리의 두 가지 역할을 동시에 수행하고 있기 때문에.
   * Event가 RecurringSchedule에 설정된 조건을 만족하지 못할 경우 Event의 상태를 조건을
   * 만족시키도록 변경한 후(여기가 문제다!) false를 반환한다.
   */
  public boolean isSatisfied(RecurringSchedule schedule) {
    if (from.getDayOfWeek() != schedule.getDayOfWeek()
        || !from.toLocalTime().equals(schedule.getFrom())
        || !duration.equals(schedule.getDuration())) {
      reschedule(schedule);
    }
    return true;
  }

  public void reschedule(RecurringSchedule schedule) {
    from = LocalDateTime.of(from.toLocalDate().plusDays(daysDistance(schedule)), schedule.getFrom());
    duration = schedule.getDuration();
  }

  private long daysDistance(RecurringSchedule schedule) {
    return schedule.getDayOfWeek().getValue() - from.getDayOfWeek().getValue();
  }

}
