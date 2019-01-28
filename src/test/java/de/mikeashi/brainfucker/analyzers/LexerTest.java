package de.mikeashi.brainfucker.analyzers;

import de.mikeashi.brainfucker.source.File;
import de.mikeashi.brainfucker.tokens.Token;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static de.mikeashi.brainfucker.tokens.Token.*;
import static org.junit.jupiter.api.Assertions.*;

class LexerTest {
    private static final String FILENAME = "hello_world_with_comments.bf";
    private static final Token[] EXPECTED = {RIGHT_SHIFT, INCREASE, INCREASE, INCREASE, INCREASE,
            INCREASE, INCREASE, INCREASE, INCREASE, RIGHT_BRACKET, DECREASE, LEFT_SHIFT, INCREASE,
            INCREASE, INCREASE, INCREASE, INCREASE, INCREASE, INCREASE, INCREASE, INCREASE, RIGHT_SHIFT,
            LEFT_BRACKET, LEFT_SHIFT, OUTPUT, RIGHT_SHIFT, RIGHT_SHIFT, INCREASE, RIGHT_SHIFT, DECREASE,
            RIGHT_BRACKET, INCREASE, LEFT_BRACKET, INCREASE, INCREASE, RIGHT_SHIFT, INCREASE, INCREASE,
            RIGHT_SHIFT, INCREASE, INCREASE, INCREASE, RIGHT_BRACKET, RIGHT_SHIFT, RIGHT_BRACKET, DECREASE,
            RIGHT_SHIFT, INCREASE, INCREASE, INCREASE, LEFT_SHIFT, LEFT_SHIFT, INCREASE, INCREASE, INCREASE,
            RIGHT_SHIFT, LEFT_BRACKET, LEFT_SHIFT, LEFT_SHIFT, LEFT_BRACKET, RIGHT_SHIFT, DECREASE, DECREASE,
            DECREASE, DECREASE, DECREASE, OUTPUT, RIGHT_SHIFT, DECREASE, RIGHT_SHIFT, INCREASE, INCREASE,
            INCREASE, OUTPUT, OUTPUT, INCREASE, INCREASE, INCREASE, OUTPUT, RIGHT_SHIFT, DECREASE, OUTPUT,
            LEFT_SHIFT, LEFT_SHIFT, INCREASE, RIGHT_BRACKET, RIGHT_SHIFT, RIGHT_BRACKET, INCREASE, RIGHT_SHIFT,
            INCREASE, LEFT_BRACKET, RIGHT_SHIFT, RIGHT_SHIFT, LEFT_BRACKET, LEFT_SHIFT, DECREASE, DECREASE,
            DECREASE, DECREASE, DECREASE, DECREASE, DECREASE, DECREASE, DECREASE, DECREASE, DECREASE, DECREASE,
            DECREASE, DECREASE, OUTPUT, RIGHT_SHIFT, RIGHT_SHIFT, OUTPUT, INCREASE, INCREASE, INCREASE, OUTPUT,
            DECREASE, DECREASE, DECREASE, DECREASE, DECREASE, DECREASE, OUTPUT, DECREASE, DECREASE, DECREASE,
            DECREASE, DECREASE, DECREASE, DECREASE, DECREASE, OUTPUT, RIGHT_SHIFT, INCREASE, OUTPUT, RIGHT_SHIFT,
            INCREASE, OUTPUT};

    private Path path;
    private File file;
    private Lexer lexer;

    @BeforeEach
    void setUp() throws URISyntaxException {
        path = Paths.get(getClass().getClassLoader().getResource(FILENAME).toURI());
        file = new File(path);
        lexer = new Lexer(file);
    }

    @Test
    void getTokens() throws IOException {
        assertArrayEquals(EXPECTED,lexer.getTokens().toArray());
    }
}