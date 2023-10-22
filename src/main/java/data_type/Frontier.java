package data_type;

public interface Frontier <T> {
    public void push(T state);
    public T pop();
    public boolean isEmpty();
}
