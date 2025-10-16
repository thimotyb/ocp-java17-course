package ch12.examples;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class ModuleReflectionExamplesTest {

    @Test
    void currentModuleDescriptorAccessible() {
        Module module = ModuleReflectionExamplesTest.class.getModule();
        ModuleReflectionExamples.versionOf(module);
        ModuleReflectionExamples.exportedPackages(module);
    }
}
