package com.eomcs.lms.handler;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberSearchCommand extends AbstractCommand {

  SqlSessionFactory sqlSessionFactory;

  public MemberSearchCommand(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void execute(Response response) throws Exception {

    // SqlSession 객체를 준비한다.
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      // SqlSession으로부터 MemberDao 구현체를 얻는다.
      // => getMapper(DAO 인터페이스 정보)
      MemberDao memberDao = sqlSession.getMapper(MemberDao.class);

      String keyword = response.requestString("검색어?");
      List<Member> members = memberDao.findByKeyword(keyword);

      for (Member member : members) {
        response.println(String.format("%3d, %-4s, %-20s, %-15s, %s", 
            member.getNo(), member.getName(), 
            member.getEmail(), member.getTel(), member.getRegisteredDate()));
      }
    }
  }
}
