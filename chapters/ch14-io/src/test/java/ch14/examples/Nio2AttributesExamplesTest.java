package ch14.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.List;

import org.junit.jupiter.api.Test;

class Nio2AttributesExamplesTest {

    @Test
    void getAndSetLastModifiedTime() throws IOException {
        Path file = Files.createTempFile("attr", ".txt");
        java.nio.file.attribute.FileTime now = java.nio.file.attribute.FileTime.from(Instant.now());
        Nio2AttributesExamples.setLastModified(file, now);
        assertEquals(now, Nio2AttributesExamples.getLastModified(file));
    }

    @Test
    void walkWithFilterSkipsHidden() throws IOException {
        Path root = Files.createTempDirectory("walk");
        Path hiddenDir = Files.createDirectory(root.resolve(".hidden"));
        Files.createTempFile(root, "visible", ".txt");
        Files.createTempFile(hiddenDir, "skip", ".txt");
        List<Path> visited = Nio2AttributesExamples.walkWithFilter(root);
        for (Path path : visited) {
            assertFalse(path.getFileName().toString().startsWith("."));
        }
    }

    @Test
    void rootDirectoriesPresent() {
        assertTrue(Nio2AttributesExamples.rootDirectories().iterator().hasNext());
    }
}
