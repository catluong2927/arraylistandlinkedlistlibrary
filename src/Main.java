import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> ll = new MyLinkedList<Integer>();
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);

        ll.add(2,9);
        ll.add(2,9);
        System.out.println(ll);

        MyArrayList<Integer> al = new MyArrayList<Integer>();
        al.add(0,11);
        al.add(1,12);
        al.add(2,13);

        al.add(3,9);
        al.add(4,9);
        System.out.println(al);
    }
}
