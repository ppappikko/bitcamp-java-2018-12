package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {

    // keyboard를 파라미터 값으로 받는 생성자를 사용!
    LessonHandler lessonHandler1 = new LessonHandler(keyboard);
    MemberHandler memberHandler1 = new MemberHandler(keyboard);
    BoardHandler boardHandler1 = new BoardHandler(keyboard);
    BoardHandler boardHandler2 = new BoardHandler(keyboard);

    while (true) {
      String command = prompt();

      if (command.equals("/lesson/add")) {
        lessonHandler1.addLesson();

      } else if (command.equals("/lesson/list")) {
        lessonHandler1.listLesson();

      } else if (command.equals("/member/add")) {
        memberHandler1.addMember();

      } else if (command.equals("/member/list")) {
        memberHandler1.listMember();

      } else if (command.equals("/board/add")) {
        boardHandler1.addBoard();

      } else if (command.equals("/board/list")) {
        boardHandler1.listBoard();

      } else if (command.equals("/board2/add")) {
        boardHandler2.addBoard();

      } else if (command.equals("/board2/list")) {
        boardHandler2.listBoard();

      } else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }

      System.out.println(); // 결과 출력 후 빈 줄 출력
    }

    keyboard.close();
  }

  private static String prompt() {
    System.out.print("명령> ");
    String command = keyboard.nextLine().toLowerCase();
    return command;
  }






}
