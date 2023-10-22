package data_type;

public class Queue<T> implements Frontier<T> {
    private Queue<T> queue;

    @Override
    public void push(T state) {
        queue.push(state);
    }

    @Override
    public T pop() {
        return queue.pop();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
