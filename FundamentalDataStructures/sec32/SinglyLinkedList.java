package FundamentalDataStructures.sec32;

public class SinglyLinkedList<E> {
    private static class Node<E>{
        private E element;
        private Node<E> next;
        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }

        public E getElement(){
            return element;
        }

        public Node<E> getNext(){
            return next;
        }
        public void setNext(Node<E> n){
            next = n;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;

    private int size=0;
    public SinglyLinkedList(){

    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public E first(){
        if (isEmpty()){
            return null;
        }
        return head.getElement();
    }

    public E last(){
        if(isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e,head);
        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e,null);
        if (isEmpty()){
            head = newest;
        }else{
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst() throws NullPointerException{
        if (isEmpty()){
            throw new NullPointerException("no elements to remove");
        }
        Node<E> ele = head;
        head = head.getNext();
        size--;
        if (isEmpty()){
            tail = null;
        }
        return ele.getElement();

    }

    public String toString(){
        StringBuilder ll = new StringBuilder();
        Node<E> temp = head;
        while(temp != null){
            ll.append(temp.getElement()).append("--->");
            temp = temp.getNext();
        }
        ll.append("null");
        return ll.toString();
    }
}
