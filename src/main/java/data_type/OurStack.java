package data_type;

import java.util.Stack;

public class OurStack<T> implements Frontier<T> {
    public Stack<T> stack;

    public OurStack(){
        stack = new Stack<>();
    }

    @Override
    public void push(T state) {
        stack.push(state);
    }

    @Override
    public T pop() {
        return stack.pop();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
