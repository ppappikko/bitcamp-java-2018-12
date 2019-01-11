package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.App;
import com.eomcs.lms.domain.Board;

public class BoardHandler {
  
  static Board[] boards = new Board[App.LENGTH];
  static int boardIdx = 0;
  
  public static void addBoard() {
    
    Scanner keyboard = App.keyboard;
    Board board = new Board();
    
    System.out.print("번호? ");
    board.no = Integer.parseInt(keyboard.nextLine());
    
    System.out.print("내용? ");
    board.contents = keyboard.nextLine();
    
    board.createdDate = new Date(System.currentTimeMillis()); 
    
    board.viewCount = 0;
    
    boards[boardIdx] = board;
    boardIdx++;
    
    System.out.println("저장하였습니다.");
  }
  
  public static void listBoard() {
    
    for (int j = 0; j < boardIdx; j++) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          boards[j].no, boards[j].contents, boards[j].createdDate, boards[j].viewCount);
    }
  }

}
