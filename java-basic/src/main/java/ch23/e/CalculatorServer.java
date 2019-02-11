// Stateless 응용 - 서버에서 계산 결과 유지하기
package ch23.e;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CalculatorServer {
  public static void main(String[] args) {
    
    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행 중...");
      
      HashMap<Integer,String> sessionId = new HashMap<>();
      int id = 0;
      int result = 0;
      sessionId.put(id, Integer.toString(result));
      // 서버의 Stateless 통신 방법에서 클라이언트를 구분하여 각 클라이언트의 계산 결과를 유지하려면?
      // => 커피숍에서는 고객의 쿠폰 포인트를 어떻게 관리할까?
      
      
      while (true) {
        
        try (Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream());) {
          
          System.out.println("클라이언트와 연결됨! 요청처리 중...");
          
          id = Integer.parseInt(in.readLine());
          
          Set<Integer> set = sessionId.keySet();
          Iterator<Integer> iterator = set.iterator();
          
          while (iterator.hasNext()) {
            if (id != (int) iterator.next()) {
              sessionId.put(id, new String());
            } 
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
          
          result = Integer.parseInt(sessionId.get(id));
          
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

          out.printf("현재까지 결과는 %d 입니다.\n", result);
          out.flush();
          
          sessionId.put(id, Integer.toString(result));
          
        } catch (Exception e) {
          // 클라이언트 요청을 처리하다가 예외가 발생하면 무시하고 연결을 끊는다.
          System.out.println("클라이언트와 통신 중 오류 발생!");
        }
        System.out.println("클라이언트와 연결 끊음!");
      } // while
      
    } catch (NullPointerException e) {
      System.out.println("회원 번호를 찾을 수 없습니다!!");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
