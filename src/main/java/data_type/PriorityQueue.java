package data_type;

import javafx.scene.layout.Priority;

public class PriorityQueue <T extends Comparable<T>> implements Frontier<T>{
    private java.util.PriorityQueue<T> queue;

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
