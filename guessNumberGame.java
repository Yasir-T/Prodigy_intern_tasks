import java.util.Scanner;
import java.util.Random;
public class guessNumberGame {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();

            int secretNumber = random.nextInt(101); // Generate a random number between 1 and 100
            int attempts = 0;

            System.out.println("Welcome to the Guessing Game!");
            System.out.println("I have selected a random number between 1 and 100. Try to guess it!");

            while (true) {
                try{
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else if (guess > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number " + secretNumber + " correctly!");
                    System.out.println("It took you " + attempts + " attempts to win the game.");
                    break;
                }}
                 catch (Exception e){
                        System.out.println("enter integer numbers only, try again with INTEGER Number...");
                        break;
                }
            }

            scanner.close();
        }
    }
