package com.eomcs.lms.listener;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.domain.Lesson;

public class LessonDataLoaderListener implements ApplicationContextListener {

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
            new FileOutputStream("lesson3.data")))) {

      // 파일 형식: 번호,수업명,설명,시작일,종료일,총수업시간,일수업시간
      out.writeObject(context.get("lessonList"));

    } catch (Exception e) {
      System.out.println("수업 데이터를 쓰는 중 오류 발생: " + e.toString());
    }
  }
  
}
