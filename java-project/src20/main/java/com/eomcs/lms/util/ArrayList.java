package com.eomcs.lms.util;

import java.util.Arrays;

public class ArrayList<E> {
  private static final int DEFAULT_CAPACITY = 10;
  private Object[] list;
  private int size = 0;

  public ArrayList() {
    this(0);
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
    increase();
    list[size++] = obj;
  }
  
  public int insert(int index, E value) {
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

  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index >= size) {
      return null;
    }
    return (E) list[index];
  }

  @SuppressWarnings("unchecked")
  public E set(int index, E temp) {
    if (index < 0 || index >= size) {
      return null;
    }
    
    E old = (E) list[index];
    
    list[index] = temp;
    
    return old;
  }

  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index < 0 || index >= size) {
      return null;
    }
    
    E old = (E) list[index];
    
    for (int i = index; i < size - 1; i++) {
      list[i] = list[i + 1];
    }
    size--;
    
    return old;
  }
  
  public int size() {
    return this.size;
  }

  private void increase() {
    if (size >= list.length) {
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      list = Arrays.copyOf(list, newCapacity);
    }
  }
}
