package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class MemberUpdateCommand implements Command {
  
  Scanner keyboard;
  
  public MemberUpdateCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    
    try {
      out.writeUTF("/member/update");
      out.flush();
      if (!in.readUTF().equals("OK")) {
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");
      }
      
      out.writeInt(no);
      out.flush();
      
      Member member = (Member) in.readObject();
      
      try {
        // 기존 값 복제
        Member temp = member.clone();
        
        System.out.printf("이름(%s)? ", member.getName());
        String input = keyboard.nextLine();
        if (input.length() > 0) 
          temp.setName(input);
        
        System.out.printf("이메일(%s)? ", member.getEmail());
        if ((input = keyboard.nextLine()).length() > 0)
          temp.setEmail(input);
        
        System.out.printf("암호(********)? ");
        if ((input = keyboard.nextLine()).length() > 0)
          temp.setPassword(input);
        
        System.out.printf("사진(%s)? ", member.getPhoto());
        if ((input = keyboard.nextLine()).length() > 0)
          temp.setPhoto(input);
        
        System.out.printf("전화(%s)? ", member.getTel());
        if ((input = keyboard.nextLine()).length() > 0)
          temp.setTel(input);
        
        temp.setRegisteredDate(member.getRegisteredDate());
        
        out.writeObject(temp);
        out.flush();
        
      } catch (Exception e) {
        System.out.println("변경 중 오류 발생!");
      }
      
      String status = in.readUTF();
      
      if (!status.equals("OK")) {
        throw new Exception("서버에서 회원 정보 가져오기 실패!");
      }
      
      System.out.println("회원을 변경했습니다.");
      
    } catch (Exception e) {
      System.out.printf("회원 정보 업데이트 오류! : %s\n", e.getMessage());
    }
    
  }
  
}
