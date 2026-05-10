package OopReflections;


public class Church {
    private String name;
    private String denomination;
    private int capacity;
    private String address;
    private double totalDonations;

    public Church(String name, String denomination, int capacity, String address) {
        this.name           = name;
        this.denomination   = denomination;
        this.capacity       = capacity;
        this.address        = address;
        this.totalDonations = 0.0;
    }

    public void holdService(String day) {
        System.out.println(name + " (" + denomination + ") is holding service on " + day + ".");
    }

    public void holdService() {
        holdService("Sunday");
    }

    public void acceptDonation(double amount, String donor) {
        totalDonations += amount;
        System.out.println(name + " received N" + amount + " from " + donor
                + ". Total so far: N" + totalDonations);
    }

    public void acceptDonation(double amount) {
        acceptDonation(amount, "Anonymous");
    }

    public String getName()           { return name; }
    public String getDenomination()   { return denomination; }
    public int getCapacity()          { return capacity; }
    public String getAddress()        { return address; }
    public double getTotalDonations() { return totalDonations; }

    @Override
    public String toString() {
        return "Church '" + name + "' — " + denomination;
    }
}
