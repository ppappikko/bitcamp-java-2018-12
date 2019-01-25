package com.eomcs.util;

public class Stack<E> implements Cloneable {
  
  public static final int DEFAULT_SIZE = 5;
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
    size--;
    
    E value = (E) list[size];
    list[size] = null;
    
    return value;
  }
  
  public boolean empty() {
    return size == 0;
  }
  
  public int size() {
    return size;
  }
  
  @Override
  public Stack<E> clone() throws CloneNotSupportedException {
    // return (Stack<E>) super.clone();
    // Object에서 상속 받은 clone()은
    // 인스턴스 필드의 값만 복제한다.
    // 인스턴스 필드가 가리키는 다른 인스턴스는 복제하지 않는다.
    // 예를 들어 Stack의 list 배열 레퍼런스가 가리키는 배열 인스턴스는 복제하지 않는다.
    // 배열 인스턴스까지 복제(deep clone)하려면 개발자가 직접 코드를 작성해야 한다.
    //
    Stack<E> temp = new Stack<>();
    for (int i = 0; i < this.size(); i++) {
      temp.push(list[i]);
    }
    
    return temp;
  }
  
}
