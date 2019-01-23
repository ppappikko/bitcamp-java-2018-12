package algorithm.data_structure.linkedlist;

// LinkedList 에서 다룰 데이터를 담는 그릇이다.
//
public class Node2 {
  public Object value;
  public Node2 prev;
  public Node2 next;
  
  // 기본 생성자
  public Node2() {
  }
  
  // Object 값을 파라미터로 받는 생성자
  public Node2(Object value) {
    this.value = value;
  }
  
  // Object 값 3개를 받는 생성자
  public Node2(Object value, Node2 prev, Node2 next) {
    this(value); // Object 값을 받는 생성자 호출
    this.prev = prev;
    this.next = next;
  }
}
