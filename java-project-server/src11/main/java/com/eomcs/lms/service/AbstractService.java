// 11단계: 서비스 클래스의 일반화(상속)를 수행한다.
package com.eomcs.lms.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractService<E> {

  List<E> list;

  ObjectInputStream in;
  ObjectOutputStream out;
  String filePath;

  public void init(ObjectInputStream in, ObjectOutputStream out) {
    this.in = in;
    this.out = out;
  }

  @SuppressWarnings("unchecked")
  public void loadData(String filePath) throws Exception {
    this.filePath = filePath;

    try (ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(
            new FileInputStream(this.filePath)))) {

      list = (List<E>) in.readObject();

    } catch (Exception e) {
      list = new ArrayList<E>();
      throw new Exception("데이터 파일 로딩 오류!", e);
    }
  }

  public void saveData() throws Exception {
    try (ObjectOutputStream out = new ObjectOutputStream(
        new BufferedOutputStream(
            new FileOutputStream(this.filePath)));) {

      // 파일 형식: 번호,내용,등록일,조회수
      out.writeObject(list);

    } catch (Exception e) {
      throw new Exception("데이터 파일 저장 오류!" + e);
    }
  }
  
  // 서브 클래스에게 다음 메서드의 구현을 강요한다.
  public abstract void execute(String request) throws Exception;

}
