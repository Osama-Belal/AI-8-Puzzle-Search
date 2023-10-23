package data_type;

import java.util.LinkedList;
import java.util.Queue;

public class OurQueue<T> implements Frontier<T> {
    public Queue<T> queue;

    public OurQueue()
    {
        queue = new LinkedList<>();
    }

    @Override
    public void push(T state) {
        queue.add(state);
    }

    @Override
    public T pop() {
        return queue.poll();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
