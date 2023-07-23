package org.abas.service;

import org.abas.constant.Constants;
import org.abas.enums.Move;
import org.abas.game.Game;

import java.util.Scanner;

/**
 * The GameService class manages the Rock-Paper-Scissors game logic and user interactions.
 * It tracks the user's and computer's scores and handles the game rounds until the user decides to quit.
 */
public class GameService {

    private int userScore = 0;
    private int computerScore = 0;
    private final String username;
    private final Scanner scanner;
    private final PropertyService propertyService;
    private final Game game;
    private Move userMove;

    /**
     * Constructs a new GameService object with the provided user details, game, and property service.
     *
     * @param username        The username of the user playing the game.
     * @param scanner         The Scanner object used to read user input.
     * @param game            The Game object representing the game state.
     * @param propertyService The PropertyService object for managing properties and computer behavior.
     */
    public GameService(String username, Scanner scanner, Game game, PropertyService propertyService) {
        this.username = username;
        this.scanner = scanner;
        this.game = game;
        this.propertyService = propertyService;
    }

    /**
     * Starts the Rock-Paper-Scissors game by reading user input for moves,
     * calculating the game results, and updating scores until the user decides to quit.
     */
    public void startGame() {
        if (propertyService.computerIsReady(Constants.APP_PROPERTIES)) {
            while (checkMove(scanner) != null) {
                Move computerMove = getComputerMove();
                System.out.println(username + ": " + userMove.name() + " Computer: " + computerMove.name());
                calculate(userMove, computerMove);
            }
        }
    }

    /**
     * Calculates the result of the Rock-Paper-Scissors game round based on the user's and computer's moves.
     * Updates the scores accordingly.
     *
     * @param userMove     The move selected by the user.
     * @param computerMove The move randomly generated for the computer or specified in the properties file.
     */
    private void calculate(Move userMove, Move computerMove) {
        if (userMove.equals(computerMove)) {
            System.out.println("Its a tie!");
        } else if ((userMove.equals(Move.ROCK) && computerMove.equals(Move.SCISSOR))
                || (userMove.equals(Move.PAPER) && computerMove.equals(Move.ROCK))
                || (userMove.equals(Move.SCISSOR) && computerMove.equals(Move.PAPER))) {
            System.out.println(username + " won!");
            userScore++;
        } else {
            System.out.println(Constants.COMPUTER_WON);
            computerScore++;
        }
    }

    /**
     * Retrieves the computer's move based on its behavior (random or specified).
     *
     * @return The computer's move (Rock, Paper, or Scissors).
     */
    private Move getComputerMove() {
        if (game.isComputerBehaviourRandom()) {
            return Move.randomMove();
        } else {
            return Move.findByValue(game.getComputerBehaviour());
        }
    }

    /**
     * Reads and validates the user's move input until a valid move is entered.
     *
     * @param scanner The Scanner object used to read user input.
     * @return The user's selected move (Rock, Paper, or Scissors) or null if the user decides to quit.
     */
    private Move checkMove(Scanner scanner) {
        do {
            System.out.println(username + ": ");
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase(Constants.SYSTEM_EXIT)) {
                return null;
            } else {
                userMove = Move.findByValue(userInput);
                if (userMove == null) {
                    System.err.println(Constants.INVALID_VALUE);
                }
            }
        } while (userMove == null);
        return userMove;
    }

    /**
     * Retrieves the user's current score.
     *
     * @return The user's score.
     */
    public int getUserScore() {
        return userScore;
    }

    /**
     * Retrieves the computer's current score.
     *
     * @return The computer's score.
     */
    public int getComputerScore() {
        return computerScore;
    }
}
