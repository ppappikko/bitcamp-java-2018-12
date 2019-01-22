package com.eomcs.lms.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ArrayList1Test {
  
  @Test
  public void testAdd() {
    ArrayList1 list = new ArrayList1();
    
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    assertEquals(6, list.size());
  }
  
  @Test
  public void testlist() {
    ArrayList1 list = new ArrayList1();
    
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    assertArrayEquals(new Object[] {100,200,300,400,500,600}, list.toArray());
  }
  
  @Test
  public void testInsert() {
    ArrayList1 list = new ArrayList1();
    
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    list.insert(3, 1234);
    
    assertEquals(100, list.get(0));
    assertEquals(200, list.get(1));
    assertEquals(300, list.get(2));
    assertEquals(1234, list.get(3));
    assertEquals(400, list.get(4));
    assertEquals(500, list.get(5));
    assertEquals(600, list.get(6));
    
    assertEquals(7, list.size());
  }
  
  @Test
  public void testGet() {
    ArrayList1 list = new ArrayList1();
    
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    assertEquals(100, list.get(0));
    assertEquals(200, list.get(1));
    assertEquals(300, list.get(2));
    assertEquals(400, list.get(3));
    assertEquals(500, list.get(4));
  }
  
  @Test
  public void testSet() {
    ArrayList1 list = new ArrayList1();
    
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    list.set(3, 12345);
    
    assertEquals(12345, list.get(3));
  }
  
  
  @Test
  public void testRemove() {
    ArrayList1 list = new ArrayList1();
    
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    list.remove(3);
    
    assertEquals(500, list.get(3));
    assertEquals(5, list.size());
  }
}
