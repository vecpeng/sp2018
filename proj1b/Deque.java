interface Deque<T> {
    void addFirst(T item);
    void addLast(T item);
    void removeLast(T item);
    void removeFirst(T item);
    boolean isEmpty();
    int size();
    T get(int index);
}
