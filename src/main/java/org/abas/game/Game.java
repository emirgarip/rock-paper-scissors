package org.abas.game;

/**
 * The Game class represents the configuration of the Rock-Paper-Scissors game.
 * It holds information about the computer's behavior and its move selection mode.
 */
public class Game {
    private boolean isComputerBehaviourRandom = true;
    private String computerBehaviour;

    /**
     * Checks if the computer's behavior is set to random move selection mode.
     *
     * @return true if the computer's behavior is set to random mode, false otherwise.
     */
    public boolean isComputerBehaviourRandom() {
        return isComputerBehaviourRandom;
    }

    /**
     * Sets the computer's behavior to either random move selection mode or specific move mode.
     *
     * @param computerBehaviourRandom true to set the computer's behavior to random mode,
     *                                false to set it to specific move mode.
     */
    public void setComputerBehaviourRandom(boolean computerBehaviourRandom) {
        isComputerBehaviourRandom = computerBehaviourRandom;
    }

    /**
     * Gets the computer's behavior in specific move selection mode.
     *
     * @return The computer's behavior in specific move selection mode as a String.
     */
    public String getComputerBehaviour() {
        return computerBehaviour;
    }

    /**
     * Sets the computer's behavior in specific move selection mode.
     *
     * @param computerBehaviour The computer's behavior in specific move selection mode as a String.
     */
    public void setComputerBehaviour(String computerBehaviour) {
        this.computerBehaviour = computerBehaviour;
    }
}
