package de.mikeashi.brainfucker.tokens;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TokenTest {
    @Test
    void getTokenFromChar() {
        assertEquals(Token.RIGHT_SHIFT,Token.getToken('>'));
        assertEquals(Token.LEFT_SHIFT,Token.getToken('<'));
        assertEquals(Token.INCREASE,Token.getToken('+'));
        assertEquals(Token.DECREASE,Token.getToken('-'));
        assertEquals(Token.INPUT,Token.getToken(','));
        assertEquals(Token.OUTPUT,Token.getToken('.'));
        assertEquals(Token.RIGHT_BRACKET,Token.getToken('['));
        assertEquals(Token.LEFT_BRACKET,Token.getToken(']'));
    }
    @Test
    void getTokenFromInt() {
        assertEquals(Token.RIGHT_SHIFT,Token.getToken(62));
        assertEquals(Token.LEFT_SHIFT,Token.getToken(60));
        assertEquals(Token.INCREASE,Token.getToken(43));
        assertEquals(Token.DECREASE,Token.getToken(45));
        assertEquals(Token.INPUT,Token.getToken(44));
        assertEquals(Token.OUTPUT,Token.getToken(46));
        assertEquals(Token.RIGHT_BRACKET,Token.getToken(91));
        assertEquals(Token.LEFT_BRACKET,Token.getToken(93));
    }
}