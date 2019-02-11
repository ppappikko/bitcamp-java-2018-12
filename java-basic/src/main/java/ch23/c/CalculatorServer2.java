// 계산기 서버 만들기
package ch23.c;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer2 {

  public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행 중....");

      while (true) {
        try (Socket socket = serverSocket.accept();
            PrintStream out = new PrintStream(socket.getOutputStream());
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()))) {

          // 실무에서는 한 줄로 만드는 방법을 선호 (쓸데없는 임시변수 사용 X)
          String[] input = in.readLine().split(" ");

          int a = Integer.parseInt(input[0]);
          String op = input[1];
          int b = Integer.parseInt(input[2]);
          int result = 0;
          
          switch (op) {
            case "+": result = a + b; break;
            case "-": result = a - b; break;
            case "*": result = a * b; break;
            case "/": result = a / b; break;
            case "%": result = a % b; break;
            default:
              out.printf("%s 연산자를 지원하지 않습니다.\n", op);
              out.flush();
              continue;
          }

          out.printf("결과는 %d 입니다.\n", result);
          out.flush();

        }
      } // while


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
