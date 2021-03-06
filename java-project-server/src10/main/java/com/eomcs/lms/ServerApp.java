// 10단계: 데이터를 파일로 관리한다.
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import com.eomcs.lms.service.BoardService;
import com.eomcs.lms.service.LessonService;
import com.eomcs.lms.service.MemberService;

public class ServerApp {

  static ObjectInputStream in;
  static ObjectOutputStream out;

  static MemberService memberService = null;
  static LessonService lessonService = null;
  static BoardService boardService = null;

  public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 시작!");

      try {
        memberService = new MemberService();
        memberService.loadData("member.bin");

      } catch (Exception e) {
        System.out.println("회원 데이터 로딩 중 오류 발생!");
        //e.printStackTrace();
      }

      try {
        lessonService = new LessonService();
        lessonService.loadData("lesson.bin");

      } catch (Exception e) {
        System.out.println("수업 데이터 로딩 중 오류 발생!");
        //e.printStackTrace();
      }

      try {
        boardService = new BoardService();
        boardService.loadData("board.bin");

      } catch (Exception e) {
        System.out.println("게시물 데이터 로딩 중 오류 발생!");
        //e.printStackTrace();
      }

      while (true) {

        try (Socket socket = serverSocket.accept();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

          // 클라이언트 마다 input, output이 다르기 때문
          memberService.init(in, out);
          lessonService.init(in, out);
          boardService.init(in, out);

          System.out.println("클라이언트와 연결되었음.");

          loop: while (true) {
            String request = in.readUTF();
            System.out.println(request);

            // .startsWith("x") - x값으로 시작하는 문장에 대해 true를 반환
            if (request.startsWith("/member/")) {
              memberService.execute(request);

            } else if (request.startsWith("/lesson/")) {
              lessonService.execute(request);

            } else if (request.startsWith("/board/")) {
              boardService.execute(request);

            } else if (request.equals("quit")) {
              quit();
              break loop;

            } else {
              out.writeUTF("FAIL");
            }
            out.flush();

          } // while

        } catch (Exception e) {
          e.printStackTrace();
        }
        System.out.println("클라이언트와 연결을 끊었음.");

      } // while

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  static void quit() throws Exception {
    
    // try ~ catch 를 각각 해준다.
    // 같이 묶어 놓으면 하나가 오류 발생했을 때
    // 나머지도 저장이 되지 않는다.
    try {
      memberService.saveData();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      //e.printStackTrace();
    }

    try {
      lessonService.saveData();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      //e.printStackTrace();
    }

    try {
      boardService.saveData();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      //e.printStackTrace();
    }

    out.writeUTF("종료함!");
    out.flush();
  }

}
