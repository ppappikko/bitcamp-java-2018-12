package com.eomcs.lms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import com.eomcs.lms.context.ApplicationContextListener;
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
import com.eomcs.lms.listener.BoardDataLoaderListener;
import com.eomcs.lms.listener.LessonDataLoaderListener;
import com.eomcs.lms.listener.MemberDataLoaderListener;

public class App {

  // 사용할 리스너(옵저버)들을 담는 observers 리스트를 생성
  static ArrayList<ApplicationContextListener> observers = new ArrayList<>();

  // observers 리스트에 ApplicationContextListener 인터페이스를 구현한 클래스를 추가
  static void addApplicationContextListener(ApplicationContextListener listener) {
    observers.add(listener);
  }

  // 지금 이 App에서 사용할 객체들을 미리 준비해서 보관소에 저장한다. (context)
  static HashMap<String, Object> context = new HashMap<>();

  static {
    context.put("keyboard", new Scanner(System.in));
    context.put("commandHistory", new Stack<>());
    context.put("commandHistory2", new LinkedList<>());
    context.put("lessonList", new ArrayList<>());
    context.put("memberList", new LinkedList<>());
    context.put("boardList", new ArrayList<>());
  }
  
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    
    addApplicationContextListener(new LessonDataLoaderListener());
    addApplicationContextListener(new MemberDataLoaderListener());
    addApplicationContextListener(new BoardDataLoaderListener());
    
    for (ApplicationContextListener observer : observers) {
      try {
        observer.startApplication(context);
      } catch (Exception e) {}
    }
    
    Scanner keyboard = (Scanner) context.get("keyboard");
    Map<String,Command> commandMap = new HashMap<>();
    
    ArrayList<Lesson> lessonList =
        (ArrayList<Lesson>) context.get("lessonList");
    
    commandMap.put("/lesson/add", new LessonAddCommand(keyboard, lessonList));
    commandMap.put("/lesson/list", new LessonListCommand(keyboard, lessonList));
    commandMap.put("/lesson/detail", new LessonDetailCommand(keyboard, lessonList));
    commandMap.put("/lesson/update", new LessonUpdateCommand(keyboard, lessonList));
    commandMap.put("/lesson/delete", new LessonDeleteCommand(keyboard, lessonList));

    LinkedList<Member> memberList =
        (LinkedList<Member>) context.get("memberList");
    
    commandMap.put("/member/add", new MemberAddCommand(keyboard, memberList));
    commandMap.put("/member/list", new MemberListCommand(keyboard, memberList));
    commandMap.put("/member/detail", new MemberDetailCommand(keyboard, memberList));
    commandMap.put("/member/update", new MemberUpdateCommand(keyboard, memberList));
    commandMap.put("/member/delete", new MemberDeleteCommand(keyboard, memberList));

    ArrayList<Board> boardList =
        (ArrayList<Board>) context.get("boardList");
    
    commandMap.put("/board/add", new BoardAddCommand(keyboard, boardList));
    commandMap.put("/board/list", new BoardListCommand(keyboard, boardList));
    commandMap.put("/board/detail", new BoardDetailCommand(keyboard, boardList));
    commandMap.put("/board/update", new BoardUpdateCommand(keyboard, boardList));
    commandMap.put("/board/delete", new BoardDeleteCommand(keyboard, boardList));
    
    Stack<String> commandHistory =
        (Stack<String>) context.get("commandHistory");
    Queue<String> commandHistory2 =
        (Queue<String>) context.get("commandHistory2");
    
    while (true) {
      String command = prompt();

      // 사용자가 입력한 명령을 스택에 보관한다.
      commandHistory.push(command);

      // 사용자가 입력한 명령을 큐에 보관한다.
      commandHistory2.offer(command);

      // 사용자가 입력한 명령으로 Command 객체를 찾는다.
      Command commandHandler = commandMap.get(command);

      if (commandHandler != null) {
        try {
          commandHandler.execute();
        } catch (Exception e) {
          System.out.println("명령어 실행 중 오류 발생 : " + e.toString());
        }
      } else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;

      } else if (command.equals("history")) {
        printCommandHistory();

      } else if (command.equals("history2")) {
        printCommandHistory2();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }

      System.out.println(); 
    }

    keyboard.close();

  }

  @SuppressWarnings("unchecked")
  private static void printCommandHistory() {
    Stack<String> commandHistory =
        (Stack<String>) context.get("commandHistory");
    
    Stack<String> temp = (Stack<String>) commandHistory.clone();

    while (temp.size() > 0) {
      System.out.println(temp.pop());
    }
  }

  @SuppressWarnings("unchecked")
  private static void printCommandHistory2() {
    Queue<String> commandHistory2 =
        (Queue<String>) context.get("commandHistory2");
    
    Queue<String> temp = (Queue<String>) ((LinkedList<String>) commandHistory2).clone();

    while (temp.size() > 0) {
      System.out.println(temp.poll());
    }
  }

  private static String prompt() {
    Scanner keyboard =
        (Scanner) context.get("keyboard");
    
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }


}
