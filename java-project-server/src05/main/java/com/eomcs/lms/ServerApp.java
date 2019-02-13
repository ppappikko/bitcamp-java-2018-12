// 5단계: 받은 객체를 컬렉션에 저장하고 컬렉션에 저장된 객체를 클라이언트로 보내기
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import com.eomcs.lms.domain.Member;

public class ServerApp {
  
  static ArrayList<Member> members = new ArrayList<>();
  static ObjectInputStream in;
  static ObjectOutputStream out;
  
  public static void main(String[] args) {
    
    
    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 시작!");

      while (true) {

        try (Socket socket = serverSocket.accept();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {
          
          System.out.println("클라이언트와 연결되었음.");
          
          // 새로운 클라이언트가 접속하면 이전에 저장된 데이터를 모두 지운다.
          members.clear();
          // 다른 메서드와 공유하기 위해 스태틱 변수에 담는다.
          ServerApp.in = in;
          ServerApp.out = out;
          
          loop: while (true) {
            String request = in.readUTF();
            System.out.println(request);
            
            switch (request) {
              case "quit":
                quit();
                break loop;
              case "add":
                add();
                break;
              case "list":
                list();
                break;
              default:
                out.writeUTF("이 명령을 처리할 수 없음!");
            }
            out.flush();
            
          } // while
          
          /*
          // 클라이언트에서 serialize해서 보내온 Member 객체의 내용을 출력하라!
          Member member = (Member) in.readObject();
          members.add(member);
          
          // 그리고 즉시 클라이언트로 Member 객체를 serialize하여 보내라!
          out.writeObject(member);
          out.flush();
          */
          
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
    out.writeUTF("종료함!");
    out.flush();
  }
  
  static void add() throws Exception {
    members.add((Member)in.readObject());
    out.writeUTF("OK");
  }
  
  static void list() throws Exception {
    out.writeObject(members);
  }

}
