// 제네릭 적용
package com.eomcs.util;


// Queue가 보관하는 데이터 타입을 E 라고 가정하자.
// => E라고 가정한 상태에서 코드를 작성한다.
//
public class Queue<E> extends LinkedList<E> implements Cloneable {
  
  public void offer(E value) {
    // 상속 받은 메서드를 사용하여 값을 추가하라.
    add(value);
  }
  
  public E poll() {
    // 상속 받은 메서드를 사용하여 값을 꺼내라.
    return remove(0);
  }
  
  public boolean empty() {
    // 상속 받은 필드나 메서드를 사용하여 값을 리턴하라.
    return size() == 0;
  }
  
  @Override
  public Queue<E> clone() throws CloneNotSupportedException {
    Queue<E> temp = new Queue<>();
    for (int i = 0; i < this.size(); i++) {
      temp.add(this.get(i));
    }
    return temp;
  }
  
}
