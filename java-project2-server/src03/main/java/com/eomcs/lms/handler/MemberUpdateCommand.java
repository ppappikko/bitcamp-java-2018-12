package com.eomcs.lms.handler;
import java.io.BufferedReader;
import java.io.PrintWriter;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberUpdateCommand implements Command {

  MemberDao memberDao;

  public MemberUpdateCommand(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void execute(BufferedReader in, PrintWriter out) {

    try {
      out.println("번호? ");
      out.println("!{}!");
      out.flush();

      int no = Integer.parseInt(in.readLine());

      Member member = memberDao.findByNo(no);
      if (member == null) {
        out.println("해당 번호의 회원이 없습니다.");
        return;
      }

      // 기존 값 복제
      Member temp = member.clone();

      out.printf("이름(%s)?\n", member.getName());
      out.println("!{}!");
      out.flush();
      String input = in.readLine();
      if (input.length() > 0) 
        temp.setName(input);

      out.printf("이메일(%s)?\n", member.getEmail());
      out.println("!{}!");
      out.flush();
      if ((input = in.readLine()).length() > 0)
        temp.setEmail(input);

      out.printf("암호(새 암호를 넣으세요!!)?\n");
      out.println("!{}!");
      out.flush();
      temp.setPassword(in.readLine());

      out.printf("사진(%s)?\n", member.getPhoto());
      out.println("!{}!");
      out.flush();
      if ((input = in.readLine()).length() > 0)
        temp.setPhoto(input);

      out.printf("전화(%s)?\n", member.getTel());
      out.println("!{}!");
      out.flush();
      if ((input = in.readLine()).length() > 0)
        temp.setTel(input);

      temp.setRegisteredDate(member.getRegisteredDate());

      memberDao.update(temp);
      out.println("회원 정보를 변경했습니다.");

    } catch (Exception e) {
      out.println("변경 중 오류 발생!");
    }

  }

}
