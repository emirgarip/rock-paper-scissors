package org.abas.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Move Enum Test")
class MoveTest {

    @Test
    @DisplayName("test method: findByValue with valid moves")
    void testFindByValue_ValidMove() {
        assertEquals(Move.ROCK, Move.findByValue("R"));
        assertEquals(Move.PAPER, Move.findByValue("P"));
        assertEquals(Move.SCISSOR, Move.findByValue("S"));
    }

    @Test
    @DisplayName("test method: findByValue with invalid moves")
    void testFindByValue_InvalidMove() {
        assertNull(Move.findByValue("X"));
        assertNull(Move.findByValue("random"));
        assertNull(Move.findByValue(""));
    }

    @Test
    @DisplayName("test method: randomMove")
    void testRandomMove() {
        Move randomMove = Move.randomMove();
        assertNotNull(randomMove);
        assertTrue(randomMove == Move.ROCK || randomMove == Move.PAPER || randomMove == Move.SCISSOR);
    }
}