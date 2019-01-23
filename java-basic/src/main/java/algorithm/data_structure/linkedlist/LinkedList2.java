package algorithm.data_structure.linkedlist;

public class LinkedList2 {
  protected Node2 head; // List의 머리(처음) 노드
  protected Node2 tail; // List의 꼬리(마지막) 노드
  protected int size; // List의 갯수

  // List의 생성자
  public LinkedList2() {
    // 머리 부분에 노드 인스턴스 노드를 담는다.
    head = new Node2();
    // 꼬리 부분에 머리 부분 노드를 담는다.
    tail = head;
    // 처음 사이즈는 0
    size = 0;
  }

  // LinkedList는 add() 할 때 마다 노드를 만들어 값을 저장하기 때문에
  // ArrayList 처럼 한 번에 큰 메모리를 준비할 필요가 없다.
  // => 그러나 값 이외에 다음 노드와 이전 노드의 주소를 담기 위해 추가로 메모리를 사용한다.
  public void add(Object value) {
    // 1) 마지막 노드에 value를 담는다.
    tail.value = value;

    // 2) 새로운 노드를 준비한다.
    Node2 node = new Node2();

    // 3) 마지막 노드의 다음으로 새 노드를 가리킨다.
    tail.next = node;

    // 3) 새 노드의 이전으로 마지막 노드를 가리킨다.
    node.prev = tail;

    // 4) 새 노드를 마지막 노드로 한다.
    tail = node;

    // 5) 크기를 증가
    size++;
  }

  // ArrayList와 달리 해당 인덱스를 찾아 가려면 링크를 따라가야 하기 때문에
  // 조회 속도가 느리다.
  public Object get(int index) {
    // 유효성 검사.
    if (index < 0 || index >= size) {
      return null;
    }

    // cursor 노드에 첫 번째 노드를 넣고 현재 가리키는 값을 찾는다.
    Node2 cursor = head;
    // index는 0부터 시작하지만 head가 처음 부분이므로 1부터 반복한다. 인덱스 값까지 반복.
    for (int i = 1; i <= index; i++) {
      // 커서 노드에 커서 다음 노드를 담는다.
      cursor = cursor.next;
    }
    // 인덱스 번째 노드의 값 value를 리턴한다.
    return cursor.value;
  }

  public Object[] toArray() {
    // 유효성 검사
    if (size <= 0) {
      return null;
    }
    // 사이즈 만큼의 새 오브젝트 배열을 만들어 준다.
    Object[] arr = new Object[size];
    // cursor 노드에 첫 번째 노드를 넣고 현재 가리키는 값을 찾는다.
    Node2 cursor = head;
    // 0번부터 size 값 만큼 반복
    for (int i = 0; i < size; i++) {
      // 오브젝트 배열에 현재 커서가 가리키는 값을 넣는다.
      arr[i] = cursor.value;
      // 그 후 커서를 다음 노드값으로 바꾼다.
      cursor = cursor.next;
    }

    return arr;
  }

  public Object set(int index, Object value) {
    if (index < 0 || index >= size) {
      return null;
    }
    Node2 cursor = head;
    // index는 0부터 시작하지만 head가 처음 부분이므로 1부터 반복한다. 인덱스 값까지 반복.
    for (int i = 1; i <= index; i++) {
      // 커서 노드에 커서 다음 노드를 담는다.
      cursor = cursor.next;
    }
    Object old = cursor.value;
    cursor.value = value;

    return old;
  }

  // 값을 삽입하는 경우에는 ArrayList 방식 보다 효율적이다.
  // 삽입 위치를 찾은 후에 새 노드를 앞뒤 노드에 연결하면 된다.
  public int insert(int index, Object value) {
    // 유효성 검사
    if (index < 0 || index >= size) {
      return -1;
    }
    // value 값을 가지는 새로운 노드를 만든다.
    Node2 node = new Node2(value);

    // index가 가리키는 cursor 값을 찾는다
    Node2 cursor = head;
    // index는 0부터 시작하지만 head가 처음 부분이므로 1부터 반복한다. 인덱스 값까지 반복.
    for (int i = 1; i <= index; i++) {
      // 커서 노드에 커서 다음 노드를 담는다.
      cursor = cursor.next;
    }
    // 1) 새 노드 값의 다음 노드로 cursor 노드를 가리킨다
    node.next = cursor;
    // 2) 새 노드 값의 이전 노드로 cursor의 이전 노드를 가리킨다
    node.prev = cursor.prev;

    // 3) cursor의 이전 노드를 새 노드로 바꾼다.
    cursor.prev = node;

    if (node.prev != null) {
      // 4) 새 노드의 이전 노드의 다음 노드를 새 노드로 바꾼다.
      node.prev.next = node;
    } else {
      head = node;
    }
    size++;

    return 0;
  }

  public Object remove(int index) {
    // 유효성 검사
    if (index < 0 || index >= size) {
      return null;
    }
    // index가 가리키는 cursor 값을 찾는다
    Node2 cursor = head;
    // index는 0부터 시작하지만 head가 처음 부분이므로 1부터 반복한다. 인덱스 값까지 반복.
    for (int i = 1; i <= index; i++) {
      // 커서 노드에 커서 다음 노드를 담는다.
      cursor = cursor.next;
    }
    Object old = cursor.value;

    if (cursor.prev != null) {
      cursor.prev.next = cursor.next;
    } else {
      head = cursor.next;
    }
    cursor.next.prev = cursor.prev;

    cursor.value = null;
    cursor.prev = null;
    cursor.next = null;

    size--;
    return old;
  }

  public int size() {
    return size;
  }

}
