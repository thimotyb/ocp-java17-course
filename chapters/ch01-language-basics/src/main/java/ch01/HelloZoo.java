package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Demonstrates how to use ProcessBuilder from a classic main entry point.
 */
public final class HelloZoo {

    private static final List<String> COMMANDS = List.of("javac", "java", "jar", "javadoc");

    private HelloZoo() {
    }

    public static void main(String[] args) {
        resolveCommandPaths().forEach((command, path) ->
            System.out.printf("%s -> %s%n", command, path)
        );
    }

    static Map<String, String> resolveCommandPaths() {
        Map<String, String> result = new LinkedHashMap<>();
        for (String command : COMMANDS) {
            result.put(command, locate(command));
        }
        return result;
    }

    private static String locate(String command) {
        boolean windows = System.getProperty("os.name").toLowerCase().contains("win");
        ProcessBuilder builder = windows
                ? new ProcessBuilder("cmd", "/c", "where", command)
                : new ProcessBuilder("which", command);
        try {
            Process process = builder.start();
            String output = readAll(process.getInputStream());
            String error = readAll(process.getErrorStream());
            int exitCode = process.waitFor();
            if (exitCode == 0 && !output.isBlank()) {
                return collapseWhitespace(output.trim());
            }
            if (!error.isBlank()) {
                return "NOT_FOUND: " + collapseWhitespace(error.trim());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "INTERRUPTED";
        } catch (IOException e) {
            return "ERROR: " + e.getMessage();
        }
        return "NOT_FOUND";
    }

    private static String readAll(java.io.InputStream stream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }

    private static String collapseWhitespace(String value) {
        return value.replaceAll("\\s+", " ");
    }
}
