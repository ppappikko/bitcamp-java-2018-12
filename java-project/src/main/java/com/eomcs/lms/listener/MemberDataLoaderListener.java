package com.eomcs.lms.listener;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.Map;
import com.eomcs.lms.context.ApplicationContextListener;

public class MemberDataLoaderListener implements ApplicationContextListener {

  @Override
  public void startApplication(Map<String, Object> context) {
    System.out.println("Application이 시작될 때 준비 작업을 수행한다.");
    try (ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(
            new FileInputStream("member2.data")))){
      
      context.put("memberList", in.readObject());
      
    } catch (Exception e) {
      System.out.println("회원 데이터를 읽는 중 오류 발생: " + e.toString());
      context.put("memberList", new LinkedList<>());
    } 
  }

  @Override
  public void endApplication(Map<String, Object> context) {
    System.out.println("Application이 종료될 때 마무리 작업을 수행한다.");
    try (ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("member2.data")))) {

      // 파일 형식: 번호,이름,이메일,암호,사진,전화,가입일
      out.writeObject(context.get("memberList"));
      
    } catch (Exception e) {
      System.out.println("회원 데이터를 쓰는 중 오류 발생: " + e.toString());
    }
  }
  
}
