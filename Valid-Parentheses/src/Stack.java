public interface Stack<E> {
    public int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
