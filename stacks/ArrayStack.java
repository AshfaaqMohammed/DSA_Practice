package stacks;

import java.util.Arrays;

public class ArrayStack<E> implements Stack<E> {
    public static final int CAPACITY = 1000;
    private E[] data;
    private int t = -1;

    public ArrayStack(){
        this(CAPACITY);
    }

    public ArrayStack(int CAPACITY){
        data = (E[]) new Object[CAPACITY];
    }
    @Override
    public int size(){
        return t+1;
    }

    public boolean isEmpty(){
        return t == -1;
    }

    public void push(E e){
        if (size() == data.length){
            throw new IllegalStateException("Stack is full");
        }
        data[t+1] = e;
        t++;
    }

    public E top(){
        if (isEmpty()){
            return null;
        }
        return data[t];
    }

    public E pop(){
        if (isEmpty()){
            return null;
        }
        E ele = data[t];
        data[t] = null;
        t --;
        return ele;
    }

    public String toString(){
        return Arrays.toString(data);
    }


}
