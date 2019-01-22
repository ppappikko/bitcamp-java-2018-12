package algorithm.data_structure.array;


public class ArrayList {

  static final int DEFAULT_SIZE = 5;

  private Object[] arr;
  private int size = 0;

  public ArrayList() {
    this(0);
  }

  public ArrayList(int capacity) {
    if (capacity > DEFAULT_SIZE) {
      arr = new Object[capacity];
    } else {
      arr = new Object[DEFAULT_SIZE];
    }
  }
  public Object[] toArray() {
    // 데이터 개수 만큼 배열을 만들고 값을 복사하여 리턴.
    if (size <= 0) {
      return null;
    }
    Object[] list = new Object[size];

    for (int i = 0; i < size; i++) {
      list[i] = arr[i];
    }

    return list;
  }
 
  public void add(Object value) {
    // 현재 배열이 꽉 찼다면 현재 배열 크기의 50% 만큼 증가시켜라.
    if (size >= arr.length) {
      increase();
    }
    arr[size++] = value;
  }

  public int insert(int index, Object value) {
    // 현재 배열이 꽉 찼다면 현재 배열 크기의 50% 만큼 증가시켜라.
    // 유효 index(현재 배열에 데이터가 저장된 방 번호)가 아니면 저장하지 말라.
    // 삽입할 위치의 항목부터 이후의 항목들을 뒤로 밀어라.
    if (index < 0 || index >= size()) {
      return -1;
    }
    
    if (size >= arr.length) {
      increase();
    }
    
    for (int i = size(); i > index; i--) {
      arr[i] = arr[i - 1];
    }
    
    size++;
    arr[index] = value;
    return 0;
  }

  public Object get(int index) {
    // 유효 index(현재 배열에 데이터가 저장된 방 번호)가 아니면 null을 리턴하라.
    if (index < 0 || index >= size()) {
      return null;
    }
    return arr[index];
  }

  public Object set(int index, Object value) {
    // 유효 index(현재 배열에 데이터가 저장된 방 번호)가 아니면 변경하지 말라. 리턴 값은 null이다.
    if (index < 0 || index >= size()) {
      return null;
    }

    Object old = arr[index];
    arr[index] = value;

    return old;
  }

  public Object remove(int index) {
    // 유효 index(현재 배열에 데이터가 저장된 방 번호)가 아니면 삭제하지 말라.
    // 삭제한 후 다음 항목을 앞으로 당긴다.
    if (index < 0 || index >= size()) {
      return null;
    }
    
    Object old = arr[index];
    
    for (int i = index; i < size() - 1; i++) {
      arr[i] = arr[i + 1];
    }
    size--;

    return old;
  }

  public int size() {
    return this.size;
  }

  private void increase() {
    
    int originSize = arr.length;
    int newSize = originSize + (originSize >> 1);
    Object[] temp = new Object[newSize];

    for (int i = 0; i < originSize; i++) {
      temp[i] = this.arr[i];
    }
    arr = temp;
    // arr = Arrays.copyOf(arr, arr.length + (arr.length >> 1));
  }

}






