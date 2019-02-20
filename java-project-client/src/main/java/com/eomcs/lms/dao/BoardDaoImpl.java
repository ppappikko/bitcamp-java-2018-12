package com.eomcs.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.domain.Board;

// 서버쪽에 있는 BoardDaoImpl 객체를 대행할 클라이언트측 대행자 클래스 정의 
//
public class BoardDaoImpl implements BoardDao {

  public List<Board> findAll() {

    List<Board> list = new ArrayList<>();

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try (Statement stmt = con.createStatement()) {

        try (ResultSet rs = stmt.executeQuery(
            "select * from p_board order by board_id desc")) {

          while (rs.next()) {
            Board board = new Board();
            
            board.setNo(rs.getInt("board_id"));
            board.setContents(rs.getString("contents"));
            board.setCreatedDate(rs.getDate("created_date"));
            board.setViewCount(rs.getInt("view_count"));

            list.add(board);
          }
        }
      }
      return list;

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void insert(Board board) {

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try (Statement stmt = con.createStatement()) {

        stmt.executeUpdate("insert into p_board(contents)"
            + " values('" + board.getContents() + "')");

      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public Board findByNo(int no) {

    Board board = new Board();

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {

      try (Statement stmt = con.createStatement()) {

        try (ResultSet rs = stmt.executeQuery(
            "select * from p_board where board_id = " + no)) {

          if (rs.next()) {

            board.setContents(rs.getString("contents"));
            board.setCreatedDate(rs.getDate("created_date"));
            board.setViewCount(rs.getInt("view_count") + 1);

          } else {
            System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
          }
        }
      }
      return board;

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public int update(Board board) {
    
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
      
      try (PreparedStatement stmt = con.prepareStatement(
          "update p_board set contents = ? where board_id = ?")) {
        
        stmt.setString(1, board.getContents());
        stmt.setInt(2, board.getNo());
        
        // PreparedStatement에서는 SQL 문을 서버에 보낼 때 파라미터로 전달하지 않는다.
        int count = stmt.executeUpdate();
        
        if (count == 0) {
          return 0;
          
        } else {
          return 1;
        }
      }
      
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public int delete(int no) {
    
    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
      
      try (Statement stmt = con.createStatement()) {
        
        // delete 문장은 executeUpdate()를 사용하여 서버에 전달한다.
        int count = stmt.executeUpdate(
            "delete from p_board where board_id = " + no);
        
        if (count == 0) {
          return 0;
        } else {
          return 1;
        }
      }
      
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}









