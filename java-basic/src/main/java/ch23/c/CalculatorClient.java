// 계산기 클라이언트 만들기 : 최소 +, -, *, /, % 연산자는 지원한다.
package ch23.c;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/*
실행 예:
- 클라이언트가 계산기 서버에 접속한 후

계산기 서버에 오신 걸 환영합니다! <== 서버의 응답
계산식을 입력하세요! <== 서버의 응답
예) 23 + 7 <== 서버의 응답
> 23 + 7 <== 사용자의 입력. '>'문자는 클라이언트에서 출력한다.
결과는 30입니다. <== 서버의 응답
> 23 ^ 7 <== 사용자의 입력.'>'문자는 클라이언트에서 출력한다.
^ 연산자를 지원하지 않습니다. <== 서버의 응답
> ok + yes <== 사용자의 입력.'>'문자는 클라이언트에서 출력한다.
식의 형식이 잘못되었습니다. <== 서버의 응답
> quit <== 사용자의 입력.'>'문자는 클라이언트에서 출력한다.
안녕히 가세요! <== 서버의 응답

 */
public class CalculatorClient {

  public static void main(String[] args) {

    try (Socket socket = new Socket("localhost", 8888);
        DataOutputStream out = new DataOutputStream(
            new BufferedOutputStream(socket.getOutputStream()));
        DataInputStream in = new DataInputStream(
            new BufferedInputStream(socket.getInputStream()))) {

      try (Scanner keyboard = new Scanner(System.in)) {
        System.out.println("서버와 연결됨!");

        while (true) {
          System.out.println(in.readUTF());
          if (in.readUTF().equals("")) {
            break;
          }
        }
        while (true) {

          while (true) {
            System.out.print("> ");
            String input = keyboard.nextLine();
            out.writeUTF(input);
            out.flush();

            if (input.length() != 0) {
              break;
            }
          }

          int response = in.readInt();
          System.out.println("결과는 " + response + "입니다.");
        }
      }


    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
