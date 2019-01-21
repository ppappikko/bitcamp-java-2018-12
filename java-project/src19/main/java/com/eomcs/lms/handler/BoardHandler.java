package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.ArrayList;

public class BoardHandler {

  Scanner keyboard;
  ArrayList<Board> arrayList;

  public BoardHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    arrayList = new ArrayList<>();
  }

  public void listBoard() {
    Board[] boards = arrayList.toArray(new Board[] {});
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

    arrayList.add(board);

    System.out.println("저장하였습니다.");
  }


  public void detailBoard() {

    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    for (int i = 0; i < arrayList.size(); i++) {
      Board board = arrayList.get(i);
      if (no == board.getNo()) { // 입력 받은 no값과 저장된 객체들의 no필드값 비교
        
        System.out.printf("내용: %s\n생성 날짜: %s\n조회수: %d\n",
            board.getContents(), board.getCreatedDate(), board.getViewCount());
        return;
      }
    }
    System.out.println("해당 게시판을 찾을 수 없습니다.");
  }

  public void updateBoard() {

    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    for (int i = 0; i < arrayList.size(); i++) {
      Board board = arrayList.get(i);
      if (no == board.getNo()) { // 입력 받은 no값과 저장된 객체들의 no필드값 비교

        System.out.print("내용? ");
        String input = keyboard.nextLine();
        if (!input.equals(board.getContents()) && !input.equals("")) {
          board.setContents(input);
        }

        arrayList.set(i, board);

        System.out.println("게시글을 변경했습니다.");
        return;
      }
    }
    System.out.println("해당 게시판을 찾을 수 없습니다.");
  }

  public void deleteBoard() {

    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    for (int i = 0; i < arrayList.size(); i++) {
      Board board = arrayList.get(i);
      if (board.getNo() == no) {

        arrayList.remove(i);

        System.out.println("게시글을 삭제했습니다.");
        return;
      }
    }
    System.out.println("해당 게시판을 찾을 수 없습니다.");
  }
}
