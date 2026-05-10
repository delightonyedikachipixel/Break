public class House {
    private String address;
    private int numberOfRooms;
    private String owner;
    private boolean hasGate;
    private Car parkedCar;

    public House(String address, int numRooms, String owner, boolean hasGate) {
        this.address  = address;
        this.numberOfRooms = numberOfRooms;
        this.owner    = owner;
        this.hasGate  = hasGate;
    }

    public void openDoor() {
        System.out.println("Front door of " + address + " is now open.");
    }

    public void parkCar(Car car) {
        if (hasGate) {
            this.parkedCar = car;
            System.out.println(car + " has been parked at " + address + ".");
        } else {
            System.out.println("No gate — street parking only.");
        }
    }


    public String getAddress()  { return address; }
    public String getOwner()    { return owner; }
    public int getNumberOfRooms()    { return numberOfRooms; }
    public Car getParkedCar()   { return parkedCar; }

    @Override
    public String toString() {
        return "House at " + address + " owned by " + owner;
    }
}
