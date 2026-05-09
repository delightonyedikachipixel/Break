class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class Queue:
    def __init__(self):
        self.front = None
        self.rear = None
        self.length = 0

    def enqueue(self, element):
        new_node = Node(element)
        if self.rear is None:
            self.front = self.rear = new_node
        else:
            self.rear.next = new_node
            self.rear = new_node
        self.length += 1

    def dequeue(self):
        if self.is_empty():
            raise IndexError("Queue is empty")

        temp = self.front
        self.front = temp.next
        self.length -= 1

        if self.front is None:
            self.rear = None

        return temp.data

    def peek(self):
        if self.is_empty():
            raise IndexError("Queue is empty")
        return self.front.data

    def is_empty(self):
        return self.length == 0

    def size(self):
        return self.length

