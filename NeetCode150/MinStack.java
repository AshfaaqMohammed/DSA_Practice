package NeetCode150;

import java.util.Objects;
import java.util.Stack;

public class MinStack {

    private Stack<Integer> minstack;
    private Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minstack.isEmpty() || val <= minstack.peek()){
            minstack.push(val);
        }
    }

    public void pop() {
        Integer e = stack.pop();
        if (Objects.equals(e, minstack.peek())){
            minstack.pop();
        }
    }

    public int top() {
        return stack.lastElement();
    }

    public int getMin() {
        return minstack.peek();
    }
    
    public String toString(){
        return stack.toString();
    }
}
