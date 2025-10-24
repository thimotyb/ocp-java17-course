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
 * Implements the Chapter 14 listings around NIO.2 file attributes, symbolic links, and filtered
 * directory traversal.
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c14.xhtml">OCP Java SE 17 Study Guide – Chapter 14: Working with Files</a>
 */
public final class Nio2AttributesExamples {

    private Nio2AttributesExamples() {
    }

    /** @return {@link FileTime} retrieved via {@link Files#getLastModifiedTime(Path, java.nio.file.LinkOption...)}. */
    public static FileTime getLastModified(Path path) throws IOException {
        return Files.getLastModifiedTime(path);
    }

    /** Sets last-modified time using {@link Files#setLastModifiedTime(Path, FileTime)}. */
    public static void setLastModified(Path path, FileTime time) throws IOException {
        Files.setLastModifiedTime(path, time);
    }

    /** @return whether the path is a symbolic link. */
    public static boolean isSymbolicLink(Path path) {
        return Files.isSymbolicLink(path);
    }

    /**
     * Walks a file tree while skipping hidden directories, mirroring the book's filtering example.
     */
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

    /** @return root directories from the default file system. */
    public static Iterable<Path> rootDirectories() {
        return FileSystems.getDefault().getRootDirectories();
    }
}
