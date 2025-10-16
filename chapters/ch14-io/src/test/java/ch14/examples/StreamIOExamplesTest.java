package ch14.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Test;

class StreamIOExamplesTest {

    @Test
    void writeReadAndCopyStreams() throws IOException {
        Path tempDir = Files.createTempDirectory("io-stream");
        Path source = tempDir.resolve("source.txt");
        List<String> lines = List.of("alpha", "beta");
        StreamIOExamples.writeLines(source, lines);
        assertEquals(lines, StreamIOExamples.readLines(source));
        Path target = tempDir.resolve("target.txt");
        StreamIOExamples.copyWithStreams(source, target);
        assertEquals(lines, Files.readAllLines(target));
    }
}
