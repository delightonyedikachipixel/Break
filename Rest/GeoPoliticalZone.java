import java.util.Scanner;

public class GeoPoliticalZone {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a Nigerian state: ");
        String userState = input.nextLine();

        boolean found = false;

        for (GeoPoliticalZone zone : GeoPoliticalZone.values()) {
            for (String state : zone.getStates()) {
                if (state.equalsIgnoreCase(userState)) {
                    System.out.println(userState + " belongs to " + zone);
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("State not found.");
        }


    }
}
