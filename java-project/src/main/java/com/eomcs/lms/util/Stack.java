package com.eomcs.lms.util;

public class Stack<E> {
  
  public static final int DEFAULT_SIZE = 10;
  Object[] list;
  int size;
  
  public Stack() {
    list = new Object[DEFAULT_SIZE];
  }
  
  public void push(E value) {
    // 맨 마지막에 추가한다.
    // 배열의 크기가 작다면 확장해야 한다.
    if (size >= list.length) {
      
      Object[] newList = new Object[list.length + (list.length >> 1)];
      for (int i = 0; i < list.length; i++) {
        newList[i] = list[i];
      }
      
      list = newList;
    }
    
    list[size++] = value;
  }
  
  @SuppressWarnings("unchecked")
  public E pop() {
    // 맨 마지막 값을 꺼내 리턴한다.
    // 꺼낸 값은 배열에서 제거되어야 한다.
    if (size == 0) {
      return null;
    }
    
    return (E) list[--size];
  }
  
  public boolean empty() {
    return size == 0;
  }
  
  public int size() {
    return size;
  }
  
}
