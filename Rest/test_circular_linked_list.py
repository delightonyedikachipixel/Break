import unittest
from circular_linked_list import*

class TestCircularLinkedList(unittest.TestCase):

    def setUp(self):
        self.list = CircularLinkedList()

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

    def test_delete_head(self):
        self.populate([1, 2, 3])
        self.list.delete(1)
        self.assertEqual(self.list.to_list(), [2, 3])

    def test_delete_middle(self):
        self.populate([1, 2, 3])
        self.list.delete(2)
        self.assertEqual(self.list.to_list(), [1, 3])

    def test_delete_last_element(self):
        self.populate([1])
        self.list.delete(1)
        self.assertEqual(self.list.to_list(), [])

    def test_delete_not_found(self):
        self.populate([1, 2])
        with self.assertRaises(ValueError):
            self.list.delete(99)

    def test_empty_list(self):
        self.assertEqual(self.list.to_list(), [])


