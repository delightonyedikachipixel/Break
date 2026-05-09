import java.util.Scanner;

public class CreditCardValidator {
    private String cardNumber;

    public CreditCardValidator(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        int firstTwo = Integer.parseInt(cardNumber.substring(0, 2));

        if (firstTwo >= 51 && firstTwo <= 55)
            return "MasterCard";

        if (cardNumber.startsWith("4"))
            return "Visa";

        if (cardNumber.startsWith("37") || cardNumber.startsWith("34"))
            return "American Express";

        if (cardNumber.startsWith("6"))
            return "Discover";

        return "Unknown";
    }

    public int getDigitLength() {
        return cardNumber.length();
    }

    public boolean isValid() {
        int sum = 0;

        for (int index = cardNumber.length() - 1; index >= 0; index--) {
            int digit = Character.getNumericValue(cardNumber.charAt(index));

            if ((cardNumber.length() - 1 - index) % 2 != 0) {
                digit *= 2;
                if (digit > 9) digit -= 9;
            }

            sum += digit;
        }

        return sum % 10 == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter credit card number: ");
        String input = scanner.nextLine();

        CreditCardValidator validator = new CreditCardValidator(input);

        System.out.println("***************************************");
        System.out.println("**Credit Card Type: " + validator.getCardType());
        System.out.println("**Credit Card Number: " + validator.cardNumber);
        System.out.println("**Credit Card Digit Length: " + validator.getDigitLength());
        System.out.println("**Credit Card Validity Status: " + (validator.isValid() ? "Valid" : "Invalid"));
        System.out.println("*******************************************");
    }
}