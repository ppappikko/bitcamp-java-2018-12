package com.eomcs.util;

import java.util.Arrays;

public class Stack<E> implements Cloneable {
  
  private static final int DEFAULT_SIZE = 10;
  
  private E[] list;
  private int size = 0;
  
  @SuppressWarnings("unchecked")
  public Stack() {
    list = (E[]) new Object[DEFAULT_SIZE];
  }
  
  @Override
  public Stack<E> clone() throws CloneNotSupportedException {
    Stack<E> temp = new Stack<>();
    for (int i = 0; i < this.size(); i++) {
      temp.push(list[i]);
    }
    
    return temp;
  }
  
  public void push(E obj) {
    if (size >= list.length) {
      // 스택이 꽉차면 크기를 50% 늘린다.
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      list = Arrays.copyOf(list, newCapacity);
    }
    
    list[size++] = obj;
  }
  
  public E pop() {
    if (size == 0) 
      return null;
     
    return list[--size];
  }

  public int size() {
    return size;
  }
  
  public boolean empty() {
    return size == 0;
  }
    
}
