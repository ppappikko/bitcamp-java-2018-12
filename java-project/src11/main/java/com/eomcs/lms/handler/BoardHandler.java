package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.App;
import com.eomcs.lms.domain.Board;

public class BoardHandler {

  final int LENGTH = 2;
  Board[] boards = new Board[App.LENGTH];
  int boardIdx = 0;
  public Scanner keyboard;

  public void addBoard() {

    if (boardIdx == App.LENGTH) {
      System.out.println("더 이상 추가할 수 없습니다..!");
    } else {


      Board board = new Board();

      System.out.print("번호? ");
      board.no = Integer.parseInt(keyboard.nextLine());

      System.out.print("내용? ");
      board.contents = keyboard.nextLine();

      board.createdDate = new Date(System.currentTimeMillis()); 

      board.viewCount = 0;

      boards[boardIdx] = board;
      boardIdx++;      

      System.out.print("\n저장하였습니다!");
    }

  }

  public void listBoard() {
    for (int j = 0; j < boardIdx; j++) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          boards[j].no, boards[j].contents, boards[j].createdDate, boards[j].viewCount);
    }
  }

}
