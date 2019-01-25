package design_pattern.iterator;


public class ArrayList<E> {

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

  public void add(E value) {
    // 현재 배열이 꽉 찼다면 현재 배열 크기의 50% 만큼 증가시켜라.
    if (size >= arr.length) {
      increase();
    }
    arr[size++] = value;
  }

  public int insert(int index, E value) {
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

  @SuppressWarnings("unchecked")
  public E get(int index) {
    // 유효 index(현재 배열에 데이터가 저장된 방 번호)가 아니면 null을 리턴하라.
    if (index < 0 || index >= size()) {
      return null;
    }
    return (E) arr[index];
  }

  @SuppressWarnings("unchecked")
  public E set(int index, E value) {
    // 유효 index(현재 배열에 데이터가 저장된 방 번호)가 아니면 변경하지 말라. 리턴 값은 null이다.
    if (index < 0 || index >= size()) {
      return null;
    }

    E old = (E) arr[index];
    arr[index] = value;

    return old;
  }

  @SuppressWarnings("unchecked")
  public E remove(int index) {
    // 유효 index(현재 배열에 데이터가 저장된 방 번호)가 아니면 삭제하지 말라.
    // 삭제한 후 다음 항목을 앞으로 당긴다.
    if (index < 0 || index >= size()) {
      return null;
    }

    E old = (E) arr[index];

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

  // 자신이 보유한 데이터를 대신 꺼내주는 일을 하는 객체를 리턴한다.
  public Iterator<E> iterator() {

    return new Iterator<E>() {
      // 이 클래스는 ArrayList에서 값을 꺼내주는 일을 전문적으로 한다.
      // => 이런 일을 하는 객체를 "Iterator"라 부른다.
      //
      int index = 0;

      @Override
      public boolean hasNext() {
        return index < size();
      }

      @Override
      public E next() {
        return (E) get(index++);
      }
    }; // 

  }


}






