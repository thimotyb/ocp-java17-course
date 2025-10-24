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
 * Demonstrates the {@code java.nio.file} operations discussed in Chapter 14 "Working with Files" as
 * part of the I/O API coverage. Methods include file creation, copying/moving, directory listing, and
 * walking the file tree.
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c14.xhtml">OCP Java SE 17 Study Guide – Chapter 14: Working with Files</a>
 */
public final class FileSystemExamples {

    private FileSystemExamples() {
    }

    /**
     * @return path to a temporary file populated with the supplied content.
     */
    public static Path createTempFileWithContent(String prefix, String suffix, String content) throws IOException {
        Path path = Files.createTempFile(prefix, suffix);
        Files.writeString(path, content);
        return path;
    }

    /** Resolves a sibling path using {@link Path#resolveSibling(String)}. */
    public static Path resolveSibling(Path path, String sibling) {
        return path.resolveSibling(sibling);
    }

    /**
     * @return file names in the directory via {@link DirectoryStream}, matching the directory-iteration
     *     example.
     */
    public static List<String> listDirectory(Path dir) throws IOException {
        List<String> entries = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path entry : stream) {
                entries.add(entry.getFileName().toString());
            }
        }
        return entries;
    }

    /** Copies a file using {@link Files#copy(Path, Path, java.nio.file.CopyOption...)}. */
    public static void copyFile(Path source, Path target) throws IOException {
        Files.copy(source, target);
    }

    /** Moves or renames a file using {@link Files#move(Path, Path, java.nio.file.CopyOption...)}. */
    public static void moveFile(Path source, Path target) throws IOException {
        Files.move(source, target);
    }

    /**
     * Traverses a directory tree using {@link Files#walkFileTree(Path, java.nio.file.FileVisitor)} and
     * collects visited file paths.
     */
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
