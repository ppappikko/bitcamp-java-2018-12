// 계산기 서버 만들기
package ch23.c;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorServer {

  public static void main(String[] args) {

    try (Scanner keyboard = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888)) {

      try (Socket socket = serverSocket.accept();
          DataOutputStream out = new DataOutputStream(
              new BufferedOutputStream(socket.getOutputStream()));
          DataInputStream in = new DataInputStream(
              new BufferedInputStream(socket.getInputStream()))) {

        System.out.println("클라이언트 연결됨!");

        out.writeUTF("계산기 서버에 오신걸 환영합니다!");
        out.writeUTF("계산식을 입력하세요!");
        out.writeUTF("예) 23 + 7");
        out.writeUTF("");
        out.flush();
        System.out.println("클라이언트로 데이터 보냄!");
        while (true) {
          
          int result;
          while (true) {
            String request = in.readUTF();
            String[] requests = request.split("\\s");
            System.out.println("클라이언트로부터 데이터 받음!");

            result = compute(requests);
            System.out.println(result);
            if (result != -1) {
              break;
            }
          }

          out.writeInt(result);
          System.out.println("결과 값 보냄!");
        }
      }

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
