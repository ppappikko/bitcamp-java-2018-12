package com.eomcs.lms.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ArrayListTest {
  
  @Test
  public void testAdd() {
    ArrayList<Integer> list = new ArrayList<>();
    
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(50);
    list.add(60);
    
    assertEquals(6, list.size());
    
  }
  
  @Test
  public void testList() {
    ArrayList<Integer> list = new ArrayList<>();
    
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(50);
    list.add(60);
    
    
  }
  
  
}
