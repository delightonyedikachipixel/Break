import unittest
from custom_dictionary import CustomDictionary


class TestCustomDictionary(unittest.TestCase):

    def setUp(self):
        self.dictionary = CustomDictionary()

    def test_insert_and_get_value(self):
        self.dictionary.put("name", "Delight")
        self.assertEqual(self.dictionary.get("name"), "Delight")

    def test_update_existing_key(self):
        self.dictionary.put("name", "John")
        self.dictionary.put("name", "Delight")

        self.assertEqual(self.dictionary.get("name"), "Delight")
        self.assertEqual(self.dictionary.size(), 1)

    def test_remove_key(self):
        self.dictionary.put("age", 25)
        self.dictionary.remove("age")

        self.assertFalse(self.dictionary.contains_key("age"))

    def test_get_missing_key_raises_error(self):
        with self.assertRaises(KeyError):
            self.dictionary.get("missing")

    def test_contains_key(self):
        self.dictionary.put("city", "Lagos")

        self.assertTrue(self.dictionary.contains_key("city"))
        self.assertFalse(self.dictionary.contains_key("country"))

    def test_keys_values_items(self):
        self.dictionary.put("a", 1)
        self.dictionary.put("b", 2)

        self.assertEqual(set(self.dictionary.keys()), {"a", "b"})
        self.assertEqual(set(self.dictionary.values()), {1, 2})

    def test_clear_dictionary(self):
        self.dictionary.put("a", 1)
        self.dictionary.clear()

        self.assertTrue(self.dictionary.is_empty())



