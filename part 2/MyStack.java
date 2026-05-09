import java.util.ArrayList;

public class MyStack {

    public static ArrayList<Integer> createStack() {
        return new ArrayList<>();
    }

    public static void push(ArrayList<Integer> stack, int value) {
        stack.add(value);
    }

    public static Integer pop(ArrayList<Integer> stack) {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.remove(stack.size() - 1);
    }

    public static Integer peek(ArrayList<Integer> stack) {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.get(stack.size() - 1);
    }

    public static int search(ArrayList<Integer> stack, int value) {
        for (int indexFromTop = stack.size() - 1, positionFromTop = 1;
             indexFromTop >= 0;
             indexFromTop--, positionFromTop++) {

            if (stack.get(indexFromTop) == value) {
                return positionFromTop;
            }
        }
        return -1; 
    }

    public static boolean empty(ArrayList<Integer> stack) {
        return stack.isEmpty();
    }
}
