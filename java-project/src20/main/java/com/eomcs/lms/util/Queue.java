package com.eomcs.lms.util;

// 기존 기능을 활용하는 가장 쉬운 방법이 상속이다.
public class Queue<E> extends LinkedList<E> {
  
  public void offer(E value) {
    // 상속 받은 메서드를 사용하여 값을 추가하라.
    add(value);
  }
  
  public E poll() {
    // 상속 받은 메서드를 사용하여 값을 꺼내라.
    return (E) remove(0);
  }
  
  public boolean empty() {
    // 상속 받은 필드나 메서드를 사용하여 값을 리턴하라.
    return size == 0;
  }
}
