package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {
  
  Scanner keyboard;
  ArrayList<Board> list;
  
  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    this.list = new ArrayList<>(20);
  }
  
  public void listBoard() {
    Board[] boards = list.toArray(new Board[] {});
    for (Board board : boards) {
      System.out.printf("%3d, %-20s, %s, %d\n", 
          board.getNo(), board.getContents(), 
          board.getCreatedDate(), board.getViewCount());
    }
  }

  public void addBoard() {
    Board board = new Board();
    
    System.out.print("번호? ");
    board.setNo(Integer.parseInt(keyboard.nextLine()));
    
    System.out.print("내용? ");
    board.setContents(keyboard.nextLine());
    
    board.setCreatedDate(new Date(System.currentTimeMillis())); 
    
    board.setViewCount(0);
    
    list.add(board);
    
    System.out.println("저장하였습니다.");
  }

  public void detailBoard() {
    int no = promptBoardNo();
    int index = indexOfBoard(no);
    
    if (!validate(index)) {
      return;
    }
    
    Board board = list.get(index);
    
    System.out.printf("내용: %s\n", board.getContents());
    System.out.printf("작성일: %s\n", board.getCreatedDate());
    
  }

  public void updateBoard() {
    int no = promptBoardNo();
    int index = indexOfBoard(no);
    
    if (!validate(index)) {
      return;
    }
    
    Board board = list.get(index);
    Board temp = new Board();
    
    temp.setNo(board.getNo());
    temp.setCreatedDate(board.getCreatedDate());
    temp.setViewCount(board.getViewCount());
    
    System.out.printf("내용? ", board.getContents());
    String input = keyboard.nextLine();
    
    if (input.length() > 0) {
      temp.setContents(input);
    } else {
      temp.setContents(board.getContents());
    }
    
    list.set(index, temp);
    System.out.println("게시글을 변경했습니다.");
  }

  public void deleteBoard() {
    int no = promptBoardNo();
    int index = indexOfBoard(no);
    
    if (!validate(index)) {
      return;
    }
    
    list.remove(index);
    System.out.println("게시글을 삭제했습니다.");
    
  }

  private int promptBoardNo() {
    System.out.print("번호? ");
    return Integer.parseInt(keyboard.nextLine());
  }

  private int indexOfBoard(int no) {
    int index = -1;
    for (int i = 0; i < list.size(); i++) {
      Board item = list.get(i);
      if (item.getNo() == no) {
        index = i;
        break;
      }
    }
    return index;
  }
  
  private boolean validate(int index) {
    if (index == -1) {
      System.out.println("해당 게시글을 찾을 수 없습니다...");
      return false;
    }
    return true;
  }

}
