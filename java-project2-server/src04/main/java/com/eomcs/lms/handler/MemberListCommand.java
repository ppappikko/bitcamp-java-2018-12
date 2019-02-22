package com.eomcs.lms.handler;
import java.util.List;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberListCommand extends AbstractCommand {

  MemberDao memberDao;

  public MemberListCommand(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void execute(Response response) {

    List<Member> members = (List<Member>) memberDao.findAll();

    for (Member member : members) {
      response.println(String.format("%3d, %-4s, %-20s, %-15s", 
          member.getNo(), member.getName(), 
          member.getEmail(), member.getTel()));
    }
  }
}
