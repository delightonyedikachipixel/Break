

public class SinglyLinkedList {

    private Node head;

    public SinglyLinkedList() {
        head = null;
    }

    public void append(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public void prepend(int value) {

        Node newNode = new Node(value);

        newNode.next = head;

        head = newNode;
    }

    public void insertAt(int index, int value) {

        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        if (index == 0) {
            prepend(value);
            return;
        }

        Node newNode = new Node(value);

        Node current = head;

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        newNode.next = current.next;

        current.next = newNode;
    }

    public int search(int value) {

        Node current = head;

        int index = 0;

        while (current != null) {

            if (current.data == value) {
                return index;
            }

            current = current.next;

            index++;
        }

        return -1;
    }

    public int size() {

        int count = 0;

        Node current = head;

        while (current != null) {

            count++;

            current = current.next;
        }

        return count;
    }

    public void reverse() {

        Node prev = null;

        Node current = head;

        while (current != null) {

            Node nextNode = current.next;

            current.next = prev;

            prev = current;

            current = nextNode;
        }

        head = prev;
    }

    public int[] toList() {

        int[] result = new int[size()];

        Node current = head;

        int index = 0;

        while (current != null) {

            result[index] = current.data;

            current = current.next;

            index++;
        }

        return result;
    }
}
