class CustomDictionary:

    def __init__(self):
        self.items = []

    def put(self, key, value):
        for index, (existing_key, existing_value) in enumerate(self.items):
            if existing_key == key:
                self.items[index] = (key, value)
                return

        self.items.append((key, value))

    def get(self, key):
        for existing_key, existing_value in self.items:
            if existing_key == key:
                return existing_value

        raise KeyError(f"Key '{key}' not found")

    def remove(self, key):
        for index, (existing_key, existing_value) in enumerate(self.items):
            if existing_key == key:
                del self.items[index]
                return

        raise KeyError(f"Key '{key}' not found")

    def contains_key(self, key):
        for existing_key, _ in self.items:
            if existing_key == key:
                return True
        return False

    def keys(self):
        return [key for key, value in self.items]

    def values(self):
        return [value for key, value in self.items]

    def items_list(self):
        return self.items

    def size(self):
        return len(self.items)

    def is_empty(self):
        return len(self.items) == 0

    def clear(self):
        self.items = []
