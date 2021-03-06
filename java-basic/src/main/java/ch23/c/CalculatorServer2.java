// 계산기 서버 만들기
package ch23.c;

import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer2 {

  public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행 중....");

      while (true) {
        try {
          
          // 한 번만 실행하면 되기 때문에 로컬 변수 사용하지 않고
          // CalculatorProcessor 객체를 만들면서 바로 execute()를 호출 한다.
          new CalculatorProcessor(serverSocket.accept()).execute();
          
        } catch (Exception e) {
          System.out.println("클라이언트와 통신 중에 오류 발생!");
          e.printStackTrace();
        }
      } // while


    } catch (Exception e) {
      e.printStackTrace();
    }

  }
  
  static void processRequest(Socket socket) {
    
  }
  
}
