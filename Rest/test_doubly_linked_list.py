import unittest
from doubly_linked_list import*

class TestDoublyLinkedList(unittest.TestCase):

    def setUp(self):
        self.list = DoublyLinkedList()

    def populate(self, values):
        for v in values:
            self.list.append(v)

    def test_append(self):
        self.populate([1, 2, 3])
        self.assertEqual(self.list.to_list(), [1, 2, 3])

    def test_prepend(self):
        self.populate([2, 3])
        self.list.prepend(1)
        self.assertEqual(self.list.to_list(), [1, 2, 3])

    def test_insert_middle(self):
        self.populate([1, 3])
        self.list.insert_at(1, 2)
        self.assertEqual(self.list.to_list(), [1, 2, 3])

    def test_delete_head(self):
        self.populate([1, 2])
        self.list.delete(1)
        self.assertEqual(self.list.to_list(), [2])

    def test_delete_middle(self):
        self.populate([1, 2, 3])
        self.list.delete(2)
        self.assertEqual(self.list.to_list(), [1, 3])

    def test_delete_tail(self):
        self.populate([1, 2, 3])
        self.list.delete(3)
        self.assertEqual(self.list.to_list(), [1, 2])

    def test_delete_not_found(self):
        self.populate([1])
        with self.assertRaises(ValueError):
            self.list.delete(99)

    def test_reverse(self):
        self.populate([1, 2, 3])
        self.list.reverse()
        self.assertEqual(self.list.to_list(), [3, 2, 1])

    def test_reverse_single(self):
        self.populate([1])
        self.list.reverse()
        self.assertEqual(self.list.to_list(), [1])

    def test_insert_invalid(self):
        with self.assertRaises(IndexError):
            self.list.insert_at(5, 10)


