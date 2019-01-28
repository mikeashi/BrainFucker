package de.mikeashi.brainfucker.source;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.IntStream;

/**
 * This class represent a source file that can be read by the lexical analyser.
 *
 * @author Mike Ashi
 */
public class File {
    // the source file path
    private final Path path;

    /**
     * Creates a new File instance.
     *
     * @param path the source file path.
     */
    public File(Path path) {
        this.path = path;
    }

    /**
     * Read all characters from the file as a {@code IntStream}.
     * Characters from the file are decoded into int.
     *
     * @return the characters from the file as a {@code IntStream}.
     * @throws IOException if an I/O error occurs opening the file.
     */
    public IntStream getCharacterStream() throws IOException {
        return Files.lines(path, StandardCharsets.UTF_8)
                .flatMapToInt(CharSequence::chars);
    }
}
