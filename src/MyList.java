public interface MyList<E> extends Iterable<E> {
    void add(E e);

    void add(int index, E e);

    void clear();

    boolean contains(E e);

    E get(int index);

    int indexOf(E e);

    boolean isEmpty();

    int lastIndexOf(E e);

    E remove(int index);

    boolean remove(E e);

    E set(int index, E e);

    int size();
}
