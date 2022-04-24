package com.mthree.c216.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

/*
    RockPaperScissors.java
    George Harland
    Last edited 24/04/2022
 */

public class RockPaperScissors {
    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);
        Random random = new Random();

        // Main game loop
        while(true) {
            int roundNum = 0;
            int playerWins = 0;
            int ties = 0;
            int computerWins = 0;

            System.out.println("How many rounds would you like to play? (1-10) ");

            // Gets user input. Must be within 1-10 or exits program
            roundNum = validateNumberInput(inputScanner, 10);
            if (roundNum < 1 || roundNum > 10) {
                break;
            }

            System.out.printf("%n%n");

            // For loop to handle each round
            for(int i=1; i<roundNum+1; i++) {
                System.out.println("Round " + i);
                System.out.printf("--------%n");

                // Player move: Gets user input. Must be within 1-3 or exits program
                System.out.println("type 1 for rock, 2 for paper, or 3 for scissors.");
                int playerMove = validateNumberInput(inputScanner, 3);
                if (playerMove < 1 || playerMove > 3) {
                    System.out.printf("%nInvalid move. the game will end with the current scores");
                    break;
                }

                // Computer move
                int computerMove = random.nextInt(3) + 1;

                // Calculate winner and return the result
                int roundResult = printResult(playerMove,computerMove);

                // Add results to totals
                if (roundResult == 0) {
                    playerWins++;
                } else if (roundResult == 1) {
                    ties++;
                } else {
                    computerWins++;
                }
            }

            // Print final results
            printFinalResults(playerWins,ties,computerWins);

            // Check if user would like to play again. Any input other than 1 quits the program
            System.out.println("Would you like to play again? (1 to play, 2 to quit)");
            int playAgain = validateNumberInput(inputScanner, 2);
            if (playAgain == 2) {
                System.out.println("Thanks for playing!");
                break;
            }
        }
    }

    private static int validateNumberInput(Scanner inputScanner, int maxNum) {
        // validates...
        int numInput = 0;

        try {
            String strInput = inputScanner.nextLine();
            numInput = Integer.parseInt(strInput);

            if (numInput < 1 || numInput > maxNum) {
                System.out.printf("That wasn't a number between 1 and %d.", maxNum);
            }
        } catch(NumberFormatException exception) {
            System.out.println(exception);
            System.out.println("Please enter a number next time.");
            return maxNum+1; // returns as a number outside the range checking if the game will continue
        }

        return numInput;
    }

    private static int printResult(int gameMove, int computerMove) {
        // Returns 0 for player win, 1 for a tie, and 2 for a computer win

        if (gameMove == computerMove) {
            System.out.println("Computer played the same.");
            System.out.printf("Result - tie!%n%n");
            return 1;
        } else if (gameMove == 1 && computerMove == 2) {
            System.out.println("Computer played paper.");
            System.out.printf("Result - Computer wins!%n%n");
            return 2;
        } else if (gameMove == 1 && computerMove == 3) {
            System.out.println("Computer played scissors.");
            System.out.printf("Result - Player wins!%n%n");
            return 0;
        } else if (gameMove == 2 && computerMove == 1) {
            System.out.println("Computer played rock.");
            System.out.printf("Result - Player wins!%n%n");
            return 0;
        } else if (gameMove == 2 && computerMove == 3) {
            System.out.println("Computer played scissors.");
            System.out.printf("Result - Computer wins!%n%n");
            return 2;
        } else if (gameMove == 3 && computerMove == 1) {
            System.out.println("Computer played rock.");
            System.out.printf("Result - Computer wins!%n%n");
            return 2;
        } else if (gameMove == 3 && computerMove == 2) {
            System.out.println("Computer played paper.");
            System.out.printf("Result - Player wins!%n%n");
            return 0;
        } else {
            // Shouldn't happen, but here in case the code changes
            System.out.printf("Invalid entry. Round skipped and result is a tie.%n%n");
            return 1;
        }
    }

    private static void printFinalResults(int playerWins, int ties, int computerWins) {
        // Prints the final results of all rounds

        System.out.printf("%n%nFINAL RESULTS:%n");
        System.out.printf("---------------%n");
        System.out.printf("Player wins:   |  %d%n",playerWins);
        System.out.printf("Ties:          |  %d%n",ties);
        System.out.printf("Computer wins: |  %d%n%n",computerWins);
        if (playerWins > computerWins) {
            System.out.printf("Player wins! Congratulations!%n%n");
        } else if (computerWins > playerWins) {
            System.out.printf("Computer wins! Unlucky!%n%n");
        } else {
            System.out.printf("Game ends in a tie!%n%n");
        }
    }

}
