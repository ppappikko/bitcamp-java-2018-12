package com.eomcs.lms.util;

import static org.junit.Assert.assertArrayEquals;
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

    assertEquals(6, list.size());
    assertArrayEquals(new Object[] {10,20,30,40,50,60}, list.toArray(new Integer[] {}));

  }

  @Test
  public void testInsert() {
    ArrayList<Integer> list = new ArrayList<>();

    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(50);
    list.add(60);

    list.insert(3, 100);

    assertEquals((Integer)100, list.get(3));
    assertEquals(7, list.size());
  }

  @Test
  public void testGet() {
    ArrayList<Integer> list = new ArrayList<>();

    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(50);
    list.add(60);

    assertEquals((Integer)50, list.get(4));
  }

  @Test
  public void testSet() {
    ArrayList<Integer> list = new ArrayList<>();

    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(50);
    list.add(60);

    list.set(2, 500);
    
    assertEquals((Integer)500, list.get(2));
    assertEquals(6, list.size());
  }

  @Test
  public void testRemove() {
    ArrayList<Integer> list = new ArrayList<>();
    
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(50);
    list.add(60);
    
    list.remove(0);
    list.remove(2);
    
    assertEquals((Integer)20, list.get(0));
    assertEquals((Integer)30, list.get(1));
    assertEquals((Integer)50, list.get(2));
    assertEquals((Integer)60, list.get(3));
    
    assertEquals(4, list.size());
  }
  
}
