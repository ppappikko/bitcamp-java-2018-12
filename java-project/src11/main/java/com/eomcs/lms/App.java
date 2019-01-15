package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {
    
    LessonHandler lh1 = new LessonHandler();
    MemberHandler mh1 = new MemberHandler();
    BoardHandler bh1 = new BoardHandler();
    BoardHandler bh2 = new BoardHandler();
    
    lh1.keyboard = keyboard;
    mh1.keyboard = keyboard;
    bh1.keyboard = keyboard;
    bh2.keyboard = keyboard;
    
    while (true) {
      String command = prompt();

      // 조건문을 사용하여 명령어에 따라 처리를 분기
      if (command.equals("/lesson/add")) {
        LessonHandler.addLesson();

      } else if (command.equals("/member/add")) {
        MemberHandler.addMember();

      } else if (command.equals("/board/add")) {
        BoardHandler.addBoard();

      } else if (command.equals("/lesson/list")) {
        LessonHandler.listLesson();

      } else if (command.equals("/member/list")) {
        MemberHandler.listMember();

      } else if (command.equals("/board/list")) {
        BoardHandler.listBoard();

      } else if (command.equals("quit")) {
        System.out.println("안녕!!!");
        break;
      } else {
        System.out.println("실행할 수 없는 명령입니다...");
      }
      // if 조건문에 따라 처리 된 후에 공백 한 줄 
      System.out.println();
    } // while문 종료

    keyboard.close();

  }

  private static String prompt() {
    // 사용자로부터 명령을 입력받는 부분
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }











}
