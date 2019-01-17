package com.eomcs.lms.handler;

import java.util.Arrays;
import com.eomcs.lms.domain.Board;

public class BoardList {
  
  private int LENGTH = 10;
  private Board[] boardList = new Board[LENGTH];
  private int boardIdx = 0;
  
  public BoardList() {
    
  }
  
  public BoardList(int LENGTH) {
    this.LENGTH = LENGTH;
  }
  
  public Board[] toArray() {
    // 전체 배열의 크기 100이라면,
    // 현재 들어있는 항목만 따로 배열을 만들어 리턴한다
    Board[] boards = new Board[boardIdx];
    for (int i = 0; i < boardIdx; i++) {
      boards[i] = boardList[i];
    }
    return boards;
  }
  
  public void add(Board board) {
    if (boardIdx == boardList.length) {
      
      boardList = Arrays.copyOf(boardList, boardList.length + (boardList.length >> 1));
      
      /*
      Board[] a = new Board[boardList.length + (boardList.length >> 1)];
      for (int i = 0; i < boardList.length; i++) {
        a[i] = boardList[i];
      }
      boardList = a;
      */
    }
    boardList[boardIdx] = board;
    boardIdx++;
  }
}
