package data_type;

public class PriorityQueue <T extends Comparable<T>> implements Frontier<T>{
    private PriorityQueue<T> queue;

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
