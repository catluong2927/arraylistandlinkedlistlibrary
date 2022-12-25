import java.util.Iterator;

public class MyLinkedList<E> extends MyAbstractList<E> {

    public static final String INDEX_IS_OUT_OF_BOUNDS = "Index is out of bounds.";

    private class Node {
        E data;
        Node next;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head = null;

    public MyLinkedList() {
    }

    public MyLinkedList(E[] objects) {
        for (int i = objects.length - 1; i >= 0; i--) {
            this.head = new Node(objects[i], this.head);
        }
        this.size = objects.length;
    }

    private boolean isOutOfBounds(int index) {
        if (index < 0 || index >= size) return true;
        return false;
    }

    private Node getNode(int index) {
        if (isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException(INDEX_IS_OUT_OF_BOUNDS);
        }
        Node node = head;
        int i = 0;
        while (i < index) {
            node = node.next;
            i += 1;
        }
        return node;
    }

    private Node getTail() {
        return getNode(size - 1);
    }

    private Node getHead() {
        return this.head;
    }

    public void addFirst(E e) {
        Node node = new Node(e, head);
        head = node;
        size += 1;
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(INDEX_IS_OUT_OF_BOUNDS);
        }
        if (index == 0) {
            addFirst(e);
            return;
        }
        Node pointerNode = getNode(index - 1);
        pointerNode.next = new Node(e, pointerNode.next);
        size += 1;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean contains(E e) {
        Node node = head;
        while (node != null) {
            if (node.data == e) return true;
            node = node.next;
        }
        return false;
    }

    @Override
    public E get(int index) {
        return getNode(index).data;
    }

    @Override
    public int indexOf(E e) {
        int index = 0;
        Node node = head;
        while (node != null) {
            if (node.data == e) return index;
            node = node.next;
            index += 1;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        int index = -1;
        int i = 0;
        Node node = head;
        while (node != null) {
            if (node.data == e) index = i;
            node = node.next;
            i += 1;
        }
        return index;
    }

    @Override
    public E remove(int index) {
        E e = get(index);
        if (index == 0) {
            head = head.next;
        } else {
            Node node=getNode(index-1);
            node.next=node.next.next;
        }
        size-=1;
        return e;
    }

    @Override
    public E set(int index, E e) {
        if(isOutOfBounds(index)){
            throw new IndexOutOfBoundsException(INDEX_IS_OUT_OF_BOUNDS);
        }
        E eResult=get(index);
        getNode(index).data=e;
        return eResult;
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorLinkedList<E>();
    }

    private class IteratorLinkedList<E> implements Iterator<E> {
        private  Node previousNode=new Node(null,head);
        private Node iteratorNode=head;
        @Override
        public boolean hasNext() {
            return iteratorNode!=null;
        }

        @Override
        public E next() {
            E data=(E)iteratorNode.data;
            iteratorNode=iteratorNode.next;
            previousNode=previousNode.next;
            return data;
        }


    }

    @Override
    public String toString() {
        Node head_ = head;
        String result = "[";
        while (head_ != null) {
            result += head_.data;
            if (head_.next != null) result += ", ";
            head_ = head_.next;
        }
        return result + "]";
    }
}
