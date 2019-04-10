package com.eomcs.lms.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.service.PhotoBoardService;

@Controller("/photoboard/list")
public class PhotoBoardListController implements PageController {
  
  // 의존객체는 생성자에서 받는 것을 권고한다.
  @Autowired PhotoBoardService photoBoardService;

  @Override
  public String execute(
      HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    
    List<PhotoBoard> boards = photoBoardService.list(0, null);
    request.setAttribute("list", boards);
    
    // 뷰 컴포넌트의 URL을 이 메서드를 호출한 프론트 컨트롤러에게 리턴한다.
    return "/photoboard/list.jsp";
  }

}
