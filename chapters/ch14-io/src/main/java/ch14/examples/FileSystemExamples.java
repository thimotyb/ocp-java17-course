package ch14.examples;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates java.nio.file APIs from Chapter 14.
 */
public final class FileSystemExamples {

    private FileSystemExamples() {
    }

    public static Path createTempFileWithContent(String prefix, String suffix, String content) throws IOException {
        Path path = Files.createTempFile(prefix, suffix);
        Files.writeString(path, content);
        return path;
    }

    public static Path resolveSibling(Path path, String sibling) {
        return path.resolveSibling(sibling);
    }

    public static List<String> listDirectory(Path dir) throws IOException {
        List<String> entries = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path entry : stream) {
                entries.add(entry.getFileName().toString());
            }
        }
        return entries;
    }

    public static void copyFile(Path source, Path target) throws IOException {
        Files.copy(source, target);
    }

    public static void moveFile(Path source, Path target) throws IOException {
        Files.move(source, target);
    }

    public static List<Path> walkDirectory(Path root) throws IOException {
        List<Path> visited = new ArrayList<>();
        Files.walkFileTree(root, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                visited.add(file);
                return FileVisitResult.CONTINUE;
            }
        });
        return visited;
    }
}
