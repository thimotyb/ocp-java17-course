package ch12.examples;

import java.nio.file.Path;
import java.util.List;

/**
 * Captures examples of module path resolution and readability.
 */
public final class ModulePathExamples {

    private ModulePathExamples() {
    }

    public static List<String> runtimeResolution() {
        return List.of(
            "java --module-path mods -m zoo.staff/zoo.staff.CaretakerSchedule",
            "java --module-path mods:libs -m zoo.visitor/zoo.visitor.Tour" );
    }

    public static List<String> moduleCompilerCommands() {
        return List.of(
            "javac --module-path mods -d feeding mods-source/zoo.animal.feeding/module-info.java mods-source/zoo.animal.feeding/zoo/animal/feeding/*.java",
            "jar --create --file zoo.animal.feeding.jar -C feeding ."
        );
    }

    public static Path modulePathExample() {
        return Path.of("mods", "zoo.animal.feeding.jar");
    }
}
