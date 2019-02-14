package com.eomcs.lms.agent;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Member;

public class MemberAgent {

  // 인스턴스 멤버를 사용하지 않으면 static으로 해준다.
  @SuppressWarnings("unchecked")
  public static List<Member> list(
      ObjectInputStream in, ObjectOutputStream out) throws Exception {
    
    out.writeUTF("/member/list");
    out.flush();
    if (!in.readUTF().equals("OK")) {
      throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");
    }

    String status = in.readUTF();

    if (!status.equals("OK")) {
      throw new Exception("서버에서 게시글 목록 가져오기 실패!");
    }

    return (List<Member>) in.readObject();
  }

  public static void add(
      ObjectInputStream in, ObjectOutputStream out, Member member) throws Exception {
    
    out.writeUTF("/member/add");
    out.flush();
    if (!in.readUTF().equals("OK")) {
      throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");
    }

    out.writeObject(member);
    out.flush();

    String status = in.readUTF();

    if (!status.equals("OK")) {
      throw new Exception("서버에서 데이터 저장 실패!");
    }
  }
  
  public static Member get(
      ObjectInputStream in, ObjectOutputStream out, int no) throws Exception {
    
    out.writeUTF("/member/detail");
    out.flush();
    if (!in.readUTF().equals("OK")) {
      throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");
    }

    out.writeInt(no);
    out.flush();

    String status = in.readUTF();

    if (!status.equals("OK")) {
      throw new Exception("서버에서 게시글 가져오기 실패!");
    }

    return (Member) in.readObject();
  }
  
  public static void update(
      ObjectInputStream in, ObjectOutputStream out, Member member) throws Exception {
    
    out.writeUTF("/member/update");
    out.flush();
    if (!in.readUTF().equals("OK"))
      throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");
    
    out.writeObject(member);
    out.flush();
    
    String status = in.readUTF();
    if (!status.equals("OK")) 
      throw new Exception("서버에서 게시글 변경하기 실패!");
  }
  
  public static void delete(
      ObjectInputStream in, ObjectOutputStream out, int no) throws Exception {
    
    out.writeUTF("/member/delete");
    out.flush();
    if (!in.readUTF().equals("OK")) {
      throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");
    }
    
    out.writeInt(no);
    out.flush();
    
    String status = in.readUTF();
    
    if (!status.equals("OK")) {
      throw new Exception("서버에서 게시글 삭제 실패!");
    }
  }
  
}
