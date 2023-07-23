package org.abas.main;

import org.abas.game.Game;
import org.abas.service.GameService;
import org.abas.service.PropertyService;

import java.util.Scanner;

/**
 * The Main class is the entry point of the Rock-Paper-Scissors game application.
 * It handles user input, initializes the game, and displays the final scores and results.
 */
public class Main {

    /**
     * The main method of the Rock-Paper-Scissors game application.
     * It prompts the user to enter their username, initializes the game,
     * and starts the game loop until the user decides to quit.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        System.out.println("Rules: R Rock, P Paper, S Scissors, Q quit");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.nextLine();
        Game game = new Game();
        PropertyService propertyService = new PropertyService(game);

        GameService gameService = new GameService(username, scanner, game, propertyService);
        gameService.startGame();

        System.out.println("Final Scores:");
        System.out.println(username + ": " + gameService.getUserScore());
        System.out.println("Computer: " + gameService.getComputerScore());
        if (gameService.getUserScore() > gameService.getComputerScore()) {
            System.out.println("Congrats!");
        } else if (gameService.getComputerScore() > gameService.getUserScore()) {
            System.out.println("Maybe Next Time!");
        } else {
            System.out.println("Tie!");
        }

        scanner.close();
    }
}