package de.mikeashi.brainfucker.tokens;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Tokens enum this enum provides a way to get
 * enums values and the correct enum for the value.
 * @author Mike Ashi
 */
public enum Token {
    // BF operations
    RIGHT_SHIFT('>'), LEFT_SHIFT('<'), INCREASE('+'),
    DECREASE('-'), OUTPUT('.'), INPUT(','),
    RIGHT_BRACKET('['), LEFT_BRACKET(']');

    // (char,Token) map
    private static final Map<Character, Token> CHARACTER_TOKEN_MAP =
            Arrays.stream(Token.values()).collect(Collectors.toMap(Token::getCharacter, token -> token));

    private final char character;

    Token(char character) {
        this.character = character;
    }

    /**
     * @return the value of an enum
     */
    public char getCharacter() {
        return character;
    }

    /**
     * @param character bf operation char.
     * @return the token for the given char.
     */
    public static Token getToken(char character) {
        return CHARACTER_TOKEN_MAP.get(character);
    }
    /**
     * @param character bf operation UTF-8 decoded character.
     * @return the token for the given char.
     */
    public static Token getToken(int character) {
        return getToken((char) character);
    }
}
