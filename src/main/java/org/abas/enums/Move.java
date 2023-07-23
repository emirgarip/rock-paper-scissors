package org.abas.enums;

import java.util.Random;

/**
 * An enum representing the three possible moves in the Rock-Paper-Scissors game.
 * Each move has a corresponding value ("R" for Rock, "P" for Paper, "S" for Scissors).
 * Provides utility methods for generating random moves and finding a move by its value.
 */
public enum Move {
    ROCK("R"),
    PAPER("P"),
    SCISSOR("S");

    private final String value;

    private static final Random random = new Random();

    Move(String value) {
        this.value = value;
    }

    public static Move randomMove()  {
        Move[] move = values();
        return move[random.nextInt(move.length)];
    }

    public static Move findByValue(String value) {
        Move result = null;
        for (Move move : values()) {
            if (move.value.equalsIgnoreCase(value)) {
                result = move;
                break;
            }
        }
        return result;
    }
}
