package org.abas.service;

import org.abas.constant.Constants;
import org.abas.game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("GameService class Test")
class GameServiceTest {
    @InjectMocks
    GameService gameService;
    Scanner scanner;
    @Mock
    Game game;
    @Mock
    PropertyService propertyService;

    @BeforeEach
    void setUp() {
        game = new Game();
        game.setComputerBehaviourRandom(false);
        game.setComputerBehaviour("S");
        propertyService = new PropertyService(game);
    }

    @Test
    @DisplayName("test method: startGame method user win")
    void testStartGame_UserWins() {
        String input = "R\nR\nR\nQ\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        scanner = new Scanner(inputStream);

        gameService = new GameService("Emir", scanner, game, propertyService);
        gameService.startGame();

        assertEquals(3, gameService.getUserScore());
        assertEquals(0, gameService.getComputerScore());
    }

    @Test
    @DisplayName("test method: startGame method computer win")
    void testStartGame_ComputerWins() {
        String input = "P\nP\nP\nQ\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        scanner = new Scanner(inputStream);

        gameService = new GameService("Emir", scanner, game, propertyService);
        gameService.startGame();

        assertEquals(0, gameService.getUserScore());
        assertEquals(3, gameService.getComputerScore());
    }

    @Test
    @DisplayName("test method: startGame method tie")
    void testStartGame_Tie() {
        String input = "S\nS\nS\nQ\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        scanner = new Scanner(inputStream);

        gameService = new GameService("Emir", scanner, game, propertyService);
        gameService.startGame();

        assertEquals(0, gameService.getUserScore());
        assertEquals(0, gameService.getComputerScore());
    }

    @Test
    @DisplayName("test method: startGame method quit before any move")
    void testStartGame_QuitBeforeAnyRound() {
        String input = "Q";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        scanner = new Scanner(inputStream);

        gameService = new GameService("Emir", scanner, game, propertyService);
        gameService.startGame();

        assertEquals(0, gameService.getUserScore());
        assertEquals(0, gameService.getComputerScore());
    }

    @Test
    @DisplayName("test method: startGame method with wrong value")
    void testStartGame_WrongUserValue() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(outContent));

        String input = "F\nQ\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        scanner = new Scanner(inputStream);

        gameService = new GameService("Emir", scanner, game, propertyService);
        gameService.startGame();

        assertEquals(Constants.INVALID_VALUE+"\n", outContent.toString());
    }
}