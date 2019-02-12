package de.mikeashi.brainfucker.analyzers;

import de.mikeashi.brainfucker.exceptions.InvalidSyntaxException;
import de.mikeashi.brainfucker.source.File;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;



import static org.junit.jupiter.api.Assertions.assertThrows;

class SyntaxAnalyzerTest {

    @Test
    public void testInvalidJumpBack() throws Exception {
        Path path = Paths.get(getClass().getClassLoader().getResource("invalid-syntax-jump-back.bf").toURI());
        File file = new File(path);
        Lexer lexicalAnalyzer = new Lexer(file);
        SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer(lexicalAnalyzer.getTokens());
        assertThrows(InvalidSyntaxException.class, syntaxAnalyzer::getAST);
    }
}