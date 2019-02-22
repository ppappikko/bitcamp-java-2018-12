package com.eomcs.lms.handler;
import java.io.BufferedReader;
import java.io.PrintWriter;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardAddCommand implements Command {

  BoardDao boardDao;

  public BoardAddCommand(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void execute(BufferedReader in, PrintWriter out) {
    
    try {
      Board board = new Board();

      out.println("내용? ");
      out.println("!{}!");
      out.flush();
      board.setContents(in.readLine());

      boardDao.insert(board);
      out.println("저장하였습니다.");

    } catch (Exception e) {
      out.printf("게시글 저장 오류! : %s\n", e.getMessage());
    }

  }
}
