package com.eomcs.lms.handler;
import java.io.BufferedReader;
import java.io.PrintWriter;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardUpdateCommand implements Command {

  BoardDao boardDao;

  public BoardUpdateCommand(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void execute(BufferedReader in, PrintWriter out) {
    
    try {
      out.println("번호? ");
      out.println("!{}!");
      out.flush();

      int no = Integer.parseInt(in.readLine());

      Board board = boardDao.findByNo(no);
      if (board == null) {
        out.println("해당 번호의 게시물이 없습니다.");
        return;
      }

      out.println("내용? ");
      out.println("!{}!");
      out.flush();

      board.setContents(in.readLine());

      boardDao.update(board);

      out.println("게시글을 변경했습니다.");

    } catch (Exception e) {
      out.println("변경 중 오류 발생!");
    }
  }

}
