public class Map {

    private String[] keys;
    private String[] values;
    private int      size;

    public Map() {
        keys   = new String[10];
        values = new String[10];
        size   = 0;
    }


    public void put(String key, String value) {

        for (int index = 0; index < size; index++) {
            if (keys[index].equals(key)) {
                values[index] = value;
                return;
            }
        }

        keys[size]   = key;
        values[size] = value;
        size++;
    }


    public String get(String key) {
        for (int indexx = 0; indexx < size; indexx++) {
            if (keys[indexx].equals(key)) {
                return values[indexx];
            }
        }
        return null;
    }


    public boolean remove(String key) {
        for (int count = 0; count < size; count++) {
            if (keys[count].equals(key)) {

                for (int counter = count; counter < size - 1; counter++) {
                    keys[counter]   = keys[counter + 1];
                    values[counter] = values[counter + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }


    public boolean containsKey(String key) {
        for (int index = 0; index < size; index++) {
            if (keys[index].equals(key)) return true;
        }
        return false;
    }


    public String[] keySet() {
        String[] result = new String[size];
        for (int index = 0; index < size; index++) {
            result[index] = keys[index];
        }
        return result;
    }

    public int size() { return size; }
}
