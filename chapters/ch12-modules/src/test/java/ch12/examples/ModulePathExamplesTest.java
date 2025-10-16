package ch12.examples;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ModulePathExamplesTest {

    @Test
    void runtimeCommandsShowModuleExecution() {
        assertTrue(ModulePathExamples.runtimeResolution().get(0).contains("--module-path"));
        assertTrue(ModulePathExamples.moduleCompilerCommands().get(0).startsWith("javac"));
        assertTrue(ModulePathExamples.modulePathExample().toString().contains("mods"));
    }
}
