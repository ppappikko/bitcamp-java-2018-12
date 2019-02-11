// 계산기 서버 만들기
package ch23.test;

import java.net.ServerSocket;

public class CalculatorServer {

  public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행 중..");

      while (true) {
        try {
          new CalculatorProcessor(serverSocket.accept()).execute();
        } catch (Exception e) {
          System.out.println("클라이언트와 통신 중에 오류 발생!");
          e.printStackTrace();
        }
      } // while

    } catch (Exception e) {
      e.printStackTrace();
    }

  } // main()



}
