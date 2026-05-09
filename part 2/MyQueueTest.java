import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class MyQueueTest {

    @Test
    public void testQueueIsEmptyAfterCreation() {
        MyQueue.createQueue(5);
        assertTrue(MyQueue.empty());
    }

    @Test
    public void testEnqueueAddsElement() {
        MyQueue.createQueue(5);
        MyQueue.enqueue(10);
        assertFalse(MyQueue.empty());
    }

    @Test
    public void testDequeueReturnsFirstElement() {
        MyQueue.createQueue(5);
        MyQueue.enqueue(10);
        MyQueue.enqueue(20);

        int result = MyQueue.dequeue();

        assertEquals(10, result);
    }

    @Test
    public void testPeekReturnsFrontWithoutRemoving() {
        MyQueue.createQueue(5);
        MyQueue.enqueue(10);
        MyQueue.enqueue(20);

        int result = MyQueue.peek();

        assertEquals(10, result);
    }

    @Test
    public void testPollRemovesAndReturnsFront() {
        MyQueue.createQueue(5);
        MyQueue.enqueue(10);
        MyQueue.enqueue(20);

        int result = MyQueue.poll();

        assertEquals(10, result);
    }

    @Test
    public void testRemoveThrowsWhenEmpty() {
        MyQueue.createQueue(5);

        assertThrows(IllegalStateException.class, () -> {
            MyQueue.remove();
        });
    }

    @Test
    public void testDequeueThrowsWhenEmpty() {
        MyQueue.createQueue(5);

        assertThrows(IllegalStateException.class, () -> {
            MyQueue.dequeue();
        });
    }

    @Test
    public void testQueueBecomesEmptyAfterRemovingAllElements() {
        MyQueue.createQueue(5);
        MyQueue.enqueue(10);

        MyQueue.dequeue();

        assertTrue(MyQueue.empty());
    }

    @Test
    public void testOfferReturnsFalseWhenFull() {
        MyQueue.createQueue(2);
        MyQueue.offer(10);
        MyQueue.offer(20);

        boolean result = MyQueue.offer(30);

        assertFalse(result);
    }

    @Test
    public void testAddThrowsWhenFull() {
        MyQueue.createQueue(2);
        MyQueue.add(10);
        MyQueue.add(20);

        assertThrows(IllegalStateException.class, () -> {
            MyQueue.add(30);
        });
    }

    @Test
    public void testCircularBehavior() {
        MyQueue.createQueue(3);

        MyQueue.enqueue(10);
        MyQueue.enqueue(20);
        MyQueue.enqueue(30);

        MyQueue.dequeue(); 
        MyQueue.enqueue(40); 

        int result = MyQueue.dequeue();

        assertEquals(20, result);
    }
}
