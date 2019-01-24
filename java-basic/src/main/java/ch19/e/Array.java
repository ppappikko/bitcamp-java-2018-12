// 배열 복제를 도와주는 클래스
package ch19.e;

public class Array {
  LinkedList list;
  
  public Array(LinkedList list) {
    this.list = list;
  }
  
  // 입력된 순서대로 배열을 만든다.
  public Object[] copy() {
    
    Object[] arr = new Object[list.size()];
    
    for (int i = 0; i < list.size(); i++) {
      arr[i] = list.get(i);
    }
    return arr;
  }
  
  // 입력된 순서의 반대로 배열을 만든다.
  public Object[] reverseCopy() {
    Object[] arr = new Object[list.size()];
    
    for (int i = list.size() - 1, j = 0; i >= 0; i--, j++) {
      // i에 마지막 값을 넣고 0까지 반복하면서 j는 0부터 1씩 증가한다.
      // 따라서 arr의 j번 방에 복사할 list의 i번 방을 넣는다.
      arr[j] = list.get(i);
    }
    
    return arr;
  }
  
  
}
