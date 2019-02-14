package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import com.eomcs.lms.agent.MemberAgent;

public class MemberDeleteCommand implements Command {
  
  Scanner keyboard;
  
  public MemberDeleteCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    
    try {
      MemberAgent.delete(in, out, no);
      System.out.println("회원을 삭제했습니다.");
      
    } catch (Exception e) {
      
    }
    
  }
  
}
