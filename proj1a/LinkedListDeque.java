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
            last.setNext(new Node(item, null, last));
            last = last.getNext();
        } else {
            last = new Node(item, null, null);
            first = last;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
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
            temp = temp.getNext();
        }
    }

    public T removeFirst() {
        if (first == null) {
            return null;
        }
        size--;
        T res = first.getItem();
        first = first.getNext();
        if (first == null) {
            last = null;
            return res;
        }
        first.setPre(null);
        return res;
    }

    public T removeLast() {
        if (last == null) {
            return null;
        }
        size--;
        T res = last.getItem();
        last = last.getPre();
        last.setNext(null);
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
                return temp.getItem();
            }
            index--;
            temp = temp.getNext();
        }
        return null;
    }

    public T getRecursive(int index) {
        Node<T> temp = first;
        return getRecursiveHelper(index, temp);
    }

    private T getRecursiveHelper(int index, Node<T> pfirst) {
        if (pfirst == null) {
            return null;
        }
        if (index == 0) {
            return pfirst.getItem();
        }
        return getRecursiveHelper(index - 1, pfirst.getNext());
    }

    private class Node<T> {
        private T item;
        private Node<T> next;
        private Node<T> pre;

        Node(T pitem, Node<T> pnext, Node<T> ppre) {
            this.item = pitem;
            this.next = pnext;
            this.pre = ppre;
            if (this.next != null) {
                this.next.pre = this;
            }
            if (this.pre != null) {
                this.pre.next = this;
            }
        }


        public T getItem() {
            return item;
        }

        public Node<T> getNext() {
            return next;
        }

        public Node<T> getPre() {
            return pre;
        }

        public void setNext(Node<T> pnext) {
            this.next = pnext;
        }

        public void setPre(Node<T> ppre) {
            this.pre = ppre;
        }
    }
}
