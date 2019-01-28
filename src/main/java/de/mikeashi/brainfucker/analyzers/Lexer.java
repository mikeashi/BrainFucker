package de.mikeashi.brainfucker.analyzers;

import de.mikeashi.brainfucker.source.File;
import de.mikeashi.brainfucker.tokens.Token;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * lexical analyser which can get tokens from file ignoring non-Bf operations .
 *
 * @author Mike Ashi
 */
public class Lexer {
    // the source file
    private final File file;

    /**
     * Creates a new Lexer instance.
     *
     * @param file the source file.
     */
    public Lexer(File file) {
        this.file = file;
    }

    /**
     * @return a stream of Tokens.
     * @throws IOException if an I/O error occurs opening the file.
     */
    public Stream<Token> getTokens() throws IOException {
        return file.getCharacterStream()
                .mapToObj(Token::getToken)
                .filter(token -> token != null);
    }
}
