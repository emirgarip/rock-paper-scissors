package org.abas.main;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Main class Test")
class MainTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("test method: main method user win")
    void testMain_UserWins() {
        String input = "Emir\nR\nR\nQ\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);
        String expectedOutput = "Rules: R Rock, P Paper, S Scissors, Q quit\n" +
                "Enter username:\n" +
                "Emir: \n" +
                "Emir: ROCK Computer: SCISSOR\n" +
                "Emir won!\n" +
                "Emir: \n" +
                "Emir: ROCK Computer: SCISSOR\n" +
                "Emir won!\n" +
                "Emir: \n" +
                "Final Scores:\n" +
                "Emir: 2\n" +
                "Computer: 0\n" +
                "Congrats!\n";

        Main.main(new String[0]);

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("test method: main method computer win")
    void testMain_ComputerWins() {
        String input = "Emir\nP\nP\nQ\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);

        String expectedOutput = "Rules: R Rock, P Paper, S Scissors, Q quit\n" +
                "Enter username:\n" +
                "Emir: \n" +
                "Emir: PAPER Computer: SCISSOR\n" +
                "Computer won!\n" +
                "Emir: \n" +
                "Emir: PAPER Computer: SCISSOR\n" +
                "Computer won!\n" +
                "Emir: \n" +
                "Final Scores:\n" +
                "Emir: 0\n" +
                "Computer: 2\n" +
                "Maybe Next Time!\n";

        Main.main(new String[0]);

        assertEquals(expectedOutput, outContent.toString());
    }

}
