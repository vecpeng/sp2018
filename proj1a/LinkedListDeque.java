class LinkedListDeque<T> {
    class Node<T> {
        public T item;
        public Node<T> next;
        public Node<T> pre;
        public Node(T item, Node<T> next, Node<T> pre) {
            this.item = item;
            this.next = next;
            this.pre = pre;
        }
    }
    public Node<T> first;
    public Node<T> last;
    private int size;

    public LinkedListDeque() {
        first = last = null;
        size = 0;
    }

    public void addFirst(T item) {
        if (first == null) {
            last = new Node(item, null, null);
        }
        first = new Node(item, first, null);
        size++;
    }

    public void addLast(T item) {
        if (last != null) {
            last.next = new Node(item, null, last);
            last = last.next;
        } else {
            last = new Node(item, null, null);
            first = last;
        }
        size++;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node temp = first;
        while(temp != null) {
            temp = temp.next;
            System.out.print(temp.item + " ");
        }
    }

    public T removeFirst() {
        if (first == null) {
            return null;
        }
        T res = first.item;
        first = first.next;
        if (first == null) {
            return res;
        }
        first.next.pre = null;
        return res;
    }

    public T removeLast() {
        T res = first.item;
        last = last.pre;
        last.next = null;
        return res;
    }

    public T get(int index) {
        Node<T> temp = first;
        while(temp != null) {
            if (index == 0) {
                return temp.item;
            }
            index--;
            temp = temp.next;
        }
        return null;
    }

    public T getRecursive(int index) {
        return getRecursiveHelper(index, first);
    }

    public T getRecursiveHelper(int index, Node<T> first) {
        if (first == null) {
            return null;
        }
        if (index == 0) {
            return (T) first.item;
        }
        return getRecursiveHelper(index-1, first.next);
    }
}