package algorithm.data_structure.linkedlist;

// LinkedList 에서 다룰 데이터를 담는 그릇이다.
//
public class Node {
  public Object value;
  public Node prev;
  public Node next;
  
  // 기본 생성자
  public Node() {
  }
  
  // value 값을 파라미터로 받는 생성자
  public Node(Object value) {
    this.value = value;
  }
  
  // value, prev, next 값을 파라미터로 받는 생성자
  public Node(Object value, Node prev, Node next) {
    this(value);
    this.prev = prev;
    this.next = next;
  }
}
