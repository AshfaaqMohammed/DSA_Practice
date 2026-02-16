package Queue;

import static stacks.ArrayStack.CAPACITY;

public class ArrayQueue<E> implements Queue<E>{
    private E[] data;
    private int f=0;
    private int sz = 0;

    public ArrayQueue(int capacity){
        data = (E[]) new Object[capacity];
    }

    public ArrayQueue(){
        this(CAPACITY);
    }

    public int size(){
        return sz;
    }

    public boolean isEmpty(){
        return sz == 0;
    }

    public void enqueue(E e) throws IllegalStateException{
        if (sz == data.length){
            throw new IllegalStateException("Queue is full");
        }
        int avail = (f+sz) % data.length;
        data[avail] = e;
        sz++;
    }

    public E first(){
        if (isEmpty()){
            return null;
        }
        return data[f];
    }

    public E dequeue(){
        if (isEmpty()){
            return null;
        }
        E ans = data[f];
        data[f] = null;
        f = (f+1)%data.length;
        sz--;
        return ans;
    }
}
