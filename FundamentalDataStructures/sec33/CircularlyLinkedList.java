package FundamentalDataStructures.sec33;

public class CircularlyLinkedList<E> {

    private class Node<E>{
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
            next=n;
        }
    }

    private Node<E> tail = null;
    private int size = 0;
    public CircularlyLinkedList(){

    }
    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        }
        return tail.getNext().getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void rotate(){
        if (tail != null){
            tail = tail.getNext();
        }
    }

    public void addFirst(E element){
        if (tail == null){
            tail = new Node<>(element,null);
            tail.setNext(tail);
        }else{
            Node<E> newest = new Node<>(element,tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    public void addLast(E element){
        addFirst(element);
        tail = tail.getNext();
    }

    public E removeLast(){
        if (tail == null){
            return null;
        }
        Node<E> head = tail.getNext();
        if(head == tail){
            tail = null;
        }else {
            tail.setNext(head.getNext());
        }
        size--;
        return head.getElement();
    }





}
