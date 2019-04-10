package com.eomcs.lms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.service.LessonService;

@Controller("/lesson/delete")
public class LessonDeleteController implements PageController {
  
  // 의존객체는 생성자에서 받는 것을 권고한다.
  @Autowired LessonService lessonService;

  @Override
  public String execute(
      HttpServletRequest request,
      HttpServletResponse response) throws Exception {
  
    int no = Integer.parseInt(request.getParameter("no"));
    
    if (lessonService.delete(no) == 0) {
      throw new Exception("해당 번호의 수업이 없습니다.");
    }
    
    return "redirect:list";
  }
}
