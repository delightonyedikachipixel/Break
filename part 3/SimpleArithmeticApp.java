// get random numbers 
// declare variables 
// no negative numbers as result
// generate my first numbers from 51 to 100
//generate second numbers from 1 to 50
//print welcome 
// 10 questions must be taken
// generate correct answer
//  ask to subtract the second number from the first number
// 2 trials on each question
// if you fail the number again after 2 attempts move to the next number
//calculate number of passes
// subtract the numbers
// calculate and display number of fail and pass


import java.util.Random;
import java.util.Scanner;

public class SimpleArithmeticApp {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int correctCount = 0;
        int failCount = 0;
        int numberOfAttempts = 2;

        System.out.println("Welcome to Simple Arithmetic App");

        int[] firstNumber = new int[10];
        int[] secondNumber = new int[10];


        for (int counter = 0; counter < 10; counter++) {
            firstNumber[counter] = random.nextInt(51,100) ; 
            secondNumber[counter] = random.nextInt(1,50) ; 
        }

        for (int count = 0; count < 10; count++) {
            int attempts = 0;
            int correctAnswer = firstNumber[count] - secondNumber[count];

            System.out.println("Question " + (count + 1) + ": " + firstNumber[count] + " - " + secondNumber[count] + " = ?");

                   
            while (attempts < numberOfAttempts) {
                System.out.print("Your answer: ");
                int userAnswer = scanner.nextInt();

                if (userAnswer == correctAnswer) {
                    System.out.println("Correct!");
                    correctCount++;
                    break;
                } else {
                    attempts++;
                    System.out.println("Wrong!");

                    if (attempts == numberOfAttempts) {
                        System.out.println("The correct answer is " + correctAnswer);
                        failCount++;
                    }
                }
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Correct: " + correctCount);
        System.out.println("Total Failed: " + failCount);

        
    }
}
