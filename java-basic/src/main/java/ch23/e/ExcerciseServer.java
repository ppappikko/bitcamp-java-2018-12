package ch23.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ExcerciseServer {

  public static void main(String[] args) {
    
    HashMap<Long,Integer> resultMap = new HashMap<>();
    
    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행 중...");

      while (true) {
        try (Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream())) {
          System.out.println("클라이언트와 연결됨! 요청처리 중...");
          
          long sessionId = Long.parseLong(in.readLine());
          System.out.printf("세션ID: %d\n", sessionId);
          
          int result = 0;
          boolean isNewSessionId = false;
          
          if (sessionId == 0) {
            sessionId = System.currentTimeMillis();
            isNewSessionId = true;
          } else {
            result = resultMap.get(sessionId);
          }
          
          String[] request = in.readLine().split(" ");

          int b = 0;
          String op = null;

          try {
            op = request[0];
            b = Integer.parseInt(request[1]);
            
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
          
          resultMap.put(sessionId, result);
          
          if (isNewSessionId) {
            out.println(sessionId);
          }
          
          out.printf("현재까지 결과는 %d 입니다.\n", result);
          out.flush();
          
          
          
          

        } catch (Exception e) {
          System.out.println("클라이언트와 통신 중 오류 발생!");
          e.printStackTrace();
        }
        System.out.println("클라이언트와 연결 끊음!");
      } // while


    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
