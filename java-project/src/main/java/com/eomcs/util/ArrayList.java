package com.eomcs.util;

import java.util.Arrays;

public class ArrayList<E> implements List<E> {
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
  
  @Override
  public Object[] toArray() {
    // 새로운 오브젝트 배열을 현재 size 만큼 생성하고 arr에 담는다.
    Object[] arr = new Object[size];
    // 메소드를 사용하여 list에 저장되있는 객체(주소)를 복제 한다.
    System.arraycopy(list, 0, arr, 0, size);
    
    return arr;
  }
  
  @SuppressWarnings("unchecked")
  public E[] toArray(E[] a) {
    if (a.length < size) {
      return (E[]) Arrays.copyOf(list, size, a.getClass());
    }
    System.arraycopy(list, 0, a, 0, size);
    if (a.length > size)
      a[size] = null;
    return a;
  }
  
  public void add(E obj) {
    if (size >= list.length) {
      list = Arrays.copyOf(list, list.length + (list.length >> 1));
    }
    
    list[size++] = obj;
  }

  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index < 0 || index >= size) 
      return null;
    
    return (E) list[index];
  }

  public E set(int index, E obj) {
    if (index < 0 || index >= size)
      return null;
    
    @SuppressWarnings("unchecked")
    E old = (E)list[index];
    list[index] = obj;
    return old;
  }
  
  public E remove(int index) {
    if (index < 0 || index >= size)
      return null;
    
    @SuppressWarnings("unchecked")
    E old = (E)list[index];
    
    int newSize = size - 1;
    // 리스트의 인덱스 + 1 부터 인덱스에 있는 값을 복제 사이즈 - 1 만큼
    System.arraycopy(list, index + 1, list, index, newSize - index);
    list[size = newSize] = null;
    return old;
  }
  
  public int size() {
    return size;
  }
  
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");
    list.add("eee");
    list.add("fff");
    list.add("ggg");
    
    System.out.println(list.size());
    
    System.out.println(list.remove(3));
    
    System.out.println(list.size());
    
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }
}
