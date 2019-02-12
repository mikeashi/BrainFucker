package de.mikeashi.brainfucker.interpreter;

import de.mikeashi.brainfucker.analyzers.Lexer;
import de.mikeashi.brainfucker.analyzers.SyntaxAnalyzer;
import de.mikeashi.brainfucker.io.printer.output;
import de.mikeashi.brainfucker.io.reader.Reader;
import de.mikeashi.brainfucker.io.reader.input;
import de.mikeashi.brainfucker.source.File;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class InterpreterTest {
    private static final String FILENAME = "hello_world_with_comments.bf";
    private Path path;
    private File file;
    private Lexer lexer;
    private SyntaxAnalyzer syntaxAnalyzer;
    private  Reader reader;
    private  Printer printer;
    private  Interpreter interpreter;
    @BeforeEach
    void setUp() throws IOException, URISyntaxException {
        path = Paths.get(getClass().getClassLoader().getResource(FILENAME).toURI());
        file = new File(path);
        lexer = new Lexer(file);
        syntaxAnalyzer = new SyntaxAnalyzer(lexer.getTokens());
        reader = new Reader();
        printer = new Printer();
        interpreter = new Interpreter(printer,reader,syntaxAnalyzer.getAST());
    }

    @Test
    void execute() {
        interpreter.execute();
        assertEquals("Hello World!\n",printer.getOutput());
    }

    private class Printer implements output{
        private String s="";
        @Override
        public void print(char c) {
            s+= c;
        }
        public String getOutput() {
            return s;
        }
    }
}