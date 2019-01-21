package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.ArrayList;

public class MemberHandler {
  
  Scanner keyboard;
  ArrayList<Member> arrayList;
  
  public MemberHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    arrayList = new ArrayList<>();
  }
  
  public void listMember() {
    Member[] members = arrayList.toArray(new Member[] {});
    for (Member member : members) {
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
          member.getNo(), member.getName(), member.getEmail(), 
          member.getTel(), member.getRegisteredDate());
    }
  }

  public void addMember() {
    Member member = new Member();
    
    System.out.print("번호? ");
    member.setNo(Integer.parseInt(keyboard.nextLine()));
    
    System.out.print("이름? ");
    member.setName(keyboard.nextLine());
    
    System.out.print("이메일? ");
    member.setEmail(keyboard.nextLine());
    
    System.out.print("암호? ");
    member.setPassword(keyboard.nextLine());
  
    System.out.print("사진? ");
    member.setPhoto(keyboard.nextLine());
  
    System.out.print("전화? ");
    member.setTel(keyboard.nextLine());
  
    member.setRegisteredDate(new Date(System.currentTimeMillis())); 
    
    arrayList.add(member);
    
    System.out.println("저장하였습니다.");
  }
  
  public void detailMember() {
    int no = promptMemberNo();
    int index = indexOf(no);
    
    if (!validate(index)) {
      return;
    }
    
    Member member = arrayList.get(index);
    
    System.out.printf("이름: %s\n", member.getName());
    System.out.printf("이메일: %s\n", member.getEmail());
    System.out.printf("암호: %s\n", member.getPassword());
    System.out.printf("사진: %s\n", member.getPhoto());
    System.out.printf("전화: %s\n", member.getTel());
    System.out.printf("가입일: %s\n", member.getRegisteredDate());
    
  }
  
  public void updateMember() {
    int no = promptMemberNo();
    
    int index = indexOf(no);
    
    if (!validate(index)) {
      return;
    }
    
    Member member = arrayList.get(index);
    Member temp = new Member();
    
    temp.setNo(member.getNo());
    temp.setRegisteredDate(member.getRegisteredDate());
    
    System.out.printf("이름(%s)? ", member.getName());
    String input = keyboard.nextLine();
    if (input.length() > 0) {
      temp.setName(input);
    } else {
      temp.setName(member.getName());
    }
    
    System.out.printf("이메일(%s)? ", member.getEmail());
    input = keyboard.nextLine();
    temp.setEmail(input.length() > 0? input : member.getEmail());
    
    System.out.printf("암호(%s)? ", member.getPassword());
    input = keyboard.nextLine();
    temp.setPassword(input.length() > 0? input : member.getPassword());
    
    System.out.printf("사진(%s)? ", member.getPhoto());
    input = keyboard.nextLine();
    temp.setPhoto(input.length() > 0? input : member.getPhoto());
    
    System.out.printf("전화(%s)? ", member.getTel());
    input = keyboard.nextLine();
    temp.setTel(input.length() > 0? input : member.getTel());
    
    arrayList.set(index, temp);
    
    System.out.println("회원을 변경했습니다.");
    
  }
  
  public void deleteMember() {
    int no = promptMemberNo();
    int index = indexOf(no);
    
    if (!validate(index)) {
      return;
    }
    
    arrayList.remove(index);
    
    System.out.println("회원을 삭제했습니다.");
    
  }
  
  private boolean validate(int index) {
    if (index == -1) {
      System.out.println("해당 회원을 찾을 수 없습니다.");
      return false;
    }
    return true;
  }
  
  private int promptMemberNo() {
    System.out.print("번호? ");
    return Integer.parseInt(keyboard.nextLine());
  }
  
  private int indexOf(int no) {
    int index = -1;
    for (int i = 0; i < arrayList.size(); i++) {
      Member item = arrayList.get(i);
      if (item.getNo() == no) {
        index = i;
        break;
      }
    }
    return index;
  }

}
