package com.eomcs.lms.handler;
import java.sql.Date;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateCommand extends AbstractCommand {

  SqlSessionFactory sqlSessionFactory;

  public LessonUpdateCommand(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }


  @Override
  public void execute(Response response) throws Exception {

    // SqlSession 객체를 준비한다.
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      // SqlSession으로부터 LessonDao 구현체를 얻는다.
      // => getMapper(DAO 인터페이스 정보)
      LessonDao lessonDao = sqlSession.getMapper(LessonDao.class);

      int no = response.requestInt("번호?");

      Lesson lesson = lessonDao.findByNo(no);
      if (lesson == null) {
        response.println("해당 번호의 수업이 없습니다.");
        return;
      }

      // 변경할 값만 temp에 
      Lesson temp = new Lesson();
      temp.setNo(no);

      // mybatis는 필드의 값이 null이 아니거나 숫자인 경우 0이 아니면 헤당 컬럼 값을 update 한다.
      String input = response.requestString(String.format(
          "수업명(%s)?", lesson.getTitle()));
      if (input.length() > 0) 
        temp.setTitle(input);

      input = response.requestString(String.format(
          "설명(%s)?", lesson.getContents()));
      if (input.length() > 0)
        temp.setContents(input);

      input = response.requestString(String.format(
          "시작일(%s)?", lesson.getStartDate()));
      if (input.length() > 0)
        temp.setStartDate(Date.valueOf(input));

      input = response.requestString(String.format(
          "종료일(%s)?", lesson.getEndDate()));
      if (input.length() > 0)
        temp.setEndDate(Date.valueOf(input));

      input = response.requestString(String.format(
          "총수업시간(%d)?", lesson.getTotalHours()));
      if (input.length() > 0)
        temp.setTotalHours(Integer.parseInt(input));

      input = response.requestString(String.format(
          "일수업시간(%d)?", lesson.getDayHours()));
      if (input.length() > 0)
        temp.setDayHours(Integer.parseInt(input));

      if (temp.getTitle() != null
          || temp.getContents() != null
          || temp.getStartDate() != null
          || temp.getEndDate() != null
          || temp.getTotalHours() > 0
          || temp.getDayHours() > 0) {

        lessonDao.update(temp);
        sqlSession.commit();
        response.println("변경했습니다.");
      } else {
        response.println("변경 취소했습니다.");
      }
    }

  }
}
