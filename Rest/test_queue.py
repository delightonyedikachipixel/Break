import unittest
from queue import*
class TestQueue(unittest.TestCase):

    def setUp(self):
        self.queue = Queue()

    def test_queue_is_empty_on_creation(self):
        self.assertTrue(self.queue.is_empty())
        self.assertEqual(self.queue.size(), 0)

    def test_enqueue_makes_queue_not_empty(self):
        self.queue.enqueue(10)
        self.assertFalse(self.queue.is_empty())
        self.assertEqual(self.queue.size(), 1)

    def test_enqueue_multiple_elements(self):
        self.queue.enqueue(1)
        self.queue.enqueue(2)
        self.queue.enqueue(3)
        self.assertEqual(self.queue.size(), 3)
        self.assertEqual(self.queue.peek(), 1)

    def test_dequeue_returns_correct_element(self):
        self.queue.enqueue(1)
        self.queue.enqueue(2)
        value = self.queue.dequeue()
        self.assertEqual(value, 1)
        self.assertEqual(self.queue.size(), 1)

    def test_dequeue_until_empty(self):
        self.queue.enqueue(1)
        self.queue.enqueue(2)
        self.queue.dequeue()
        self.queue.dequeue()

        self.assertTrue(self.queue.is_empty())
        self.assertEqual(self.queue.size(), 0)

    def test_dequeue_on_empty_queue_raises_error(self):
        with self.assertRaises(IndexError):
            self.queue.dequeue()

    def test_peek_on_empty_queue_raises_error(self):
        with self.assertRaises(IndexError):
            self.queue.peek()

    def test_peek_does_not_remove_element(self):
        self.queue.enqueue(5)
        self.assertEqual(self.queue.peek(), 5)
        self.assertEqual(self.queue.size(), 1)

    def test_rear_becomes_none_when_queue_empty(self):
        self.queue.enqueue(1)
        self.queue.dequeue()
        self.assertIsNone(self.queue.rear)
        self.assertIsNone(self.queue.front)

    def test_mixed_operations(self):
        self.queue.enqueue(1)
        self.queue.enqueue(2)
        self.assertEqual(self.queue.dequeue(), 1)
        self.queue.enqueue(3)
        self.assertEqual(self.queue.peek(), 2)
        self.assertEqual(self.queue.size(), 2)



