import java.util.Deque;

/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /**
     * Adds a few things to the list, checking isEmpty() and size() are correct, finally printing
     * the results.
     *
     * <p>&& is the "and" operation.
     */
    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");
        System.out.println(
                "Make sure to uncomment the lines below (and delete this print statement).");
        ArrayDeque<String> lld1 = new ArrayDeque<>();

        lld1.removeLast();
        lld1.removeFirst();
        lld1.addLast("1");
        lld1.addLast("2");
        lld1.addLast("3");
        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(1, lld1.size()) && passed;
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.removeFirst();
        passed = checkSize(0, lld1.size()) && passed;
        passed = checkEmpty(true, lld1.isEmpty()) && passed;
        lld1.addFirst("middle");
        lld1.addFirst("middle");
        passed = checkSize(2, lld1.size()) && passed;

        lld1.removeLast();
        lld1.removeLast();

        lld1.addLast("fd");
        lld1.removeFirst();

        lld1.addFirst("fdf");
        lld1.removeLast();
        lld1.addLast("back");
        passed = checkSize(1, lld1.size()) && passed;

        System.out.println("Printing out deque: ");
        lld1.printDeque();

        printTestStatus(passed);
    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");

        System.out.println(
                "Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        for (int i = 0; i < 100; i ++) {
            if (i%4 == 0 || i% 5 == 0) {
                lld1.addLast(i);
            } else {
                lld1.addFirst(i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
    }
}
