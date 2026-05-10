package OopReflections;

public class TomatoeSeller extends RoadSideSeller {
    private String tomatoeType;
    private int basketCount;

    public TomatoeSeller(String sellerName, String location,
                        double pricePerUnit, String tomatoType, int basketCount) {
        super(sellerName, location, pricePerUnit);
        this.tomatoeType  = tomatoType;
        this.basketCount = basketCount;
    }

    public void sortTomatoes() {
        System.out.println(getSellerName() + " is sorting " + tomatoeType
                + " tomatoes — " + basketCount + " basket(s) ready.");
    }

    @Override
    public void sell(String item, int quantity) {
        double total = pricePerUnit * quantity;
        System.out.println(getSellerName() + " sold " + quantity
                + " basket(s) of " + tomatoeType + " tomatoes for N" + total + ".");
    }

    public String getTomatoType() { return tomatoeType; }
    public int getBasketCount()   { return basketCount; }

    @Override
    public String toString() {
        return "TomatoeSeller '" + getSellerName() + "' — " + tomatoeType + " tomatoes";
    }
}