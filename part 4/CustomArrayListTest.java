// CustomArrayListTest.java

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayListTest {

    @Test
    void testAddElement() {
        CustomArrayList<String> list = new CustomArrayList<>();

        list.add("Java");

        assertEquals(1, list.size());
        assertEquals("Java", list.get(0));
    }

    @Test
    void testAddMultipleElements() {
        CustomArrayList<Integer> list = new CustomArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    void testAddElementAtIndex() {
        CustomArrayList<String> list = new CustomArrayList<>();

        list.add("A");
        list.add("C");

        list.add(1, "B");

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    void testSetElement() {
        CustomArrayList<String> list = new CustomArrayList<>();

        list.add("Java");

        list.set(0, "Python");

        assertEquals("Python", list.get(0));
    }

    @Test
    void testRemoveElement() {
        CustomArrayList<String> list = new CustomArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        String removed = list.remove(1);

        assertEquals("B", removed);
        assertEquals(2, list.size());
        assertEquals("C", list.get(1));
    }

    @Test
    void testContainsElement() {
        CustomArrayList<String> list = new CustomArrayList<>();

        list.add("Java");

        assertTrue(list.contains("Java"));
        assertFalse(list.contains("Python"));
    }

    @Test
    void testIndexOfElement() {
        CustomArrayList<String> list = new CustomArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals(1, list.indexOf("B"));
        assertEquals(-1, list.indexOf("Z"));
    }

    @Test
    void testIsEmpty() {
        CustomArrayList<String> list = new CustomArrayList<>();

        assertTrue(list.isEmpty());

        list.add("Java");

        assertFalse(list.isEmpty());
    }

    @Test
    void testClear() {
        CustomArrayList<String> list = new CustomArrayList<>();

        list.add("A");
        list.add("B");

        list.clear();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void testDynamicResize() {
        CustomArrayList<Integer> list = new CustomArrayList<>();

        for (int i = 0; i < 15; i++) {
            list.add(i);
        }

        assertEquals(15, list.size());
        assertEquals(14, list.get(14));
    }

    @Test
    void testGetInvalidIndexThrowsException() {
        CustomArrayList<String> list = new CustomArrayList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(0);
        });
    }

    @Test
    void testRemoveInvalidIndexThrowsException() {
        CustomArrayList<String> list = new CustomArrayList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(1);
        });
    }

    @Test
    void testAddInvalidIndexThrowsException() {
        CustomArrayList<String> list = new CustomArrayList<>();

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(5, "Java");
        });
    }
}
