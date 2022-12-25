import java.util.Iterator;

public class MyArrayList<E> extends MyAbstractList<E> {
    private int INITIAL_CAPACITY = 10;
    private E[] data = (E[]) (new Object[INITIAL_CAPACITY]);

    public MyArrayList() {
    }

    public MyArrayList(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            this.add(objects[i]);
        }
    }

    @Override
    public void add(int index, E o) {
        ensureCapacity();
        for (int i = data.length - 1; i > index; i--) data[i] = data[i - 1];
        data[index] = o;
        size += 1;
    }

    private void ensureCapacity() {
        if (this.size >= data.length) {
            E[] newData = (E[]) new Object[2 * this.size + 1];
            System.arraycopy(data, 0, newData, 0, this.size);
            data = newData;
        }
    }

    @Override
    public void clear() {
        this.data = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(o)) return true;
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds!");
        }
        return this.data[index];
    }

    @Override
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(o)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E o) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i].equals(o)) return i;
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds!");
        }
        E e = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size -= 1;
        return e;
    }

    @Override
    public E set(int index, E o) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds!");
        }
        E e = data[index];
        data[index] = o;
        return e;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i < size - 1) result.append(", ");
        }
        result.append("]");
        return result.toString();
    }

    @Override
    public Iterator iterator(){
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator {
        private int current=0;
        @Override
        public boolean hasNext() {
            return current<size;
        }

        @Override
        public E next() {
            return data[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(current);
        }
    }
}
