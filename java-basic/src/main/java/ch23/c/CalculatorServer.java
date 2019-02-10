// 계산기 서버 만들기
package ch23.c;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorServer {

  public static void main(String[] args) {

    try (Scanner keyboard = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888)) {

      try (Socket socket = serverSocket.accept();
          PrintWriter out = new PrintWriter(socket.getOutputStream());
          Scanner in = new Scanner(socket.getInputStream())) {

        System.out.println("클라이언트 연결됨!");

        out.println("계산기 서버에 오신걸 환영합니다!");
        out.println("계산식을 입력하세요!");
        out.println("예) 23 + 7");
        out.flush();

        System.out.println("클라이언트로 안내 데이터 보냄!");
        while (true) {

          String request = in.nextLine();
          System.out.println("클라이언트로부터 데이터 받음!");

          String[] requests = request.split("\\s");

          if (request.equalsIgnoreCase("quit")) {
            out.println("안녕히 가세요!");
            out.flush();
            break;
            
          } else {

            int result = compute(requests);
            System.out.println(result);

            if (result == -1) {
              out.println("^ 연산자를 지원하지 않습니다.");
              out.flush();
            } else {

              out.println("결과는 " + result + "입니다.");
              out.flush();
              System.out.println("결과 값 보냄!");
            }
          }
        }
      }
      System.out.println("클라이언트와 연결 끊음");
      
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  private static int compute(String[] requests) {
    int result = -1;
    int a, b;
    a = Integer.parseInt(requests[0]);
    b = Integer.parseInt(requests[2]);

    switch (requests[1]) {
      case "+": result = a + b;
      break;
      case "-": result = a - b;
      break;
      case "*": result = a * b;
      break;
      case "/": result = a / b;
      break;
      case "%": result = a % b;
      break;
      default : result = -1;
      break;
    }

    return result;
  }

}
