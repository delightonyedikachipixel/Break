import unittest
from stack import *;

class TestStack(unittest.TestCase):
    def setUp(self):
        self.stack = Stack()

    def test_stack_is_empty_on_creation(self):
        self.assertTrue(self.stack.is_empty())
        self.assertEqual(self.stack.size(), 0)

    def test_stack_not_empty_after_push(self):
        self.stack.push('A')
        self.assertFalse(self.stack.is_empty())
        self.assertEqual(self.stack.size(), 1)

    def test_peek_returns_top_element(self):
        self.stack.push('A')
        self.stack.push('B')
        self.assertEqual(self.stack.peek(), 'B')

    def test_pop_removes_top_element(self):
        self.stack.push('A')
        self.stack.push('B')
        popped = self.stack.pop()
        self.assertEqual(popped, 'B')
        self.assertEqual(self.stack.size(), 1)

    def test_pop_on_empty_stack_raises_error(self):
        with self.assertRaises(IndexError):
            self.stack.pop()

    def test_peek_on_empty_stack_raises_error(self):
        with self.assertRaises(IndexError):
            self.stack.peek()

    def test_multiple_push_pop(self):
        self.stack.push('A')
        self.stack.push('B')
        self.stack.push('C')
        self.assertEqual(self.stack.pop(), 'C')
        self.assertEqual(self.stack.pop(), 'B')
        self.assertEqual(self.stack.pop(), 'A')
        self.assertTrue(self.stack.is_empty())

    def test_size_updates_correctly(self):
        self.stack.push('A')
        self.stack.push('B')
        self.stack.pop()
        self.assertEqual(self.stack.size(), 1)


