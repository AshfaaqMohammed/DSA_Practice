import FundamentalDataStructures.sec32.SinglyLinkedList;

public class Rough {
    public static void main(String[] args) {
//        SinglyLinkedList<Integer> ll = new SinglyLinkedList<>();
//        ll.addFirst(33);
//        ll.addFirst(23);
//        ll.addLast(100);
//        ll.removeFirst();
//
//        System.out.println(ll);
        long startTime = System.currentTimeMillis();
        int num = 0;
        for (int i=0;i<100000;i++){
            num+=i;
        }
        System.out.println(num);
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        System.out.println(elapsed);
    }
}
