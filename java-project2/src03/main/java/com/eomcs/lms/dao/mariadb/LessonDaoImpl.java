// DBMS 적용
package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

// 서버쪽에 있는 LessonDaoImpl 객체를 대행할 클라이언트측 대행자 클래스 정의 
//
public class LessonDaoImpl implements LessonDao {

  // DAO가 사용하는 커넥션 객체를 외부에서 주입 받는다.
  Connection con;

  public LessonDaoImpl(Connection con) {
    this.con = con;
  }

  public List<Lesson> findAll() {

    try (PreparedStatement stmt = con.prepareStatement(
        "select lesson_id, sdt, edt, tot_hr, day_hr, titl, conts from lms_lesson"
            + " order by lesson_id desc")) {

      try (ResultSet rs = stmt.executeQuery()) {

        ArrayList<Lesson> list = new ArrayList<>();
        while (rs.next()) {
          Lesson lesson = new Lesson();
          lesson.setNo(rs.getInt("lesson_id"));
          lesson.setStartDate(rs.getDate("sdt"));
          lesson.setEndDate(rs.getDate("edt"));
          lesson.setTotalHours(rs.getInt("tot_hr"));
          lesson.setDayHours(rs.getInt("day_hr"));
          lesson.setTitle(rs.getString("titl"));
          lesson.setContents(rs.getString("conts"));

          list.add(lesson);
        }
        return list;
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void insert(Lesson lesson) {

    try (PreparedStatement stmt = con.prepareStatement(
        "insert into lms_lesson(titl, conts, sdt, edt, tot_hr, day_hr)"
            + " values(?, ?, ?, ?, ?, ?)")) {

      stmt.setString(1, lesson.getTitle());
      stmt.setString(2, lesson.getContents());
      stmt.setDate(3, lesson.getStartDate());
      stmt.setDate(4, lesson.getEndDate());
      stmt.setInt(5, lesson.getTotalHours());
      stmt.setInt(6, lesson.getDayHours());
      stmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public Lesson findByNo(int no) {

    try (PreparedStatement stmt = con.prepareStatement(
        "select lesson_id, sdt, edt, tot_hr, day_hr, titl, conts from lms_lesson"
            + " where lesson_id = ?")) {

      stmt.setInt(1, no);

      try (ResultSet rs = stmt.executeQuery()) {

        if (rs.next()) {
          Lesson lesson = new Lesson();

          lesson.setNo(rs.getInt("lesson_id"));
          lesson.setStartDate(rs.getDate("sdt"));
          lesson.setEndDate(rs.getDate("edt"));
          lesson.setTotalHours(rs.getInt("tot_hr"));
          lesson.setDayHours(rs.getInt("day_hr"));
          lesson.setTitle(rs.getString("titl"));
          lesson.setContents(rs.getString("conts"));

          return lesson;

        } else {
          return null;
        }
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public int update(Lesson lesson) {

    try (PreparedStatement stmt = con.prepareStatement(
        "update lms_lesson set titl = ?, conts = ?, sdt = ?, edt = ?, tot_hr = ?, day_hr = ?"
            + " where lesson_id = ?")) {

      stmt.setString(1, lesson.getTitle());
      stmt.setString(2, lesson.getContents());
      stmt.setDate(3, lesson.getStartDate());
      stmt.setDate(4, lesson.getEndDate());
      stmt.setInt(5, lesson.getTotalHours());
      stmt.setInt(6, lesson.getDayHours());
      stmt.setInt(7, lesson.getNo());

      return stmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public int delete(int no) {

    try (PreparedStatement stmt = con.prepareStatement(
        "delete from lms_lesson where lesson_id = ?")) {

      stmt.setInt(1, no);

      return stmt.executeUpdate();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}









