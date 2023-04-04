 
/*import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int randomNumber = (int) (Math.random() * 100) + 1; // generate a random number between 1 and 100
        int guess;
        int count = 0;
        
        System.out.println("I'm thinking of a number between 1 and 100. Guess what it is!");
        
        do {
            System.out.print("Enter your guess: ");
            guess = input.nextInt();
            count++;
             if (guess < 0|| guess >100) {
                System.out.println("Invalid input");
             } 
             else if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > randomNumber) {
                System.out.println("Too high! Try again.");
            }
        } while (guess != randomNumber);
        
        System.out.println("Congratulations! You guessed the number in " + count + " tries.");
    }
}*/
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int targetNumber = rand.nextInt(100) + 1;
        int numGuesses = 0;
        boolean hasWon = false;

        System.out.println("Guess the number between 1 and 100.");
        Scanner input = new Scanner(System.in);

        while (numGuesses < 10) {
            System.out.print("Guess #" + (numGuesses + 1) + ": ");
            int guess = input.nextInt();
            numGuesses++;

            if (guess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else if (guess > targetNumber) {
                System.out.println("Too high! Try again.");
            } else {
                hasWon = true;
                break;
            }
        }

        if (hasWon) {
            System.out.println("Congratulations! You guessed my number in " + numGuesses + " guesses!");
        } else {
            System.out.println("Sorry, you didn't guess my number. It was " + targetNumber + ".");
        }
    }
}
