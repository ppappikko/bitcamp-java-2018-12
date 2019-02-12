// Stateless 서버 만들기
package ch23.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class CalculatorServer {
  public static void main(String[] args) {
    
    // 클라이언트의 저장 결과를 각각 저장하기 위한 맵 객체
    HashMap<Long,Integer> resultMap = new HashMap<>();

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행 중...");
      
      // 서버의 Stateless 통신 방법
      // => 클라이언트 요청이 들어오면 작업을 수행하고 응답을 한다.
      //    응답한 후에 즉시 연결을 끊는다.
      while (true) {
        try (Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream());) {
          
          System.out.println("클라이언트와 연결됨! 요청처리 중...");
          
          // 클라이언트로 부터 세션ID를 받는다.
          long sessionId = Long.parseLong(in.readLine());
          System.out.printf("세션ID: %d\n", sessionId);
          
          // 처음 결과 값은 0으로 초기화
          int result = 0;
          // 세션ID를 새로 발급했는지 여부 확인 용도
          boolean isNewSessionId = false;
          
          if (sessionId == 0) {
            // 처음 접속했을 경우 세션ID를 발급해 준다.
            sessionId = System.currentTimeMillis();
            // 새로 발급했기 때문에 true로 바꾼다.
            isNewSessionId = true;
            
          } else {
            result = resultMap.get(sessionId);
            // result는 int 값, resultMap에서 꺼낸 값은 Integer 클래스이므로 오토 언박싱 된다.
          }
          
          
          String[] input = in.readLine().split(" ");

          int b = 0;
          String op = null;
          
          try {
            op = input[0];
            b = Integer.parseInt(input[1]);
            
          } catch (Exception e) {
            out.println("식의 형식이 바르지 않습니다.");
            out.flush();
            continue;
          }
          
          switch (op) {
            case "+": result += b; break;
            case "-": result -= b; break;
            case "*": result *= b; break;
            case "/": result /= b; break;
            case "%": result %= b; break;
            default:
              out.printf("%s 연산자를 지원하지 않습니다.\n", op);
              out.flush();
              continue;
          }
          
          // 계산 결과를 서버에 저장한다.
          resultMap.put(sessionId, result);
          
          // 세션ID를 새로 발급한 경우에만 클라이언트에 보내준다.
          if (isNewSessionId) {
            out.println(sessionId);
          }
          
          out.printf("결과는 %d 입니다.\n", result);
          out.flush();
        } catch (Exception e) {
          // 클라이언트 요청을 처리하다가 예외가 발생하면 무시하고 연결을 끊는다.
          System.out.println("클라이언트와 통신 중 오류 발생!");
        }
        System.out.println("클라이언트와 연결 끊음!");
      } // while

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
