package com.eomcs.lms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardDeleteCommand;
import com.eomcs.lms.handler.BoardDetailCommand;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.BoardUpdateCommand;
import com.eomcs.lms.handler.Command;
import com.eomcs.lms.handler.LessonAddCommand;
import com.eomcs.lms.handler.LessonDeleteCommand;
import com.eomcs.lms.handler.LessonDetailCommand;
import com.eomcs.lms.handler.LessonListCommand;
import com.eomcs.lms.handler.LessonUpdateCommand;
import com.eomcs.lms.handler.MemberAddCommand;
import com.eomcs.lms.handler.MemberDeleteCommand;
import com.eomcs.lms.handler.MemberDetailCommand;
import com.eomcs.lms.handler.MemberListCommand;
import com.eomcs.lms.handler.MemberUpdateCommand;

public class App {

  static Scanner keyboard = new Scanner(System.in);
  static Stack<String> commandHistory = new Stack<>();
  static ArrayDeque<String> commandHistory2 = new ArrayDeque<>();

  public static void main(String[] args) {

    LinkedList<Lesson> lessonList = new LinkedList<>();
    LinkedList<Member> memberList = new LinkedList<>();
    ArrayList<Board> boardList = new ArrayList<>();
    HashMap<String, Command> commandMap = new HashMap<>();
    
    commandMap.put("/lesson/add", new LessonAddCommand(keyboard, lessonList));
    commandMap.put("/lesson/list", new LessonListCommand(keyboard, lessonList));
    commandMap.put("/lesson/detail", new LessonDetailCommand(keyboard, lessonList));
    commandMap.put("/lesson/update", new LessonUpdateCommand(keyboard, lessonList));
    commandMap.put("/lesson/delete", new LessonDeleteCommand(keyboard, lessonList));
    
    commandMap.put("/member/add", new MemberAddCommand(keyboard, memberList));
    commandMap.put("/member/list", new MemberListCommand(keyboard, memberList));
    commandMap.put("/member/detail", new MemberDetailCommand(keyboard, memberList));
    commandMap.put("/member/update", new MemberUpdateCommand(keyboard, memberList));
    commandMap.put("/member/delete", new MemberDeleteCommand(keyboard, memberList));
    
    commandMap.put("/board/add", new BoardAddCommand(keyboard, boardList));
    commandMap.put("/board/list", new BoardListCommand(keyboard, boardList));
    commandMap.put("/board/detail", new BoardDetailCommand(keyboard, boardList));
    commandMap.put("/board/update", new BoardUpdateCommand(keyboard, boardList));
    commandMap.put("/board/delete", new BoardDeleteCommand(keyboard, boardList));
    
    while (true) {
      String command = prompt();

      // 사용자가 입력한 명령을 스택에 보관한다.
      commandHistory.push(command);
      commandHistory2.offer(command);


      if (command.equals("quit")) {
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
        Command commandHandler = commandMap.get(command);
        
        if (commandHandler == null) {
          System.out.println("실행할 수 없는 명령입니다.");
        } else {
          commandHandler.execute();
        }
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
