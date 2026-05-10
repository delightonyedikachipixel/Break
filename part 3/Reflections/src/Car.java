public class Car {
    private String make;
    private String model;
    private String colour;
    private double speed;

    public Car(String make, String model, String colour) {
        this.make   = make;
        this.model  = model;
        this.colour = colour;
        this.speed  = 0.0;
    }

    public void drive(double speed) {
        this.speed = speed;
        System.out.printf("%s %s %s is driving at %.1f km/h.%n",
                colour, make, model, this.speed);
    }

    public void honk() {
        System.out.printf("%s %s goes: Beep beep!%n", make, model);
    }


    public String getMake()   { return make; }
    public String getModel()  { return model; }
    public String getColour() { return colour; }
    public double getSpeed()  { return speed; }

    @Override
    public String toString() {
        return colour + " " + make + " " + model;
    }
}
