package ch14.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Test;

class FileSystemExamplesTest {

    @Test
    void createCopyMoveAndWalk() throws IOException {
        Path tempDir = Files.createTempDirectory("io-test");
        Path source = FileSystemExamples.createTempFileWithContent("source", ".txt", "hello");
        Path copy = tempDir.resolve("copy.txt");
        FileSystemExamples.copyFile(source, copy);
        assertTrue(Files.exists(copy));
        Path moved = tempDir.resolve("moved.txt");
        FileSystemExamples.moveFile(copy, moved);
        assertTrue(Files.exists(moved));
        List<Path> visited = FileSystemExamples.walkDirectory(tempDir);
        assertEquals(1, visited.size());
    }
}
