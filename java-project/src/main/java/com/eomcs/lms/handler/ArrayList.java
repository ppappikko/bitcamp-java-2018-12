package com.eomcs.lms.handler;

import java.util.Arrays;

public class ArrayList {
  private int LENGTH = 10;
  private Object[] arr;
  private int size = 0;
  
  public ArrayList() {
    this.arr = new Object[this.LENGTH];
  }
  
  public ArrayList(int length) {
    if (length > this.LENGTH) {
      this.arr = new Object[length];
    } else {
      this.arr = new Object[this.LENGTH];
    }
  }
  
  public Object[] toArray() {
    Object[] objects = new Object[size];
    for (int i = 0; i < size; i++) {
      objects[i] = arr[i];
    }
    return objects;
  }

  public void add(Object object) {
    if (size == arr.length) {

      arr = Arrays.copyOf(arr, arr.length + (arr.length >> 1));

      /*
      Object[] a = new Object[arr.length + (arr.length >> 1)];
      for (int i = 0; i < arr.length; i++) {
        a[i] = arr[i];
      }
      arr = a;
       */
    }
    arr[size] = object;
    size++;
  }
}
