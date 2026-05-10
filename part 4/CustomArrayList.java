

public class CustomArrayList {

    private Object[] elements;
    private int size;

    public CustomArrayList() {
        elements = new Object[10];
        size = 0;
    }

    public void add(T element) {
        ensureCapacity();
        elements[size] = element;
        size++;
    }

    public void add(int index, T element) {
        validateIndexForAdd(index);

        ensureCapacity();

        for (int count = size; count > index; count--) {
            elements[count] = elements[count - 1];
        }

        elements[index] = element;
        size++;
    }

    public T get(int index) {
        validateIndex(index);
        return (T) elements[index];
    }

    public void set(int index, T element) {
        validateIndex(index);
        elements[index] = element;
    }

    public T remove(int index) {
        validateIndex(index);

        T removed = (T) elements[index];

        for (int counter = index; counter < size - 1; counter++) {
            elements[counter] = elements[counter + 1];
        }

        elements[size - 1] = null;
        size--;

        return removed;
    }

    public boolean contains(T element) {
        for (int find = 0; find < size; find++) {
            if (elements[find].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(T element) {
        for (int index = 0; index < size; index++) {
            if (elements[index].equals(element)) {
                return index;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int count = 0; count < size; count++) {
            elements[count] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == elements.length) {

            Object[] newArray = new Object[elements.length * 2];

            for (int counter = 0; counter < elements.length; counter++) {
                newArray[counter] = elements[counter];
            }

            elements = newArray;
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }

    private void validateIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
    }
}
