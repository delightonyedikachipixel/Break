import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapTest {

    @Test
    void testPutAndGetSingleEntry() {
        Map map = new Map();

        map.put("name", "Delight");

        assertEquals("Delight", map.get("name"));
    }

    @Test
    void testPutMultipleEntries() {
        Map map = new Map();

        map.put("name", "Delight");
        map.put("city", "Lagos");
        map.put("country", "Nigeria");

        assertEquals("Delight", map.get("name"));
        assertEquals("Lagos", map.get("city"));
        assertEquals("Nigeria", map.get("country"));
    }

    @Test
    void testUpdateExistingKey() {
        Map map = new Map();

        map.put("name", "Delight");
        map.put("name", "John");

        assertEquals("John", map.get("name"));
        assertEquals(1, map.size());
    }

    @Test
    void testGetNonExistingKeyReturnsNull() {
        Map map = new Map();

        assertNull(map.get("unknown"));
    }

    @Test
    void testRemoveExistingKey() {
        Map map = new Map();

        map.put("name", "Delight");
        map.put("city", "Lagos");

        boolean removed = map.remove("name");

        assertTrue(removed);
        assertNull(map.get("name"));
        assertEquals(1, map.size());
    }

    @Test
    void testRemoveNonExistingKey() {
        Map map = new Map();

        map.put("name", "Delight");

        boolean removed = map.remove("age");

        assertFalse(removed);
        assertEquals(1, map.size());
    }

    @Test
    void testContainsKeyWhenKeyExists() {
        Map map = new Map();

        map.put("name", "Delight");

        assertTrue(map.containsKey("name"));
    }

    @Test
    void testContainsKeyWhenKeyDoesNotExist() {
        Map map = new Map();

        map.put("name", "Delight");

        assertFalse(map.containsKey("age"));
    }

    @Test
    void testKeySetReturnsAllKeys() {
        Map map = new Map();

        map.put("name", "Delight");
        map.put("city", "Lagos");

        String[] keys = map.keySet();

        assertEquals(2, keys.length);
        assertEquals("name", keys[0]);
        assertEquals("city", keys[1]);
    }

    @Test
    void testSizeInitiallyZero() {
        Map map = new Map();

        assertEquals(0, map.size());
    }

    @Test
    void testSizeAfterAddingElements() {
        Map map = new Map();

        map.put("name", "Delight");
        map.put("city", "Lagos");

        assertEquals(2, map.size());
    }

    @Test
    void testSizeAfterRemovingElement() {
        Map map = new Map();

        map.put("name", "Delight");
        map.put("city", "Lagos");

        map.remove("city");

        assertEquals(1, map.size());
    }
}
