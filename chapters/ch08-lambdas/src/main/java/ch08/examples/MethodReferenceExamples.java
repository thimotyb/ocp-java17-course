package ch08.examples;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Demonstrates static, instance, and constructor method references.
 */
public final class MethodReferenceExamples {

    private MethodReferenceExamples() {
    }

    public static class Penguin {

        private final String name;

        public Penguin(String name) {
            this.name = name;
        }

        public String name() {
            return name;
        }

        public String slide(String surface) {
            return name + " slides on " + surface;
        }
    }

    public static String staticDescribe(Penguin penguin) {
        return "Penguin:" + penguin.name();
    }

    public static Function<Penguin, String> staticReference() {
        return MethodReferenceExamples::staticDescribe;
    }

    public static Function<Penguin, String> instanceReference() {
        return Penguin::name;
    }

    public static BiFunction<Penguin, String, String> arbitraryInstanceReference() {
        return Penguin::slide;
    }

    public static Supplier<Penguin> constructorReference() {
        return () -> new Penguin("Unnamed");
    }

    public static List<Penguin> createPenguins(List<String> names) {
        return names.stream().map(Penguin::new).toList();
    }
}
