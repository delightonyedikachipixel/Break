public class MyQueue {

    private static int[] queue;
    private static int front;
    private static int rear;
    private static int size;

    public static void createQueue(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public static boolean empty() {
        return size == 0;
    }


    public static void enqueue(int value) {
        if (size == queue.length) {
            throw new IllegalStateException("Queue is full");
        }

        queue[rear] = value;
        rear = (rear + 1) % queue.length;
        size++;
    }


    public static int dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }

        int value = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return value;
    }


    public static boolean add(int value) {
        if (size == queue.length) {
            throw new IllegalStateException("Queue is full");
        }
        enqueue(value);
        return true;
    }


    public static boolean offer(int value) {
        if (size == queue.length) {
            return false;
        }
        enqueue(value);
        return true;
    }


    public static int element() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }


    public static int peek() {
        if (size == 0) {
            return -1;
        }
        return queue[front];
    }


    public static int remove() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return dequeue();
    }


    public static int poll() {
        if (size == 0) {
            return -1;
        }
        return dequeue();
    }
}
