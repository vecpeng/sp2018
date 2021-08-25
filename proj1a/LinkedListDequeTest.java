import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Performs some basic linked list tests.
 */
public class LinkedListDequeTest {
    @Test
    public void testAddAndSize() {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        assertEquals(null, a.removeFirst());
        assertEquals(null, a.removeLast());
        assertTrue(a.isEmpty());
        a.addFirst(1);
        assertEquals(1, a.size());
        assertFalse(a.isEmpty());
        assertEquals(1, java.util.Optional.ofNullable(a.get(0)));
        assertEquals(null, a.get(2));
        a.removeLast();
        assertTrue(a.isEmpty());
        assertEquals(0, a.size());
        for (int i = 0; i < 12; i++) {
            a.addFirst(i);
            a.addLast(i + 10);
        }

        assertEquals(java.util.Optional.of(11), a.get(0));
        assertEquals(java.util.Optional.of(21), a.get(23));
        assertEquals(a.size(), 24);
        a.removeFirst();
        assertEquals(a.size(), 23);
        a.removeLast();
        assertEquals(a.size(), 22);
        assertEquals(java.util.Optional.of(10), a.get(0));
        for (int i = 0; i < 12; i++) {
            a.addFirst(i);
            a.addLast(i + 10);
        }

        assertEquals(a.size(), 46);
    }
}
