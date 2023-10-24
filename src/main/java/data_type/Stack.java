package data_type;

public class Stack<T> implements Frontier<T> {
    private java.util.Stack<T> stack;

    @Override
    public void push(T state) {
        stack.push(state);
    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
