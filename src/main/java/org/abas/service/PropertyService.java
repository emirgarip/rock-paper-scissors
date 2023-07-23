package org.abas.service;

import org.abas.constant.Constants;
import org.abas.enums.Move;
import org.abas.game.Game;

import java.io.InputStream;
import java.util.Properties;

/**
 * The PropertyService class manages reading and handling properties related to the Rock-Paper-Scissors game.
 * It reads the app properties file, sets the computer's behavior, and verifies if the computer is ready to play.
 */
public class PropertyService {
    private Game game;

    /**
     * Constructs a new PropertyService object with the provided Game object.
     *
     * @param game The Game object representing the game state.
     */
    public PropertyService (Game game) {
        this.game = game;
    }

    /**
     * Checks if the computer is ready to play the Rock-Paper-Scissors game based on the properties file.
     *
     * @param fileName The name of the properties file containing the computer's behavior.
     * @return true if the computer is ready to play; false otherwise.
     */
    public boolean computerIsReady(String fileName) {
        Properties properties = readPropertiesFile(fileName);
        if (!properties.isEmpty()) {
            game.setComputerBehaviour(properties.getProperty(Constants.COMPUTER_BEHAVIOUR));
            if (game.getComputerBehaviour() == null || game.getComputerBehaviour().trim().isEmpty()) {
                System.err.println(Constants.INVALID_COMPUTER_BEHAVIOUR);
                return false;
            }
            if (game.getComputerBehaviour().equals(Constants.RANDOM)) {
                return true;
            }
            Move move = Move.findByValue(game.getComputerBehaviour());
            if (move == null) {
                System.err.println(Constants.INVALID_COMPUTER_BEHAVIOUR);
                return false;
            }
            game.setComputerBehaviourRandom(false);
            return true;
        }
        return false;
    }

    /**
     * Reads the app properties file to retrieve the computer's behavior.
     *
     * @param fileName The name of the properties file.
     * @return The Properties object containing the properties from the file.
     */
    private static Properties readPropertiesFile(String fileName) {
        Properties properties = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream stream = loader.getResourceAsStream(fileName)) {
            properties.load(stream);
        } catch (Exception e) {
            System.err.println(Constants.INVALID_FILE);
        }
        return properties;
    }
}
