package com.eomcs.lms.handler;

import com.eomcs.lms.domain.Lesson;

public class LessonList {
  
  private int LENGTH = 10;
  private Lesson[] lessonList = new Lesson[LENGTH];
  private int lessonIdx = 0;
  
  public LessonList() {
    
  }
  
  public LessonList(int LENGTH) {
    this.LENGTH = LENGTH;
  }
  
  public Lesson[] toArray() {
    // 전체 배열의 크기 100이라면,
    // 현재 들어있는 항목만 따로 배열을 만들어 리턴한다
    Lesson[] lessons = new Lesson[lessonIdx];
    for (int i = 0; i < lessonIdx; i++) {
      lessons[i] = lessonList[i];
    }
    return lessons;
  }
  
  public void add(Lesson lesson) {
    lessonList[lessonIdx] = lesson;
    lessonIdx++;
  }
}
