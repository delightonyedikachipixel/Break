class CircularNode:
    def __init__(self, data):
        self.data = data
        self.next = None


class CircularLinkedList:
    def __init__(self):
        self.head = None

    def append(self, data):
        new_node = CircularNode(data)

        if not self.head:
            self.head = new_node
            new_node.next = new_node
            return

        current = self.head
        while current.next != self.head:
            current = current.next

        current.next = new_node
        new_node.next = self.head

    def prepend(self, data):
        new_node = CircularNode(data)

        if not self.head:
            self.head = new_node
            new_node.next = new_node
            return

        current = self.head
        while current.next != self.head:
            current = current.next

        new_node.next = self.head
        current.next = new_node
        self.head = new_node

    def delete(self, key):
        if not self.head:
            raise ValueError("Empty list")

        current = self.head
        prev = None

        while True:
            if current.data == key:
                if prev:
                    prev.next = current.next
                else:
                    # deleting head
                    if current.next == self.head:
                        self.head = None
                        return

                    tail = self.head
                    while tail.next != self.head:
                        tail = tail.next

                    self.head = current.next
                    tail.next = self.head
                    return

                if current == self.head:
                    self.head = current.next
                return

            prev = current
            current = current.next

            if current == self.head:
                break

        raise ValueError("Value not found")

    def to_list(self):
        result = []

        if not self.head:
            return result

        current = self.head
        while True:
            result.append(current.data)
            current = current.next
            if current == self.head:
                break

        return result
