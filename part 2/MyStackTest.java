import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class MyStackTest {

    @Test
    public void testThatStackIsEmpty() {
        ArrayList<Integer> stack = MyStack.createStack();
        assertTrue(MyStack.empty(stack));
    }

    @Test
    public void testPushAddsElement() {
        ArrayList<Integer> stack = MyStack.createStack();
        MyStack.push(stack, 10);
        assertFalse(MyStack.empty(stack));
    }

    @Test
    public void testPopReturnsLastElement() {
        ArrayList<Integer> stack = MyStack.createStack();
        MyStack.push(stack, 10);
        MyStack.push(stack, 20);

        int result = MyStack.pop(stack);

        assertEquals(20, result);
    }

    @Test
    public void testPopOnEmptyThrowsException() {
        ArrayList<Integer> stack = MyStack.createStack();

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            MyStack.pop(stack);
        });

        assertEquals("Stack is empty", exception.getMessage());
    }

    @Test
    public void testPeekReturnsTopElement() {
        ArrayList<Integer> stack = MyStack.createStack();
        MyStack.push(stack, 50);

        assertEquals(50, MyStack.peek(stack));
    }

    @Test
    public void testPeekOnEmptyThrowsException() {
        ArrayList<Integer> stack = MyStack.createStack();

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            MyStack.peek(stack);
        });

        assertEquals("Stack is empty", exception.getMessage());
    }

    @Test
    public void testSearchFindsElement() {
        ArrayList<Integer> stack = MyStack.createStack();
        MyStack.push(stack, 10);
        MyStack.push(stack, 20);
        MyStack.push(stack, 30);

        assertEquals(2, MyStack.search(stack, 20));
    }

    @Test
    public void testSearchReturnsMinusOneIfNotFound() {
        ArrayList<Integer> stack = MyStack.createStack();
        MyStack.push(stack, 10);

        assertEquals(-1, MyStack.search(stack, 99));
    }
}
