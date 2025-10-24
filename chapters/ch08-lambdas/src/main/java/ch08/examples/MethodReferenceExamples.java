package ch08.examples;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Showcases the four flavours of method references from Chapter 8 "Working with Method References".
 * The helper methods return preconfigured references so readers can see how each form compiles and
 * behaves.
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c08.xhtml">OCP Java SE 17 Study Guide – Chapter 8: Working with Method References</a>
 */
public final class MethodReferenceExamples {

    private MethodReferenceExamples() {
    }

    /**
     * Sample domain type used across the chapter listings to demonstrate bound/unbound references.
     */
    public static class Penguin {

        private final String name;

        public Penguin(String name) {
            this.name = name;
        }

        /**
         * @return penguin name used by the instance method reference examples
         */
        public String name() {
            return name;
        }

        /**
         * @param surface description of the medium to illustrate unbound instance references
         * @return formatted string combining the penguin name and surface
         */
        public String slide(String surface) {
            return name + " slides on " + surface;
        }
    }

    /**
     * Simple static helper used both directly and via {@link #staticReference()} to demonstrate the
     * {@code Class::staticMethod} form.
     */
    public static String staticDescribe(Penguin penguin) {
        return "Penguin:" + penguin.name();
    }

    /**
     * @return a method reference to {@link #staticDescribe(Penguin)} (static form)
     */
    public static Function<Penguin, String> staticReference() {
        return MethodReferenceExamples::staticDescribe;
    }

    /**
     * @return bound instance reference to {@link Penguin#name()} highlighting the {@code Class::instanceMethod}
     *     syntax for single-argument functions
     */
    public static Function<Penguin, String> instanceReference() {
        return Penguin::name;
    }

    /**
     * @return unbound reference that still requires a target instance (represented by the first
     *     parameter), mirroring the "arbitrary object" examples
     */
    public static BiFunction<Penguin, String, String> arbitraryInstanceReference() {
        return Penguin::slide;
    }

    /**
     * @return supplier using a constructor reference to produce default {@link Penguin} instances
     */
    public static Supplier<Penguin> constructorReference() {
        return () -> new Penguin("Unnamed");
    }

    /**
     * Demonstrates mapping a {@link java.util.stream.Stream} of names into {@link Penguin}s using a
     * constructor reference, matching the chapter's collection pipeline example.
     *
     * @param names penguin names
     * @return immutable list of {@link Penguin} objects
     */
    public static List<Penguin> createPenguins(List<String> names) {
        return names.stream().map(Penguin::new).toList();
    }
}
