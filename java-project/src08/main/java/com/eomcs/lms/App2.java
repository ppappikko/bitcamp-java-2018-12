package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);
    final int LENGTH = 10;
    int size = 0;
    Member[] members = new Member[LENGTH];

    while (true) {
      System.out.println("명령> ");
      String command = keyboard.nextLine();

      if (command.equals("/member/add")) {

        while (size < LENGTH) {
          Member member = new Member();

          System.out.print("번호? ");
          member.no = Integer.parseInt(keyboard.nextLine());

          System.out.print("이름? ");
          member.name = keyboard.nextLine();

          System.out.print("이메일? ");
          member.email = keyboard.nextLine();

          System.out.print("암호? ");
          member.password = keyboard.nextLine();

          System.out.print("사진? ");
          member.photo = keyboard.nextLine();

          System.out.print("전화? ");
          member.tel = keyboard.nextLine();

          member.registeredDate = new Date(System.currentTimeMillis()); 

          members[size] = member;
          size++;

          System.out.print("\n계속 입력하시겠습니까?(Y/n) ");
          String answer = keyboard.nextLine().toLowerCase();

          if (!answer.equals("y") && answer.length() > 0) {
            break;
          }
          System.out.println();
        }
      } else if (command.equals("/member/list")) {
        for (int i = 0; i < size; i++) {
          System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
              members[i].no, members[i].name, members[i].email, 
              members[i].tel, members[i].registeredDate);
        }
      }
    } // while
    
    System.out.println("안녕!");
    keyboard.close();
  }
}
