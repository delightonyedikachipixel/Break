import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ACTest{

    @Test
    public void testThatAirConditionerIsOn (){
        AirConditioner airConditioner = new AirConditioner();
        airConditioner.turnOn();
        boolean expectedState = true;
        boolean actualState = airConditioner.isOn();
        assertEquals(expectedState, actualState);
    }

    @Test
    public void testThatAirConditionerIsOff (){
        AirConditioner airConditioner = new AirConditioner();
        airConditioner.turnOff();
        boolean expectedState = false;
        boolean actualState = airConditioner.isOn();
        assertEquals(expectedState, actualState);
    }

    @Test
    public void testThatTemperatureCanBeIncreased(){
        AirConditioner airConditioner = new AirConditioner();
        airConditioner.turnOn();
        airConditioner.increaseTemperature();
        int expectedTemperature = 17;
        int actualTemperature = airConditioner.getTemperature();
        assertEquals(expectedTemperature, actualTemperature);
    }

    @Test
    public void testThatWhenAirConditionerIsOnItIsAt16(){
    AirConditioner airconditioner = new AirConditioner();
    airConditioner .turnOn();
    int expectedTemperature = 16;
    int actualTemperature = airConditioner.getTemperature();
    assertEquals(expectedTemperature, actualTemperature);
    }

}

    @Test
    public void testThatTemperatureCanBeDecreased(){
        AirConditioner airConditioner = new AirConditioner();
        airConditioner.turnOn();
        airConditioner.decreaseTemperature();
        int expectedTemperature = 16;
        int actualTemperature = airConditioner.getTemperature();
        assertEquals(expectedTemperature, actualTemperature);
    }

    @Test
    public void testThatTemperatureCannotGoAbove30(){
        AirConditioner airConditioner = new AirConditioner();
        airConditioner.turnOn();
        for (int count = 0; count < 15; count++){
            airConditioner.increaseTemperature();
        }
        int expectedTemperature = 30;
        int actualTemperature = airConditioner.getTemperature();
        assertEquals(expectedTemperature, actualTemperature);
    }

    @Test 
    public void testThatTemperatureCannotGoBelow16(){
        AirConditioner airConditioner = new AirConditioner();
        airConditioner.turnOn();
        airConditioner.decreaseTemperature();
        int expectedTemperature = 16;
        int actualTemperature = airConditioner.getTemperature();
        assertEquals(expectedTemperature, actualTemperature);
    }




    @Test
    public void testThatIfAirConditionerIsTurnedOffItIsAt0(){
        AirConditioner airConditioner = new AirConditioner();
        airConditioner.turnOff();
        int expectedTemperature = 0;
        int actualTemperature = airConditioner.getTemperature();
        assertEquals(expectedTemperature, actualTemperature);





}
}
