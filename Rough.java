import FundamentalDataStructures.sec32.SinglyLinkedList;

public class Rough {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> ll = new SinglyLinkedList<>();
        ll.addFirst(33);
        ll.addFirst(23);
        ll.addLast(100);
        ll.removeFirst();

        System.out.println(ll);
    }
}
