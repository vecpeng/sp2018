public class LinkedListDeque<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public LinkedListDeque() {
        first = last = null;
        size = 0;
    }

    public void addFirst(T item) {
        size++;
        if (first == null) {
            first = last = new Node(item, null, null);
            return;
        }
        first = new Node(item, first, null);
    }

    public void addLast(T item) {
        size++;
        if (last != null) {
            last.next = new Node(item, null, last);
            last = last.next;
        } else {
            last = new Node(item, null, null);
            first = last;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (first == null) {
            return;
        }
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
    }

    public T removeFirst() {
        if (first == null) {
            return null;
        }
        size--;
        T res = first.item;
        first = first.next;
        if (first == null) {
            last = null;
            return res;
        }
        first.next.pre = null;
        return res;
    }

    public T removeLast() {
        if (last == null) {
            return null;
        }
        size--;
        T res = last.item;
        last = last.pre;
        if (last == null) {
            first = null;
            return res;
        }
        last.next = null;
        return res;
    }

    public T get(int index) {
        Node<T> temp = first;
        while (temp != null) {
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

    private T getRecursiveHelper(int index, Node<T> first) {
        if (first == null) {
            return null;
        }
        if (index == 0) {
            return first.item;
        }
        return getRecursiveHelper(index - 1, first.next);
    }

    private class Node<T> {
        public T item;
        public Node<T> next;
        public Node<T> pre;

        public Node(T item, Node<T> next, Node<T> pre) {
            this.item = item;
            this.next = next;
            this.pre = pre;
            if (this.next != null) {
                this.next.pre = this;
            }
            if (this.pre != null) {
                this.pre.next = this;
            }
        }
    }
}
