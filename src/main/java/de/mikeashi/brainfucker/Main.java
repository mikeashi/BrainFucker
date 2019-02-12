package de.mikeashi.brainfucker;

import de.mikeashi.brainfucker.analyzers.Lexer;
import de.mikeashi.brainfucker.analyzers.SyntaxAnalyzer;
import de.mikeashi.brainfucker.interpreter.Interpreter;
import de.mikeashi.brainfucker.source.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path currentWorkingDirectory = Paths.get(".").toAbsolutePath().normalize();

        if (args.length == 0) {
            throw new IllegalStateException("Expected the Brainfuck source file as first argument.");
        }

        String sourceFileString = args[0];
        Path sourceFile = currentWorkingDirectory.resolve(sourceFileString);

        if (!Files.exists(sourceFile)) {
            throw new IllegalStateException("The source file does not exist.");
        }

        File file = new File(sourceFile);
        Lexer lexer = new Lexer(file);
        try {
            SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer(lexer.getTokens());
            Interpreter interpreter = new Interpreter(syntaxAnalyzer.getAST());
            interpreter.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
