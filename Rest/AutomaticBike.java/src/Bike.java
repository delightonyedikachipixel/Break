public class Bike {
    private boolean engineOn;
    private int currentSpeed;

    public Bike() {
        this.engineOn = false;
        this.currentSpeed = 0;
    }

    public void turnOn() {
        engineOn = true;
    }

    public void turnOff() {
        engineOn = false;
        currentSpeed = 0;
    }

    public boolean isEngineOn() {
        return engineOn;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public int getCurrentGear() {
        if (currentSpeed <= 20) return 1;
        else if (currentSpeed <= 30) return 2;
        else if (currentSpeed <= 40) return 3;
        else return 4;
    }

    public void accelerate() {
        if (!engineOn) {
            throw new IllegalStateException("Bike is off");
        }

        int currentGear = getCurrentGear();

        switch (currentGear) {
            case 1 -> currentSpeed += 1;
            case 2 -> currentSpeed += 2;
            case 3 -> currentSpeed += 3;
            case 4 -> currentSpeed += 4;
        }
    }

    public void decelerate() {
        if (!engineOn) {
            throw new IllegalStateException("Bike is off");
        }

        int currentGear = getCurrentGear();

        switch (currentGear) {
            case 1 -> currentSpeed -= 1;
            case 2 -> currentSpeed -= 2;
            case 3 -> currentSpeed -= 3;
            case 4 -> currentSpeed -= 4;
        }

        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
    }
}