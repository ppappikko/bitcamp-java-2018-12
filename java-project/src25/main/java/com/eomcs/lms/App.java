package com.eomcs.lms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);
  static Stack<String> commandHistory = new Stack<>();
  static ArrayDeque<String> commandHistory2 = new ArrayDeque<>();

  public static void main(String[] args) {

    LessonHandler lessonHandler = new LessonHandler(keyboard, new ArrayList<>());
    MemberHandler memberHandler = new MemberHandler(keyboard, new ArrayList<>());
    BoardHandler boardHandler1 = new BoardHandler(keyboard, new LinkedList<>());
    BoardHandler boardHandler2 = new BoardHandler(keyboard, new LinkedList<>());

    while (true) {
      String command = prompt();

      // 사용자가 입력한 명령을 스택에 보관한다.
      commandHistory.push(command);
      commandHistory2.offer(command);

      if (command.equals("/lesson/add")) {
        lessonHandler.addLesson();

      } else if (command.equals("/lesson/list")) {
        lessonHandler.listLesson();

      } else if (command.equals("/lesson/detail")) {
        lessonHandler.detailLesson();

      } else if (command.equals("/lesson/update")) {
        lessonHandler.updateLesson();

      } else if (command.equals("/lesson/delete")) {
        lessonHandler.deleteLesson();

      } else if (command.equals("/member/add")) {
        memberHandler.addMember();

      } else if (command.equals("/member/list")) {
        memberHandler.listMember();

      } else if (command.equals("/member/detail")) {
        memberHandler.detailMember();

      } else if (command.equals("/member/update")) {
        memberHandler.updateMember();

      } else if (command.equals("/member/delete")) {
        memberHandler.deleteMember();

      } else if (command.equals("/board/add")) {
        boardHandler1.addBoard();

      } else if (command.equals("/board/list")) {
        boardHandler1.listBoard();

      } else if (command.equals("/board/detail")) {
        boardHandler1.detailBoard();

      } else if (command.equals("/board/update")) {
        boardHandler1.updateBoard();

      } else if (command.equals("/board/delete")) {
        boardHandler1.deleteBoard();

      } else if (command.equals("/board2/add")) {
        boardHandler2.addBoard();

      } else if (command.equals("/board2/list")) {
        boardHandler2.listBoard();

      } else if (command.equals("/board2/detail")) {
        boardHandler2.detailBoard();

      } else if (command.equals("/board2/update")) {
        boardHandler2.updateBoard();

      } else if (command.equals("/board2/delete")) {
        boardHandler2.deleteBoard();

      } else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;

      } else if (command.equals("history")) {
        printCommandHistory(new Iterator<String>() {
          int index = commandHistory.size() - 1;
          
          @Override
          public boolean hasNext() {
            return index >= 0;
          }

          @Override
          public String next() {
            // TODO Auto-generated method stub
            return commandHistory.get(index--);
          }
          
        });

      } else if (command.equals("history2")) {
        printCommandHistory(commandHistory2.iterator());

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }

      System.out.println(); // 결과 출력 후 빈 줄 출력
    }

    keyboard.close();
  }
 
  /*private static void printCommandHistory2() {
    try {
      Iterator<String> iterator = commandHistory2.iterator();
      
      int count = 0;
      while (iterator.hasNext()) {
        System.out.println(iterator.next());
        
        if (++count % 5 == 0) {
          System.out.print(":");
          if (keyboard.nextLine().equalsIgnoreCase("q"))
            break;
        }
      }
    } catch (Exception e) {
      System.out.println("명령어 목록을 출력하는데 실패했습니다.");
    }
  }*/

  private static void printCommandHistory(Iterator<String> iterator) {
    try {
      int count = 0;
      while (iterator.hasNext()) {
        System.out.println(iterator.next());
        
        if (++count % 5 == 0) {
          System.out.print(":");
          if (keyboard.nextLine().equalsIgnoreCase("q"))
            break;
        }
      }
    } catch (Exception e) {
      System.out.println("명령어 목록을 출력하는데 실패했습니다.");
    }
  }

  private static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
}
