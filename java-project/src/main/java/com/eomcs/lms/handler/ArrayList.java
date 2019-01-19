package com.eomcs.lms.handler;

import java.util.Arrays;

public class ArrayList<E> {
  private int DEFAULT_LENGTH = 10;
  private Object[] list;
  private int size = 0;

  public ArrayList() {
    this.list = new Object[DEFAULT_LENGTH];
  }

  public ArrayList(int length) {
    if (length > this.DEFAULT_LENGTH) {
      this.list = new Object[length];
    } else {
      this.list = new Object[DEFAULT_LENGTH];
    }
  }

  @SuppressWarnings("unchecked")
  public E[] toArray(E[] sampleArr) {
    return (E[]) Arrays.copyOf(list, size, sampleArr.getClass());
    /*
    E[] arr = Arrays.copyOf(sampleArr, size);
    for (int i = 0; i < size; i++) {
      arr[i] = (E) this.list[i];
    }
    return arr;
     */
  }

  public void add(E object) {
    if (size == list.length) {

      list = Arrays.copyOf(list, list.length + (list.length >> 1));

      /*
      Object[] a = new Object[arr.length + (arr.length >> 1)];
      for (int i = 0; i < arr.length; i++) {
        a[i] = arr[i];
      }
      arr = a;
       */
    }
    list[size] = object;
    size++;
  }

  @SuppressWarnings("unchecked")
  public E get(int index) {
    // index : 값을 꺼낼 배열의 항목 위치
    return (E) this.list[index];
  }

  @SuppressWarnings("unchecked")
  public E set(int index, E value) {
    // index : 값을 변경할 배열의 항목 위치
    // value : 해당 위치에 있는 값을 대체할 값
    // 리턴 값 : 대체되기 전의 기존 값
    E tmp = (E) this.list[index];
    this.list[index] = value;
    
    return tmp;
  }

  public E remove(int index) {
    // index : 삭제할 배열의 항목 위치
    // 리턴 값 : 삭제된 이전 값
    // 힌트 : System.arraycopy() 참고
    this.list[index] = null;
    
    return null;
  }

}
