package ch12.examples;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ModuleDescriptorExamplesTest {

    @Test
    void descriptorsContainKeyElements() {
        String descriptor = ModuleDescriptorExamples.zooModuleDescriptor();
        assertTrue(descriptor.contains("module zoo.animal.feeding"));
        assertTrue(descriptor.contains("exports"));
        assertTrue(ModuleDescriptorExamples.servicesDescriptor().get(0).contains("uses"));
        assertTrue(ModuleDescriptorExamples.servicesDescriptor().get(1).contains("provides"));
    }
}
