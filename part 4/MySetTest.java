

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MySetTest {

    private MySet<Integer> ourSet;

    @BeforeEach
    void setUp() {
        ourSet = new MySet<>();
    }

    @Test
    void testThatANewSetIsEmpty() {
        assertTrue(ourSet.isEmpty());
    }

    @Test
    void testAddOneElementSetIsNotEmpty() {
        ourSet.add(23);

        assertFalse(ourSet.isEmpty());
    }

    @Test
    void testSetDoesNotAddDuplicateElement() {
        ourSet.add(23);
        ourSet.add(23);

        assertEquals(1, ourSet.size());
    }

    @Test
    void testRemoveSetElementSetLengthIsReducedWhenElementIsRemoved() {
        ourSet.add(23);
        ourSet.add(24);

        ourSet.remove(24);

        assertEquals(1, ourSet.size());
    }

    @Test
    void testRemoveElementRaiseErrorWhenElementNotInSet() {
        ourSet.add(23);

        assertThrows(RuntimeException.class, () -> {
            ourSet.remove(24);
        });
    }

    @Test
    void testUnionOfTwoSetGivesOneSetOfAllElementsContained() {

        ourSet.add(23);
        ourSet.add(24);

        MySet<Integer> anotherSet = new MySet<>();
        anotherSet.add(25);
        anotherSet.add(56);

        int expected = ourSet.union(anotherSet);

        assertEquals(4, expected);
    }

    @Test
    void testIntersectionOfTwoSetGivesOneSetOfCommonElement() {

        ourSet.add(23);
        ourSet.add(24);

        MySet<Integer> anotherSet = new MySet<>();
        anotherSet.add(23);
        anotherSet.add(56);

        int expected = ourSet.intersection(anotherSet);

        assertEquals(1, expected);
    }
}
