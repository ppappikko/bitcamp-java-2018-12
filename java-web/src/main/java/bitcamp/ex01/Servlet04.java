// 서블릿 만들기 - @WebServlet 애노테이션
package bitcamp.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet 애노테이션
// => web.xml 에 서블릿 정보를 설정하는 대신에
//    이 애노테이션을 사용하여 서블릿을 설정할 수 있다.
// => 이 애노테이션을 활성화시키려면
//    web.xml의 <web-app> 태그에 다음 속성을 추가해야 한다.
//      metadata-complete="false"
//    속성의 값을 false 여야 한다.
//
@WebServlet("/ex01/s04")
public class Servlet04 extends HttpServlet {
  
  // GenericServlet 추상 클래스가 java.io.Serialize 인터페이스를 구현하였고,
  // HttpServlet 클래스가 GenericServlet 추상 클래스를 상속 받았으니
  // HttpServlet 클래스를 상속 받는 이 클래스도 마찬가지로
  // serialVersionUID 변수 값을 설정해야 한다.
  private static final long serialVersionUID = 1L;
  
  // service()를 오버라이딩 하는 대신에
  // doGet(), doPost(), doHead() 등을 오버라이딩 하라.
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
    System.out.println("Servlet04.doGet(HttpServletRequest,HttpServletResponse)");
  }
}
