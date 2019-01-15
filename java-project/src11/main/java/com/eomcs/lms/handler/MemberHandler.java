package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.App;
import com.eomcs.lms.domain.Member;

public class MemberHandler {

  final int LENGTH = 2;
  Member[] members = new Member[App.LENGTH];
  int memberIdx = 0;
  public Scanner keyboard;

  public void addMember() {

    if (memberIdx == App.LENGTH) {
      System.out.println("더 이상 추가할 수 없습니다..!");
    } else {


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

      members[memberIdx] = member;
      memberIdx++;

      System.out.print("\n저장하였습니다!");
    }
  }


  public void listMember() {
    // member 출력 부분
    for (int j = 0; j < memberIdx; j++) {
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
          members[j].no, members[j].name, members[j].email, 
          members[j].tel, members[j].registeredDate);
    }
  }

}
