package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardUpdateCommand implements Command {

  Scanner keyboard;
  BoardDao boardDao;

  public BoardUpdateCommand(Scanner keyboard, BoardDao boardDao) {
    this.keyboard = keyboard;
    this.boardDao = boardDao;
  }

  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      Board board = boardDao.findByNo(no);
      if (board == null) {
        System.out.println("해당 번호의 게시물이 없습니다.");
        return;
      }

      System.out.printf("내용? ");
      board.setContents(keyboard.nextLine());

      boardDao.update(board);
      
      System.out.println("변경했습니다.");

    } catch (Exception e) {
      System.out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
