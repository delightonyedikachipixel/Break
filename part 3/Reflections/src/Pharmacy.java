public class Pharmacy {
    private String name;
    private String licenceNo;
    private boolean isOpen;
    private String[] stock;
    private int stockCount;

    public Pharmacy(String name, String licenceNo) {
        this.name       = name;
        this.licenceNo  = licenceNo;
        this.isOpen     = true;
        this.stock      = new String[100];
        this.stockCount = 0;
    }

    public void addStock(String drugName) {
        if (stockCount < stock.length) {
            stock[stockCount] = drugName;
            stockCount++;
            System.out.println("Added '" + drugName + "' to " + name + ".");
        } else {
            System.out.println("Stock full at " + name + ".");
        }
    }

    public void sellDrug(String drugName) {
        if (!isOpen) {
            System.out.println(name + " is currently closed.");
            return;
        }
        for (int druCounter = 0; druCounter < stockCount; druCounter++) {
            if (stock[druCounter] != null && stock[druCounter].equalsIgnoreCase(drugName)) {
                stock[druCounter] = null;
                System.out.println("Dispensed '" + drugName + "' from " + name + ".");
                return;
            }
        }
        System.out.println("'" + drugName + "' is not available at " + name + ".");
    }

    public void checkStock() {
        System.out.println("\n" + name + " current stock:");
        boolean hasItems = false;
        for (int stockCount = 0; stockCount < this.stockCount; stockCount++) {
            if (stock[stockCount] != null) {
                System.out.println("  - " + stock[stockCount]);
                hasItems = true;
            }
        }
        if (!hasItems) {
            System.out.println("  (empty)");
        }
    }

    public void open()  { isOpen = true;  System.out.println(name + " is now open.");  }
    public void close() { isOpen = false; System.out.println(name + " is now closed."); }

    public String getName()      { return name; }
    public String getLicenceNo() { return licenceNo; }
    public boolean isOpen()      { return isOpen; }

    @Override
    public String toString() {
        return "Pharmacy '" + name + "' (Licence: " + licenceNo + ")";
    }
}