import unittest
from singly_linked_list import*


class TestSinglyLinkedList(unittest.TestCase):


    def setUp(self):
        self.list = SinglyLinkedList()


    def populate(self, values):
        for value in values:
            self.list.append(value)

    def test_append_single(self):
        self.list.append(1)
        self.assertEqual(self.list.to_list(), [1])

    def test_append_multiple(self):
        self.populate([1, 2, 3])
        self.assertEqual(self.list.to_list(), [1, 2, 3])

    def test_prepend(self):
        self.populate([2, 3])
        self.list.prepend(1)
        self.assertEqual(self.list.to_list(), [1, 2, 3])

    def test_insert_at_tail(self):
        self.populate([1, 2])
        self.list.insert_at(2, 3)
        self.assertEqual(self.list.to_list(), [1, 2, 3])

    def test_insert_invalid_index(self):
        self.populate([1, 2])

        with self.assertRaises(IndexError):
            self.list.insert_at(5, 10)

    def test_insert_negative_index(self):
        with self.assertRaises(IndexError):
            self.list.insert_at(-1, 10)

    def test_search_found(self):
        self.populate([10, 20, 30])
        self.assertEqual(self.list.search(20), 1)

    def test_search_not_found(self):
        self.populate([10, 20])
        self.assertEqual(self.list.search(50), -1)

    def test_search_empty_list(self):
        self.assertEqual(self.list.search(1), -1)

    def test_size_empty(self):
        self.assertEqual(self.list.size(), 0)

    def test_size_after_operations(self):
        self.populate([1, 2, 3])
        self.assertEqual(self.list.size(), 3)

    def test_reverse_multiple(self):
        self.populate([1, 2, 3])
        self.list.reverse()
        self.assertEqual(self.list.to_list(), [3, 2, 1])

    def test_reverse_single(self):
        self.populate([1])
        self.list.reverse()
        self.assertEqual(self.list.to_list(), [1])

    def test_reverse_empty(self):
        self.list.reverse()
        self.assertEqual(self.list.to_list(), [])



