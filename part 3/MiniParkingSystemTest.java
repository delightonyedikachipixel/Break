import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;




public class MiniParkingSystemTest {

    @Test
    public void testCarIsParkedSuccessfully() {
        MiniParkingSystem lot = new MiniParkingSystem();
        lot.initialize(20);

        boolean result = lot.parkCar(1);
        assertTrue(result);
    }

    @Test
    public void testCannotParkInAnOccupiedSpot() {
        MiniParkingSystem lot = new MiniParkingSystem();
        lot.initialize(1);

        lot.parkCar(1);
        boolean result = lot.parkCar(2);
        assertFalse(result);
    }

    @Test
    public void testCarIsRemoved() {
        MiniParkingSystem lot = new MiniParkingSystem();
        lot.initialize(20);

        lot.parkCar(1);
        boolean result = lot.removeCar(1);
        assertTrue(result);
    }

    @Test
    public void testCannotRemoveCarFromEmptySpot() {
        MiniParkingSystem lot = new MiniParkingSystem();
        lot.initialize(20);

        boolean result = lot.removeCar(1);
        assertFalse(result);
    }

    @Test
    public void testCheckParkingSpacesAvailability() {
        MiniParkingSystem lot = new MiniParkingSystem();
        lot.initialize(20);

        lot.parkCar(1);
        lot.parkCar(2);
        lot.parkCar(3);
        lot.parkCar(4);
        lot.parkCar(5);
        lot.parkCar(6);

        int available = lot.totalSpaces - lot.occupiedSpaces; 
        assertEquals(14, available); 
    }
}
