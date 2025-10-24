package ch12.examples;

/**
 * Simple driver that prints the Chapter 12 module descriptor and reflection examples.
 */
public final class Chapter12Demo {

    private Chapter12Demo() {
    }

    public static void main(String[] args) {
        System.out.println("Sample module descriptor:\n" + ModuleDescriptorExamples.zooModuleDescriptor());
        System.out.println("Runtime command: " + ModulePathExamples.runtimeResolution().get(0));
        Module module = Chapter12Demo.class.getModule();
        System.out.println("Current module exports: " + ModuleReflectionExamples.exportedPackages(module));
    }
}
