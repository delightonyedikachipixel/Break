import java.util.Scanner;

public class MiniParkingSystem {

     int totalSpaces;
    int occupiedSpaces;

    
    public void initialize(int space) {
        totalSpaces = space;
        occupiedSpaces = 0;
    }

   
    public boolean parkCar(int carNumber) {
        if (occupiedSpaces < totalSpaces) {
            occupiedSpaces++;
            return true;
        }
        return false;
    }

    
    public boolean removeCar(int carNumber) {
        if (occupiedSpaces > 0) {
            occupiedSpaces--;
            return true;
        }
        return false;
    }

    
    public int checkAvailability() {
        return totalSpaces - occupiedSpaces;
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your car number: ");
        int carNumber = scanner.nextInt();

        System.out.print("Enter your preferred parking space between 1 and 20: ");
        int parkingSpace = scanner.nextInt();

        int totalSpaces = 20;

        if (parkingSpace < 1 || parkingSpace > totalSpaces) {
            System.out.println("Invalid choice");
            return;
        }

        System.out.println("\n" + name + "!");

        MiniParkingSystem lot = new MiniParkingSystem();
        lot.initialize(totalSpaces);

        boolean result = lot.parkCar(carNumber);

        if (!result) {
            System.out.println("Parking failed");
        } else {
            System.out.println("Car parked successfully in space " + parkingSpace);
        }
    }
}
