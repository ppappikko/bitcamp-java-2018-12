package com.eomcs.lms.controller;

import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@Controller
public class LessonAddController {
  
  // 의존객체는 생성자에서 받는 것을 권고한다.
  @Autowired LessonService lessonService;

  @RequestMapping("/lesson/add")
  public String execute(
      HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    
    if (request.getMethod().equals("GET")) {
      return "/lesson/form.jsp";
    }
    
    Lesson lesson = new Lesson();
    lesson.setTitle(request.getParameter("title"));
    lesson.setContents(request.getParameter("contents"));
    lesson.setStartDate(Date.valueOf(request.getParameter("startDate")));
    lesson.setEndDate(Date.valueOf(request.getParameter("endDate")));
    lesson.setTotalHours(Integer.parseInt(request.getParameter("totalHours")));
    lesson.setDayHours(Integer.parseInt(request.getParameter("dayHours")));
    
    lessonService.add(lesson);
    
    return "redirect:list";
  }
  
}
