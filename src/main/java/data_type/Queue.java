package data_type;

public class Queue<T> implements Frontier<T> {
    private java.util.Queue<T> queue;

    @Override
    public void push(T state) {
        queue.add(state);
    }

    @Override
    public T pop() {
        return queue.remove();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
