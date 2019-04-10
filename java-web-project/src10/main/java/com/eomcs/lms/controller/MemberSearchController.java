package com.eomcs.lms.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@Controller("/member/search")
public class MemberSearchController implements PageController {
  
  // 의존객체는 생성자에서 받는 것을 권고한다.
  @Autowired MemberService memberService;

  @Override
  public String execute(
      HttpServletRequest request,
      HttpServletResponse response) throws Exception {
  
    String keyword = request.getParameter("keyword");
    List<Member> members = memberService.list(keyword);
    request.setAttribute("list", members);
    
    // 뷰 컴포넌트의 URL을 이 메서드를 호출한 프론트 컨트롤러에게 리턴한다.
    return "/member/search.jsp";
  }
  
}
