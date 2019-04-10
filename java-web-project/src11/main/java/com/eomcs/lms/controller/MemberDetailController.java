package com.eomcs.lms.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@Controller
public class MemberDetailController {
  
  // 의존객체는 생성자에서 받는 것을 권고한다.
  @Autowired MemberService memberService;

  @RequestMapping("/member/detail")
  public String execute(
      HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    
    int no = Integer.parseInt(request.getParameter("no"));
    Member member = memberService.get(no);
    request.setAttribute("member", member);
    
    // 뷰 컴포넌트의 URL을 이 메서드를 호출한 프론트 컨트롤러에게 리턴한다.
    return "/member/detail.jsp";
  }
}
