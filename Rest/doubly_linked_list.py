class DoublyNode:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None


class DoublyLinkedList:
    def __init__(self):
        self.head = None

    def append(self, data):
        new_node = DoublyNode(data)

        if not self.head:
            self.head = new_node
            return

        current = self.head
        while current.next:
            current = current.next

        current.next = new_node
        new_node.prev = current

    def prepend(self, data):
        new_node = DoublyNode(data)

        if self.head:
            self.head.prev = new_node
            new_node.next = self.head

        self.head = new_node

    def insert_at(self, index, data):
        if index < 0:
            raise IndexError("Negative index")

        if index == 0:
            self.prepend(data)
            return

        new_node = DoublyNode(data)
        current = self.head

        for _ in range(index - 1):
            if not current:
                raise IndexError("Index out of range")
            current = current.next

        if not current:
            raise IndexError("Index out of range")

        new_node.next = current.next
        new_node.prev = current

        if current.next:
            current.next.prev = new_node

        current.next = new_node

    def delete(self, key):
        current = self.head

        while current:
            if current.data == key:
                if current.prev:
                    current.prev.next = current.next
                else:
                    self.head = current.next

                if current.next:
                    current.next.prev = current.prev
                return

            current = current.next

        raise ValueError("Value not found")

    def reverse(self):
        current = self.head
        prev = None

        while current:
            current.prev, current.next = current.next, current.prev
            prev = current
            current = current.prev

        self.head = prev

    def to_list(self):
        result = []
        current = self.head

        while current:
            result.append(current.data)
            current = current.next

        return result
