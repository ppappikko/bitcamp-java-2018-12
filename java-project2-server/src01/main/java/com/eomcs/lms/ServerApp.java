// 1단계: 클라이언트 요청에 응답하는 서버 프로그램으로 전환하기
//
//클라이언트와 서버 사이의 통신 규칙
//
//규칙1) 단순한 명령어 전송과 실행 결과 수신
//
//[클라이언트]                                        [서버]
//서버에 연결 요청        -------------->           연결 승인
//명령(CRLF)              -------------->           명령처리
//화면 출력               <--------------           응답(CRLF)
//화면 출력               <--------------           응답(CRLF)
//명령어 실행 완료        <--------------           !end!(CRLF)
//
//규칙2) 사용자 입력을 포함하는 경우
//
//[클라이언트]                                        [서버]
//서버에 연결 요청        -------------->           연결 승인
//명령(CRLF)              -------------->           명령처리
//화면 출력               <--------------           응답(CRLF)
//사용자 입력 요구        <--------------           !{}!(CRLF)
//입력값(CRLF)            -------------->           입력 값 처리
//화면 출력               <--------------           응답(CRLF)
//사용자 입력 요구        <--------------           !{}!(CRLF)
//입력값(CRLF)            -------------->           입력 값 처리
//명령어 실행 완료        <--------------           !end!(CRLF)
//
package com.eomcs.lms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.handler.Command;

public class ServerApp {

  ArrayList<ApplicationContextListener> listeners = new ArrayList<>();

  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  public void service() throws Exception {

    try (ServerSocket ss = new ServerSocket(8888)) {

      HashMap<String,Object> context = new HashMap<>();

      for (ApplicationContextListener listener : listeners) {
        listener.contextInitialized(context);
      }
      
      System.out.println("서버 실행 중...");
      
      while (true) {

        try (Socket socket = ss.accept();
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream())) {

          // 클라이언트의 요청 읽기
          String request = in.readLine();
          if (request.equalsIgnoreCase("stop")) {
            System.out.println("종료합니다.");
            break;
          }
          
          // 클라이언트에게 응답하기
          out.println("ok");
          out.println("!end!");
          out.flush();
          
          /*
          commandHistory.push(command);
          commandHistory2.offer(command);

          if (command.equals("quit")) {
            System.out.println("종료합니다.");
            break;

          } else if (command.equals("history")) {
            printCommandHistory();
            continue;

          } else if (command.equals("history2")) {
            printCommandHistory2();
            continue;

          }

          // 사용자가 입력한 명령으로 Command 객체를 찾는다.
          Command commandHandler = (Command) context.get(command);
          if (commandHandler == null) {
            System.out.println("실행할 수 없는 명령입니다.");
            continue;
          }

          // stateful을 stateless로 전환할 때 주의할 점!
          // => 가능한 서버에 요청하는 시점에 서버와 연결하라!
          // => 이 클래스에서 서버와 연결하지 않고
          //    데이터를 요청하는 일을 하는 객체(*Agent)에 서버 연결을 맡긴다.

          try {
            commandHandler.execute();
            System.out.println();

          } catch (Exception e) {
            System.out.println("명령어 실행 중 오류 발생 : " + e.toString());
          }
          */

        } // try(Socket)
      } // while

      for (ApplicationContextListener listener : listeners) {
        listener.contextDestroyed(context);
      }

    } catch (Exception e) {
      e.printStackTrace();
    } // try(ServerSocket)

  }

  public static void main(String[] args) throws Exception {
    ServerApp app = new ServerApp();
    
    // App이 실행되거나 종료될 때
    app.addApplicationContextListener(new ApplicationInitializer());
    
    // App 을 실행한다.
    app.service();
  }
}
