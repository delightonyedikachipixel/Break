import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BikeTest {

    private Bike bike;

    @BeforeEach
    void setUp() {
        bike = new Bike();
    }    @Test
    void bikeShouldStartWithEngineOff() {
        assertFalse(bike.isEngineOn());
    }

    @Test
    void bikeShouldStartWithSpeedZero() {
        assertEquals(0, bike.getCurrentSpeed());
    }

    @Test
    void bikeShouldStartInGearOne() {
        assertEquals(1, bike.getCurrentGear());
    }



    @Test
    void turningOnBikeShouldSetEngineToOn() {
        bike.turnOn();
        assertTrue(bike.isEngineOn());
    }

    @Test
    void turningOffBikeShouldResetSpeedToZero() {
        bike.turnOn();
        bike.accelerate();

        bike.turnOff();

        assertFalse(bike.isEngineOn());
        assertEquals(0, bike.getCurrentSpeed());
    }


    @Test
    void accelerateWhenBikeIsOffShouldThrowException() {
        assertThrows(IllegalStateException.class, () -> bike.accelerate());
    }

    @Test
    void decelerateWhenBikeIsOffShouldThrowException() {
        assertThrows(IllegalStateException.class, () -> bike.decelerate());
    }



    @Test
    void gearOneAccelerationShouldIncreaseSpeedByOne() {
        bike.turnOn();

        bike.accelerate();

        assertEquals(1, bike.getCurrentSpeed());
    }

    @Test
    void gearOneDecelerationShouldDecreaseSpeedByOne() {
        bike.turnOn();

        bike.accelerate();
        bike.decelerate();

        assertEquals(0, bike.getCurrentSpeed());
    }

    @Test
    void speed21ShouldSwitchToGearTwo() {
        bike.turnOn();

        for (int accelerationStep = 0; accelerationStep < 21; accelerationStep++) {
            bike.accelerate();
        }

        assertEquals(2, bike.getCurrentGear());
    }

    @Test
    void gearTwoShouldIncreaseSpeedByTwo() {
        bike.turnOn();

        for (int speedIncreaseStep = 0; speedIncreaseStep < 21; speedIncreaseStep++) {
            bike.accelerate();
        }

        int before = bike.getCurrentSpeed();

        bike.accelerate();

        assertEquals(before + 2, bike.getCurrentSpeed());
    }

    @Test
    void gearTwoDecelerationShouldDecreaseSpeedByTwo() {
        bike.turnOn();

        for (int speedIncreaseStep = 0; speedIncreaseStep < 22; speedIncreaseStep++) {
            bike.accelerate();
        }
        int before = bike.getCurrentSpeed();

        bike.decelerate();

        assertEquals(before - 2, bike.getCurrentSpeed());
    }


    @Test
    void speed31ShouldSwitchToGearThree() {
        bike.turnOn();

        for (int speedIncreaseStep = 0; speedIncreaseStep < 31; speedIncreaseStep++) {
            bike.accelerate();
        }

        assertEquals(3, bike.getCurrentGear());
    }

    @Test
    void gearThreeShouldIncreaseSpeedByThree() {
        bike.turnOn();

        for (int speedIncreaseStep = 0; speedIncreaseStep < 31; speedIncreaseStep++) {
            bike.accelerate();
        }

        int before = bike.getCurrentSpeed();

        bike.accelerate();

        assertEquals(before + 3, bike.getCurrentSpeed());
    }


    @Test
    void speed41ShouldSwitchToGearFour() {
        bike.turnOn();

        for (int speedIncreaseStep = 0; speedIncreaseStep < 41; speedIncreaseStep++) {
            bike.accelerate();
        }

        assertEquals(4, bike.getCurrentGear());
    }

    @Test
    void gearFourShouldIncreaseSpeedByFour() {
        bike.turnOn();

        for (int speedIncreaseStep = 0; speedIncreaseStep < 41; speedIncreaseStep++) {
            bike.accelerate();
        }

        int before = bike.getCurrentSpeed();

        bike.accelerate();

        assertEquals(before + 4, bike.getCurrentSpeed());
    }



    @Test
    void gearShouldDowngradeWhenSpeedDrops() {
        bike.turnOn();

        for (int speedIncreaseStep = 0; speedIncreaseStep < 21; speedIncreaseStep++) {
            bike.accelerate();
        }

        assertEquals(2, bike.getCurrentGear());

        bike.decelerate();

        assertEquals(1, bike.getCurrentGear());
    }

    @Test
    void speedShouldNeverGoBelowZero() {
        bike.turnOn();

        bike.decelerate();

        assertEquals(0, bike.getCurrentSpeed());
    }
}