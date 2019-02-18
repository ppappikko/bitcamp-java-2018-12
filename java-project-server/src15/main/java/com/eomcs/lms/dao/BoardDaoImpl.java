// 프록시 패턴 적용 - BoardDao에서 인터페이스를 추출한다.
package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardDaoImpl extends AbstractDao<Board> implements BoardDao {

  public BoardDaoImpl(String filepath) {
    this.filePath = filepath;
  }

  public void insert(Board board) {
    try {
      list.add(board);
      this.saveData();

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public List<Board> findAll() {
    return list;
  }

  public Board findByNo(int no) {
    for (Board b : list) {
      if (b.getNo() == no) {
        return b;
      }
    }
    return null;
  }

  public int update(Board board) {
    try {
      int index = 0;
      for (Board b : list) {
        if (b.getNo() == board.getNo()) {
          list.set(index, board);
          this.saveData();
          return 1;
        }
        index++;
      }
      return 0;

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public int delete(int no) {
    try {
      int index = 0;
      for (Board b : list) {
        if (b.getNo() == no) {
          list.remove(index);
          this.saveData();
          return 1;
        }
        index++;
      }
      return 0;
      
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
