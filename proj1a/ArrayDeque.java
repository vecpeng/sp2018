public class ArrayDeque<T> {
    private T[] arr;
    private int first = -1;
    private int last = -1;
    private int cap = 0;

    private ArrayDeque() {
        cap = 10;
        arr = (T[]) new Object[cap];
    }

    public void addFirst(T item) {
        if (first == -1) {
            arr[5] = item;
            first = 5;
            last = 5;
            return;
        }
        if (first - last + 1 >= cap) {
            T[] newArr = (T[]) new Object[cap * 2];
            System.arraycopy(arr, 0, newArr, cap / 2, cap);
            cap = cap * 2;
            arr = newArr;
        }
        first = (first - 1 + cap) % cap;
        arr[first] = item;
    }

    public void addLast(T item) {
        if (first == -1) {
            arr[cap / 2] = item;
            first = cap / 2;
            last = cap / 2;
            return;
        }
        if (first - last + 1 >= cap) {
            T[] newArr = (T[]) new Object[cap * 2];
            System.arraycopy(arr, 0, newArr, cap / 2, cap);
            cap = cap * 2;
            arr = newArr;
        }
        last = (last + 1 + cap) % cap;
        arr[last] = item;
    }

    public boolean isEmpty() {

        return first == -1;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return last - first + 1;
    }

    public void printDeque() {
        for (int i = 0; i < size(); i++) {
            System.out.print(arr[(first + i) % cap] + " ");
        }
    }

    public T removeFirst() {
        if (first == -1) {
            return null;
        }
        T res = arr[first];
        arr[first] = null;
        if (first == last) {
            first = last = -1;
            return res;
        }
        first = (first + 1 + cap) % cap;
        return res;
    }

    public T removeLast() {
        if (last == -1) {
            return null;
        }
        T res = arr[last];
        arr[last] = null;
        if (first == last) {
            first = last = -1;
            return res;
        }
        last = (last - 1 + cap) % cap;
        return res;
    }

    public T get(int index) {
        if (index < size()) {
            return arr[(first + index + cap) % cap];
        }
        return null;
    }
}
