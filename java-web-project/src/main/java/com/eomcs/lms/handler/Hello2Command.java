package com.eomcs.lms.handler;
import java.io.PrintWriter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.stereotype.Component;
import com.eomcs.lms.context.RequestMapping;

@Component
public class Hello2Command {

  @RequestMapping("/hello2")
  public void list(ServletRequest request, ServletResponse response) throws Exception {
    
    PrintWriter out = response.getWriter();
    out.println("<html><head><title>hello2</title></head>");
    out.println("<body><h1>Hello, world!</h1>");
    out.println("</body></html>");
  }
  
}
