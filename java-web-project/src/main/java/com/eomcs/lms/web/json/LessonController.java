package com.eomcs.lms.web.json;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

@RestController("json/LessonController")
@RequestMapping("/json/lesson")
public class LessonController {
  
  @Autowired LessonService lessonService;

  @PostMapping("add")
  public String add(Lesson lesson) {
    lessonService.add(lesson);
    return "redirect:.";
  }
  
  @GetMapping("delete/{no}")
  public String delete(@PathVariable int no) throws Exception {
    if (lessonService.delete(no) == 0) 
      throw new Exception("해당 번호의 수업이 없습니다.");
    return "redirect:../";
  }
  
  @GetMapping("{no}")
  public String detail(@PathVariable int no, Model model) {
    Lesson lesson = lessonService.get(no);
    model.addAttribute("lesson", lesson);
    return "lesson/detail";
  }

  @GetMapping
  public Object list() {
    List<Lesson> lessons = lessonService.list();
    HashMap<String,Object> content = new HashMap<>();
    content.put("list", lessons);
    
    return content;
  }
  
  @PostMapping("update")
  public String update(Lesson lesson) throws Exception {
    if (lessonService.update(lesson) == 0)
      throw new Exception("해당 번호의 수업이 없습니다.");
    return "redirect:.";
  }
}
