package com.eomcs.lms.util;

public class ArrayList1 {
  public static final int DEFAULT_SIZE = 5;
  
  private Object[] list;
  private int size = 0;
  
  public ArrayList1() {
    this(0);
  }
  
  public ArrayList1(int capacity) {
    if (capacity > DEFAULT_SIZE) {
      list = new Object[capacity];
    } else {
      list = new Object[DEFAULT_SIZE];
    }
  }
  
  public Object[] toArray() {
    if (size <= 0) {
      return null;
    }
    
    Object[] objs = new Object[size];
    
    for (int i = 0; i < size; i++) {
      objs[i] = this.list[i];
    }
    
    return objs;
  }
  
  public void add(Object value) {
    increase();
    this.list[size++] = value;
    
  }
  
  public int insert(int index, Object value) {
    if (index < 0 || index >= size) {
      return -1;
    }
    
    increase();
    
    for (int i = size - 1; i >= index; i--) {
      this.list[i + 1] = this.list[i];
    }
    size++;
    this.list[index] = value;
    return 0;
    
  }
  
  public Object get(int index) {
    if (index < 0 || index >= size) {
      return null;
    }
    return this.list[index];
  }
  
  public Object set(int index, Object value) {
    if (index < 0 || index >= size) {
      return null;
    }
    Object old = this.list[index];
    this.list[index] = value;
    
    return old;
  }
  

  public Object remove(int index) {
    if (index < 0 || index >= size) {
      return null;
    }
    Object old = this.list[index];
    
    for (int i = index; i < size - 1; i++) {
      this.list[i] = this.list[i + 1];
    }
    size--;
    return old;
  }
  
  public int size() {
    return this.size;
  }
  
  private void increase() {
    if (size >= list.length) {
      int originSize = list.length;
      int newSize = originSize + (originSize >> 1);
      
      Object[] objs = new Object[newSize];
      
      for (int i = 0; i < originSize; i++) {
        objs[i] = list[i];
      }
      this.list = objs;
    }
  }
  
}
