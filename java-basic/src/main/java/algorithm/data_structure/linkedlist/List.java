package algorithm.data_structure.linkedlist;


public interface List<E> {
  
  void add(E value);
  E get(int index);
  Object[] toArray();
  E[] toArray(E[] a);
  E set(int index, E value);
  E remove(int index);
  int size();
}
