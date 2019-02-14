// 11단계: 서비스 클래스의 일반화(상속)를 수행한다.
package com.eomcs.lms.service;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class AbstractService<E> {

  protected ObjectInputStream in;
  protected ObjectOutputStream out;

  public void init(ObjectInputStream in, ObjectOutputStream out) {
    this.in = in;
    this.out = out;
  }

  // 서브 클래스에게 다음 메서드의 구현을 강요한다.
  public abstract void execute(String request) throws Exception;

}
