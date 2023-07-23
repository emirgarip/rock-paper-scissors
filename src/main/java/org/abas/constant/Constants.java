package org.abas.constant;

/**
 * A utility class containing constants used in the Rock-Paper-Scissors game.
 * It includes values for system exit, app properties file, computer behavior, and victory message.
 */
public class Constants {

    private Constants(){}
    public static final String SYSTEM_EXIT="Q";
    public static final String APP_PROPERTIES = "app.properties";
    public static final String COMPUTER_BEHAVIOUR = "computerBehaviour";
    public static final String COMPUTER_WON = "Computer won!";
    public static final String RANDOM = "Random";
    public static final String INVALID_VALUE = "Invalid Move! R Rock, P Paper, S Scissors, Q quit, please try again.";
    public static final String INVALID_FILE = "Check your property file!";
    public static final String INVALID_COMPUTER_BEHAVIOUR = "Computer behavior not specified in properties file!";

}
