package org.abas.service;

import org.abas.constant.Constants;
import org.abas.game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DisplayName("PropertyService class Test")
class PropertyServiceTest {
    @InjectMocks
    private PropertyService propertyService;

    @Mock
    private Game mockGame;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("test method: computerIsReady method random computer behaviour")
    void testComputerIsReady_RandomBehavior() {
        when(mockGame.getComputerBehaviour()).thenReturn(Constants.RANDOM);
        when(mockGame.isComputerBehaviourRandom()).thenReturn(true);

        boolean result = propertyService.computerIsReady(Constants.APP_PROPERTIES);

        assertTrue(result);
    }

    @Test
    @DisplayName("test method: computerIsReady method is not ready since property is not exist")
    void testComputerIsNotReady_ErrorReadingPropertiesFile() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(outContent));

        boolean result = propertyService.computerIsReady("wrong_file_name");

        assertFalse(result);
        assertEquals(Constants.INVALID_FILE+"\n", outContent.toString());
    }

    @Test
    @DisplayName("test method: computerIsReady method is not ready since computer behaviour is null")
    void testComputerIsNotReady_NullComputerBehaviour() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(outContent));

        when(mockGame.getComputerBehaviour()).thenReturn(null);

        boolean result = propertyService.computerIsReady(Constants.APP_PROPERTIES);

        assertFalse(result);
        assertEquals(Constants.INVALID_COMPUTER_BEHAVIOUR+"\n", outContent.toString());
    }

    @Test
    @DisplayName("test method: computerIsReady method is not ready since wrong computer behaviour")
    void testComputerIsNotReady_InvalidComputerBehaviour() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(outContent));

        when(mockGame.getComputerBehaviour()).thenReturn("T");

        boolean result = propertyService.computerIsReady(Constants.APP_PROPERTIES);

        assertFalse(result);
        assertEquals(Constants.INVALID_COMPUTER_BEHAVIOUR+"\n", outContent.toString());
    }

}
