package NubanGenerator;

    public class NubanGenerator {

        public static String generateNuban(String bankCode, String accountSerial) {
            if (bankCode.length() != 3 || accountSerial.length() != 9) {
                throw new IllegalArgumentException("Bank code must be 3 digits and account serial 9 digits.");
            }

            String base = bankCode + accountSerial;
            int[] weights = {3,7,3,3,7,3,3,7,3,3,7,3};
            int sum = 0;

            for (int index = 0; index < base.length(); index++) {
                int digit = Character.getNumericValue(base.charAt(index));
                sum += digit * weights[index];
            }

            int checkDigit = 10 - (sum % 10);
            if (checkDigit == 10) checkDigit = 0;

            return accountSerial + checkDigit;
        }

      
    }






