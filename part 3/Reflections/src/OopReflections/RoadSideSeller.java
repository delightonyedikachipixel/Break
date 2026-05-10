package OopReflections;

import java.util.ArrayList;
import java.util.List;

public abstract class RoadSideSeller {
    private String sellerName;
    private String location;
    protected double pricePerUnit;
    protected List<String> produce;

    public RoadSideSeller(String sellerName, String location, double pricePerUnit) {
        this.sellerName   = sellerName;
        this.location     = location;
        this.pricePerUnit = pricePerUnit;
        this.produce      = new ArrayList<>();
    }


    public abstract void sell(String item, int quantity);

    public void bargain(double offer) {
        double floor = pricePerUnit * 0.85;
        if (offer >= floor) {
            pricePerUnit = offer;
            System.out.printf("Deal! %s accepts $%.2f per unit.%n", sellerName, offer);
        } else {
            System.out.printf("No deal. %s won't go below ₦%.2f per unit.%n",
                    sellerName, floor);
        }
    }


    public String getSellerName()   { return sellerName; }
    public String getLocation()     { return location; }
    public double getPricePerUnit() { return pricePerUnit; }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " '" + sellerName + "' at " + location;
    }
}



