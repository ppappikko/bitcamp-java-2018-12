package com.eomcs.lms.listener;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;
import com.eomcs.lms.context.ApplicationListener;
import com.eomcs.lms.domain.Lesson;

// Application의 상태를 보고 받고 싶다면
// ApplicationListener 규칙에 따라 클래스를 작성해야 한다.
//
public class LessonDataLoaderListener implements ApplicationListener {
  
  @Override
  public void startApplication(Map<String, Object> context) {
    System.out.println("Application이 시작될 때 준비 작업을 수행한다.");
    try (ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(
            new FileInputStream("lesson3.data")))){
      context.put("lessonList", in.readObject());
      
    } catch (Exception e) {
      System.out.println("수업 데이터를 읽는 중 오류 발생: " + e.toString());
      context.put("lessonList", new ArrayList<Lesson>());
    }
  }

  @Override
  public void endApplication(Map<String, Object> context) {
    System.out.println("Application이 종료될 때 마무리 작업을 수행한다.");
    try (ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
            new FileOutputStream("lesson3.data")));) {

      // 파일 형식: 번호,내용,등록일,조회수
      out.writeObject(context.get("lessonList"));
      
    } catch (Exception e) {
      System.out.println("수업 데이터를 쓰는 중 오류 발생: " + e.toString());
    }
  }
}
