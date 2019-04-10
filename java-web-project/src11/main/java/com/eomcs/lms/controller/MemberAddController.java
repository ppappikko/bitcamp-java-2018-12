package com.eomcs.lms.controller;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@Controller
public class MemberAddController {
  
  // 의존객체는 생성자에서 받는 것을 권고한다.
  @Autowired MemberService memberService;

  @RequestMapping("/member/add")
  public String execute(
      HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    
    if (request.getMethod().equals("GET")) {
      return "/member/form.jsp";
    }
    
    Member member = new Member();
    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setPassword(request.getParameter("password"));
    member.setTel(request.getParameter("tel"));

    Part photo = request.getPart("photo");
    if (photo.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      String uploadDir = request.getServletContext().getRealPath("/upload/member");
      photo.write(uploadDir + "/" + filename);
      member.setPhoto(filename);
    }
    
    memberService.add(member);
    
    // 뷰 컴포넌트의 URL을 ServletRequest 보관소에 저장한다.
    return "redirect:list";
  }
  
}
