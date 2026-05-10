package neighbourhood;

public class ProvisionStore {
    private String name;
    private String location;
    private boolean isOpen;
    private String[] items;
    private int itemCount;

    public ProvisionStore(String name, String location) {
        this.name      = name;
        this.location  = location;
        this.isOpen    = true;
        this.items     = new String[50];
        this.itemCount = 0;
    }

    public void restock(String item) {
        if (itemCount < items.length) {
            items[itemCount] = item;
            itemCount++;
            System.out.println("Restocked '" + item + "' at " + name + ".");
        } else {
            System.out.println("Storage full at " + name + ".");
        }
    }

    public void sellItem(String item) {
        if (!isOpen) {
            System.out.println(name + " is closed.");
            return;
        }
        for (int itemCounter = 0; itemCounter < itemCount; itemCounter++) {
            if (items[itemCounter] != null && items[itemCounter].equalsIgnoreCase(item)) {
                items[itemCounter] = null;
                System.out.println("Sold '" + item + "' from " + name + ".");
                return;
            }
        }
        System.out.println("Sorry, '" + item + "' is out of stock at " + name + ".");
    }

    public void open()  { isOpen = true;  System.out.println(name + " is now open.");  }
    public void close() { isOpen = false; System.out.println(name + " is now closed."); }

    public String getName()     { return name; }
    public String getLocation() { return location; }
    public boolean isOpen()     { return isOpen; }

    @Override
    public String toString() {
        return "ProvisionStore '" + name + "' at " + location;
    }
}
