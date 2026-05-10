package OopReflections;

public class PhoneCaseSeller extends RoadSideSeller {
    private String brand;
    private String caseStyle;

    public PhoneCaseSeller(String sellerName, String location,
                           double pricePerUnit, String brand, String caseStyle) {
        super(sellerName, location, pricePerUnit);
        this.brand     = brand;
        this.caseStyle = caseStyle;
    }

    public void displayCases() {
        System.out.println(getSellerName() + " is displaying "
                + caseStyle + " cases for " + brand + " phones.");
    }

    @Override
    public void sell(String item, int quantity) {
        double total = pricePerUnit * quantity;
        System.out.println(getSellerName() + " sold " + quantity
                + " " + brand + " '" + caseStyle + "' case(s) for N" + total + ".");
    }

    public String getBrand()     { return brand; }
    public String getCaseStyle() { return caseStyle; }

    @Override
    public String toString() {
        return "PhoneCaseSeller '" + getSellerName() + "' — " + brand + " " + caseStyle;
    }
}
