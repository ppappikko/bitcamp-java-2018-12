package com.eomcs.lms.controller;
import java.util.List;
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
public class MemberController {
  
  // 의존객체는 생성자에서 받는 것을 권고한다.
  @Autowired MemberService memberService;

  @RequestMapping("/member/add")
  public String add(
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
  
  @RequestMapping("/member/delete")
  public String delete(
      HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));
    
    if (memberService.delete(no) == 0) {
      throw new Exception("해당 번호의 회원이 없습니다.");
    }
    
    return "redirect:list";
  }
  
  @RequestMapping("/member/detail")
  public String detail(
      HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    
    int no = Integer.parseInt(request.getParameter("no"));
    Member member = memberService.get(no);
    request.setAttribute("member", member);
    
    // 뷰 컴포넌트의 URL을 이 메서드를 호출한 프론트 컨트롤러에게 리턴한다.
    return "/member/detail.jsp";
  }
  
  @RequestMapping("/member/list")
  public String list(
      HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    
    List<Member> members = memberService.list(null);
    request.setAttribute("list", members);
    
    // 뷰 컴포넌트의 URL을 이 메서드를 호출한 프론트 컨트롤러에게 리턴한다.
    return "/member/list.jsp";
  }
  
  @RequestMapping("/member/search")
  public String search(
      HttpServletRequest request,
      HttpServletResponse response) throws Exception {
  
    String keyword = request.getParameter("keyword");
    List<Member> members = memberService.list(keyword);
    request.setAttribute("list", members);
    
    // 뷰 컴포넌트의 URL을 이 메서드를 호출한 프론트 컨트롤러에게 리턴한다.
    return "/member/search.jsp";
  }
  
  @RequestMapping("/member/update")
  public String update(
      HttpServletRequest request,
      HttpServletResponse response) throws Exception {
  
    Member member = new Member();
    member.setNo(Integer.parseInt(request.getParameter("no")));
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
    
    if (memberService.update(member) == 0) {
      throw new Exception("해당 번호의 회원이 없습니다.");
    }
    
    return "redirect:list";
  }
}
