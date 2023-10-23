package data_type;

import java.util.PriorityQueue;
public class OurPriorityQueue <T extends Comparable<T>> implements Frontier<T>{
    private PriorityQueue<T> queue;

    public OurPriorityQueue()
    {
        queue = new PriorityQueue<>();
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
