package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.App;
import com.eomcs.lms.domain.Lesson;

public class LessonHandler {

  final int LENGTH = 2;
  Lesson[] lessons = new Lesson[App.LENGTH];
  int lessonIdx = 0;
  public Scanner keyboard;

  public void addLesson() {

    if (lessonIdx == App.LENGTH) {
      System.out.println("더 이상 추가할 수 없습니다..!");
    } else {


      // 클래스로 정의한 새 데이터 타입의 메모리(인스턴스) 만들기
      Lesson lesson = new Lesson();

      // 사용자가 입력한 값을 메모리에 담는다.
      System.out.print("번호? ");
      lesson.no = Integer.parseInt(keyboard.nextLine());

      System.out.print("수업명? ");
      lesson.title = keyboard.nextLine();

      System.out.print("설명? ");
      lesson.contents = keyboard.nextLine();

      System.out.print("시작일? ");
      lesson.startDate = Date.valueOf(keyboard.nextLine());

      System.out.print("종료일? ");
      lesson.endDate = Date.valueOf(keyboard.nextLine());

      System.out.print("총수업시간? ");
      lesson.totalHours = Integer.parseInt(keyboard.nextLine());

      System.out.print("일수업시간? ");
      lesson.dayHours = Integer.parseInt(keyboard.nextLine());

      // i 번째 배열에 수업 정보를 담고 있는 Lesson 객체(의 주소)를 보관한다.
      lessons[lessonIdx] = lesson;
      lessonIdx++;

      System.out.print("\n저장하였습니다!");
    }
  }
  public void listLesson() {
    // lesson 출력 부분
    for (int j = 0; j < lessonIdx; j++) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          lessons[j].no, lessons[j].title, lessons[j].startDate, 
          lessons[j].endDate, lessons[j].totalHours);
    }
  }
}
