package stacks;

import FundamentalDataStructures.sec32.SinglyLinkedList;

public class LinkedStack<E> implements Stack<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    public LinkedStack(){

    }

    @Override
    public int size(){
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e){
        list.addFirst(e);
    }

    public E pop(){
        return list.removeFirst();
    }

    public E top(){
        return list.first();
    }

    public String toString(){
        return list.toString();
    }

}
