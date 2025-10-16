# Chapter 14 – I/O

## Learning Objectives
- Traverse and manipulate the file system using `java.nio.file` APIs.
- Read, write, copy, and move files using buffered and stream-based I/O.
- Inspect and modify file attributes, walk file trees, and work with symbolic links.
- Serialize and deserialize objects safely.

## Chapter Summary
### NIO.2 Basics
- `Path` represents platform-independent file paths. Resolve siblings, parents, and children with `resolve`, `resolveSibling`, and `relativize`.
- Use `Files` for high-level operations: `copy`, `move`, `delete`, `createFile`, `createDirectories`.
- `DirectoryStream` and `Files.walkFileTree()` allow lazy and recursive traversal.

### Streams and Readers/Writers
- Use `InputStream`/`OutputStream` and `Reader`/`Writer` classes for byte and character I/O, respectively.
- Buffered streams (`BufferedReader`, `BufferedWriter`) improve performance by reducing disk access.

### Attributes and Metadata
- `Files.getLastModifiedTime`, `Files.setLastModifiedTime`, `Files.isSymbolicLink` manage metadata.
- `BasicFileAttributes` and `PosixFileAttributes` provide rich attribute information.

### Serialization
- Serialize objects with `ObjectOutputStream` and restore with `ObjectInputStream`. Mark fields `transient` to skip them.
- Ensure `serialVersionUID` compatibility across versions.

## Practical Exercises
1. **Recursive Delete** – Implement a file visitor that deletes an entire directory tree safely.
2. **File Watching** – Use `WatchService` to monitor directory changes.
3. **Custom Serializer** – Implement `Externalizable` for fine-grained serialization control.
4. **Channel I/O** – Copy large files efficiently using `FileChannel.transferTo`.
5. **Path Relativization** – Country-specific path manipulations using `relativize` and `normalize`.

## Run the Examples
```bash
# Ensure Java 17 is active
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk use java 17.0.14-tem

# Compile the Chapter 14 module
mvn -pl chapters/ch14-io compile

# Run the demo
java -cp chapters/ch14-io/target/classes ch14.examples.Chapter14Demo

# Execute the tests
mvn -pl chapters/ch14-io -Dtest='ch14.examples.*Test' test
```

## Exam Prep (1Z0-829 style)
1. Which method reads all lines of a file as a `List<String>`?
   - A. `Files.lines(path)`
   - B. `Files.newBufferedReader(path)`
   - C. `Files.readAllLines(path)`
   - D. `Files.readString(path)`
2. What does `Files.copy` do when the target exists by default?
   - A. Overwrites the target
   - B. Throws `FileAlreadyExistsException`
   - C. Appends to the target
   - D. Truncates the target
3. How do you walk a file tree?
   - A. `Files.walkFileTree(start, visitor)`
   - B. `Files.list(start)`
   - C. `Files.walk(start)`
   - D. `Files.traverse(start)`
4. Which stream classes are used for object serialization?
   - A. `BufferedOutputStream`
   - B. `ObjectOutputStream` and `ObjectInputStream`
   - C. `PrintWriter`
   - D. `DataInputStream`
5. What does `Path.resolveSibling("file")` do?
   - A. Moves the path
   - B. Returns a path in the same directory with the specified name
   - C. Deletes the file's sibling
   - D. Creates a symbolic link

<details>
<summary>Answers</summary>
1: C  
2: B  
3: A  
4: B  
5: B  
</details>

## Next Steps
- Explore non-blocking I/O with NIO channels and selectors.
- Combine I/O with concurrency for efficient file processing pipelines.
