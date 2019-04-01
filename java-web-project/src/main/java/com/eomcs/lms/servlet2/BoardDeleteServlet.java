package com.eomcs.lms.servlet2;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.lms.InitServlet;
import com.eomcs.lms.service.BoardService;

@WebServlet("/board2/delete")
@SuppressWarnings("serial")
public class BoardDeleteServlet extends HttpServlet {

  @Override
  protected void doGet(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    // Spring IoC 컨테이너에서 BoardService 객체를 꺼낸다.
    BoardService boardService =
        InitServlet.iocContainer.getBean(BoardService.class);
    
    int no = Integer.parseInt(request.getParameter("no"));

    PrintWriter out = response.getWriter();
    
    out.println("<h1>게시물 삭제</h1>");

    if (boardService.delete(no) == 0) {
      out.println("<p>해당 번호의 게시물이 없습니다.</p>");
      return;
    } else {
      out.println("<p>삭제했습니다.</p>");
    }
  }

}
