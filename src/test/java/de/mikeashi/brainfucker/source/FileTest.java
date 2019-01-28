package de.mikeashi.brainfucker.source;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {
    private static final String FILENAME = "hello_world.bf";
    private static final int[] EXPECTED = {62, 43, 43, 43, 43, 43, 43, 43, 43, 91, 45, 60, 43, 43, 43, 43,
            43, 43, 43, 43, 43, 62, 93, 60, 46, 62, 62, 43, 62, 45, 91, 43, 93, 43, 43, 62, 43, 43, 62, 43,
            43, 43, 91, 62, 91, 45, 62, 43, 43, 43, 60, 60, 43, 43, 43, 62, 93, 60, 60, 93, 62, 45, 45, 45,
            45, 45, 46, 62, 45, 62, 43, 43, 43, 46, 46, 43, 43, 43, 46, 62, 45, 46, 60, 60, 43, 91, 62, 91,
            43, 62, 43, 93, 62, 62, 93, 60, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 46, 62,
            62, 46, 43, 43, 43, 46, 45, 45, 45, 45, 45, 45, 46, 45, 45, 45, 45, 45, 45, 45, 45, 46, 62, 43,
            46, 62, 43, 46};
    private Path path;
    private File file;

    @BeforeEach
    void setUp() throws URISyntaxException {
        path = Paths.get(getClass().getClassLoader().getResource(FILENAME).toURI());
        file = new File(path);
    }

    @Test
    void getCharacterStream() throws IOException {
        assertArrayEquals(EXPECTED,file.getCharacterStream().toArray());
    }
}