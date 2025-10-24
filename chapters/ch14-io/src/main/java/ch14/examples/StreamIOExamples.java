package ch14.examples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Demonstrates classic {@code java.io} stream usage from Chapter 14, including buffered readers and
 * writers, stream copying, and classpath resource reading.
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c14.xhtml">OCP Java SE 17 Study Guide – Chapter 14: Working with I/O Streams</a>
 */
public final class StreamIOExamples {

    private StreamIOExamples() {
    }

    /** Copies one file to another using plain {@link InputStream}/{@link OutputStream} APIs. */
    public static void copyWithStreams(Path source, Path target) throws IOException {
        try (InputStream in = Files.newInputStream(source); OutputStream out = Files.newOutputStream(target)) {
            in.transferTo(out);
        }
    }

    /** Reads all lines using a {@link BufferedReader} with UTF-8 encoding. */
    public static List<String> readLines(Path path) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            return reader.lines().toList();
        }
    }

    /** Writes text lines with {@link BufferedWriter}, adding newline delimiters. */
    public static void writeLines(Path path, List<String> lines) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    /**
     * Reads a classpath resource via {@link Class#getResourceAsStream(String)} and returns its
     * contents as a single string.
     */
    public static String readFromClasspathResource(String resourceName) throws IOException {
        try (InputStream in = StreamIOExamples.class.getResourceAsStream(resourceName)) {
            if (in == null) {
                throw new IOException("Resource not found: " + resourceName);
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
                return reader.lines().reduce((a, b) -> a + "\n" + b).orElse("");
            }
        }
    }
}
