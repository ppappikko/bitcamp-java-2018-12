package algorithm.data_structure.linkedlist;

import static org.junit.Assert.*;
import org.junit.Test;

public class LinkedList2Test {

  @Test
  public void testAdd() {
    LinkedList2 list = new LinkedList2();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    list.add(700);
    
    assertEquals(7, list.size());
  }
  
  @Test
  public void testGet() {
    LinkedList2 list = new LinkedList2();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    list.add(700);
    
    assertEquals(100, list.get(0));
    assertEquals(200, list.get(1));
    assertEquals(300, list.get(2));
    assertEquals(400, list.get(3));
    assertEquals(500, list.get(4));
    assertEquals(600, list.get(5));
    assertEquals(700, list.get(6));
    
  }

  @Test
  public void testToArray() {
    LinkedList2 list = new LinkedList2();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    list.add(700);
    
    assertArrayEquals(new Object[] {100,200,300,400,500,600,700}, list.toArray());
    list.add(100);
    assertArrayEquals(new Object[] {100,200,300,400,500,600,700,100}, list.toArray());
  }
  
  @Test
  public void testSet() {
    LinkedList2 list = new LinkedList2();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    list.add(700);
    
    assertEquals(100, list.set(0, 55));
    assertEquals(55, list.get(0));
    
    assertEquals(300, list.set(2, 55));
    assertEquals(55, list.get(2));
    
    assertEquals(500, list.set(4, 55));
    assertEquals(55, list.get(4));
  }
  
  @Test
  public void testInsert() {
    LinkedList2 list = new LinkedList2();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    list.add(700);
    
    assertEquals(0, list.insert(1, 55));
    assertEquals(55, list.get(1));
    assertEquals(200, list.get(2));
    
    assertEquals(0, list.insert(0, 55));
    assertEquals(55, list.get(0));
    assertEquals(100, list.get(1));
    
    assertEquals(9, list.size());
  }
  
  @Test
  public void testRemove() {
    LinkedList2 list = new LinkedList2();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    list.add(700);
    
    assertEquals(200, list.remove(1));
    assertEquals(300, list.get(1));
    assertEquals(400, list.get(2));
    
    assertEquals(100, list.remove(0));
    assertEquals(300, list.get(0));
    assertEquals(400, list.get(1));
    
    assertEquals(700, list.remove(4));
    
    assertEquals(4, list.size());
    assertArrayEquals(new Object[] {300,400,500,600}, list.toArray());
    
  }
  
  
}
