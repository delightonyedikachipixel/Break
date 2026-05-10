// SinglyLinkedListTest.java

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {

    private SinglyLinkedList list;

    @BeforeEach
    void setUp() {
        list = new SinglyLinkedList();
    }

    private void populate(int[] values) {

        for (int value : values) {
            list.append(value);
        }
    }

    @Test
    void testAppendSingle() {

        list.append(1);

        assertArrayEquals(new int[]{1}, list.toList());
    }

    @Test
    void testAppendMultiple() {

        populate(new int[]{1, 2, 3});

        assertArrayEquals(new int[]{1, 2, 3}, list.toList());
    }

    @Test
    void testPrepend() {

        populate(new int[]{2, 3});

        list.prepend(1);

        assertArrayEquals(new int[]{1, 2, 3}, list.toList());
    }

    @Test
    void testInsertAtTail() {

        populate(new int[]{1, 2});

        list.insertAt(2, 3);

        assertArrayEquals(new int[]{1, 2, 3}, list.toList());
    }

    @Test
    void testInsertInvalidIndex() {

        populate(new int[]{1, 2});

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.insertAt(5, 10);
        });
    }

    @Test
    void testInsertNegativeIndex() {

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.insertAt(-1, 10);
        });
    }

    @Test
    void testSearchFound() {

        populate(new int[]{10, 20, 30});

        assertEquals(1, list.search(20));
    }

    @Test
    void testSearchNotFound() {

        populate(new int[]{10, 20});

        assertEquals(-1, list.search(50));
    }

    @Test
    void testSearchEmptyList() {

        assertEquals(-1, list.search(1));
    }

    @Test
    void testSizeEmpty() {

        assertEquals(0, list.size());
    }

    @Test
    void testSizeAfterOperations() {

        populate(new int[]{1, 2, 3});

        assertEquals(3, list.size());
    }

    @Test
    void testReverseMultiple() {

        populate(new int[]{1, 2, 3});

        list.reverse();

        assertArrayEquals(new int[]{3, 2, 1}, list.toList());
    }

    @Test
    void testReverseSingle() {

        populate(new int[]{1});

        list.reverse();

        assertArrayEquals(new int[]{1}, list.toList());
    }

    @Test
    void testReverseEmpty() {

        list.reverse();

        assertArrayEquals(new int[]{}, list.toList());
    }
}
