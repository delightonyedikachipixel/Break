package OopReflections;


public class YamSeller extends RoadSideSeller {
    private String yamType;
    private int sackCount;

    public YamSeller(String sellerName, String location,
                     double pricePerUnit, String yamType, int sackCount) {
        super(sellerName, location, pricePerUnit);
        this.yamType   = yamType;
        this.sackCount = sackCount;
    }

    public void gradeYam() {
        System.out.println(getSellerName() + " is grading " + yamType
                + " yams — " + sackCount + " sack(s) available.");
    }

    @Override
    public void sell(String item, int quantity) {
        double total = pricePerUnit * quantity;
        System.out.println(getSellerName() + " sold " + quantity
                + " tuber(s) of " + yamType + " yam for N" + total + ".");
    }

    public String getYamType()  { return yamType; }
    public int getSackCount()   { return sackCount; }

    @Override
    public String toString() {
        return "YamSeller '" + getSellerName() + "' — " + yamType + " yam";
    }
}
