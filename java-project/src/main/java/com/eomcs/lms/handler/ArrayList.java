package com.eomcs.lms.handler;

import java.util.Arrays;

public class ArrayList<E> {
  private static final int DEFAULT_CAPACITY = 10;
  private Object[] list;
  private int size = 0;

  public ArrayList() {
    list  = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int initialCapacity) {
    if (initialCapacity > DEFAULT_CAPACITY)
      list = new Object[initialCapacity];
    else
      list = new Object[DEFAULT_CAPACITY];
  }

  @SuppressWarnings("unchecked")
  public E[] toArray(E[] sampleArray) {
    return (E[]) Arrays.copyOf(list, size, sampleArray.getClass());
  }

  public void add(E obj) {
    if (size >= list.length) {
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      list = Arrays.copyOf(list, newCapacity);
    }

    list[size++] = obj;
  }

  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index >= size) {
      return null;
    }
    return (E) list[index];
  }

  public int size() {
    return this.size;
  }

  @SuppressWarnings("unchecked")
  public E set(int index, E temp) {
    if (index < 0 || index >= size) {
      return null;
    }
    
    E obj = (E) list[index];
    
    list[index] = temp;
    
    return obj;
  }

  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index < 0 || index >= size) {
      return null;
    }
    
    E obj = (E) list[index];
    
    for (int i = index; i < size - 1; i++) {
      list[i] = list[i + 1];
    }
    size--;
    
    
    return obj;
  }
}
