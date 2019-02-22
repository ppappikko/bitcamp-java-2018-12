package com.eomcs.lms.handler;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardUpdateCommand extends AbstractCommand {

  BoardDao boardDao;

  public BoardUpdateCommand(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void execute(Response response) throws Exception {

    int no = response.requestInt("번호?");

    Board board = boardDao.findByNo(no);
    if (board == null) {
      response.println("해당 번호의 게시물이 없습니다.");
      return;
    }

    board.setContents(response.requestString("내용?"));

    boardDao.update(board);

    response.println("게시글을 변경했습니다.");
  }

}
