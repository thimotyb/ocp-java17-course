package ch01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class HelloZooTest {

    @Test
    void resolvesCommandPathsUsingProcessBuilder() {
        Map<String, String> paths = HelloZoo.resolveCommandPaths();
        assertEquals(4, paths.size());
        assertTrue(paths.keySet().containsAll(List.of("javac", "java", "jar", "javadoc")));
        paths.forEach((command, path) -> assertNotNull(path, command + " should have a value"));
        assertFalse(paths.values().stream().allMatch(value -> value.startsWith("NOT_FOUND")),
                "At least one tool should be located on the PATH");
    }
}
