import java.util.Scanner;

public class CaeserCipher {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        System.out.println("Enter text:");
        String text = input.nextLine().toUpperCase();

        System.out.println("Enter shift number:");
        int shiftNumber = input.nextInt();

        String result = "";

        for (int counter = 0; counter < text.length(); counter++) {
            char letter = text.charAt(counter);
            if (letter >= 'a' && letter <= 'z' ){
                letter = (char) (letter + shiftNumber);
                if (letter > 'z'){
                    letter = (char) (letter - 26);

}

                
}
            else if (letter >= 'A' && letter <= 'Z'){
                letter = (char) (letter + shiftNumber);
              if (letter > 'Z'){
                letter = (char) (letter - 26);


}



}



    result = result + letter;
                      
        }

     System.out.println("Encrypted text: " + result);
    

        
    }
}
