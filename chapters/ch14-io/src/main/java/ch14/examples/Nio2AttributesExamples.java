package ch14.examples;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates file attributes and walking.
 */
public final class Nio2AttributesExamples {

    private Nio2AttributesExamples() {
    }

    public static FileTime getLastModified(Path path) throws IOException {
        return Files.getLastModifiedTime(path);
    }

    public static void setLastModified(Path path, FileTime time) throws IOException {
        Files.setLastModifiedTime(path, time);
    }

    public static boolean isSymbolicLink(Path path) {
        return Files.isSymbolicLink(path);
    }

    public static List<Path> walkWithFilter(Path root) throws IOException {
        List<Path> list = new ArrayList<>();
        Files.walkFileTree(root, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                if (dir.getFileName().toString().startsWith(".")) {
                    return FileVisitResult.SKIP_SUBTREE;
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                list.add(file);
                return FileVisitResult.CONTINUE;
            }
        });
        return list;
    }

    public static Iterable<Path> rootDirectories() {
        return FileSystems.getDefault().getRootDirectories();
    }
}
