package ch12.examples;

import java.nio.file.Path;
import java.util.List;

/**
 * Collects command-line and {@code Path} examples from Chapter 12 "Building Modules" that illustrate
 * compilation, packaging, and runtime resolution with the module path.
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c12.xhtml">OCP Java SE 17 Study Guide – Chapter 12: Building Modules</a>
 */
public final class ModulePathExamples {

    private ModulePathExamples() {
    }

    /**
     * @return sample {@code java --module-path ...} commands showing how to launch modules
     */
    public static List<String> runtimeResolution() {
        return List.of(
            "java --module-path mods -m zoo.staff/zoo.staff.CaretakerSchedule",
            "java --module-path mods:libs -m zoo.visitor/zoo.visitor.Tour" );
    }

    /**
     * @return {@code javac} and {@code jar} commands that mirror the compilation steps in the chapter
     */
    public static List<String> moduleCompilerCommands() {
        return List.of(
            "javac --module-path mods -d feeding mods-source/zoo.animal.feeding/module-info.java mods-source/zoo.animal.feeding/zoo/animal/feeding/*.java",
            "jar --create --file zoo.animal.feeding.jar -C feeding ."
        );
    }

    /**
     * @return path pointing to a module artifact, emphasising module-path directory layouts
     */
    public static Path modulePathExample() {
        return Path.of("mods", "zoo.animal.feeding.jar");
    }
}
