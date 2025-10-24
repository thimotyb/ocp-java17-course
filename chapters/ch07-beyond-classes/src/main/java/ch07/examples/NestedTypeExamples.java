package ch07.examples;

/**
 * Gathers the Chapter 7 "Creating Nested Classes" listings. Each nested type demonstrates one of
 * the four flavours described in the book: static nested classes, inner classes, local classes, and
 * anonymous classes.
 *
 * <p>Important observations from the section:</p>
 * <ul>
 *   <li>Inner classes capture the enclosing instance and can freely read its members.</li>
 *   <li>Static nested classes behave like top-level classes but can access static members of the
 *       enclosing class.</li>
 *   <li>Local classes (declared within methods) have access to effectively final variables.</li>
 *   <li>Anonymous classes are concise local classes used for single-use behaviours such as passing a
 *       {@link Noise} implementation.</li>
 * </ul>
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c07.xhtml">OCP Java SE 17 Study Guide – Chapter 7: Creating Nested Classes</a>
 */
public final class NestedTypeExamples {

    private NestedTypeExamples() {
    }

    /**
     * Enclosing type that hosts each nested-class variant. The Chapter 7 examples place both static
     * and non-static nested types inside this class to highlight their access rules.
     */
    public static final class Enclosure {

        private static String location = "North";
        private final String name;

        /**
         * @param name enclosure name used by the inner and local classes for contextual output
         */
        public Enclosure(String name) {
            this.name = name;
        }

        /**
         * Static nested class that reads the enclosing class's static state ({@link #location}).
         * Mirrors the book's example where status messages are generated without an instance.
         */
        public static final class Status {

            private final String description;

            public Status(String description) {
                this.description = description;
            }

            /**
             * @return formatted label showing that the static nested class can access the outer
             *     static field without an enclosing instance
             */
            public String label() {
                return location + " status: " + description;
            }
        }

        /**
         * Inner class (member class) that has an implicit reference to the enclosing {@link Enclosure}
         * instance. Demonstrates that inner classes can read private members like {@link #name}.
         */
        public final class Resident {

            private final String species;

            public Resident(String species) {
                this.species = species;
            }

            /**
             * @return description combining the outer instance's {@code name} and the resident species
             */
            public String description() {
                return name + " houses " + species;
            }
        }

        /**
         * Demonstrates a local class declared within a method ({@code CaretakerLog}). The chapter
         * explains that local classes can reference effectively final variables such as
         * {@code caretaker} and {@code rounds}.
         *
         * @param caretaker staff member completing rounds
         * @return formatted report string created by the local class
         */
        public String caretakerReport(String caretaker) {
            final int rounds = 3;
            class CaretakerLog {

                String build() {
                    return caretaker + " completed " + rounds + " rounds in " + name;
                }
            }
            return new CaretakerLog().build();
        }

        /**
         * Demonstrates an anonymous class via a lambda (the book treats lambdas as a concise form of
         * an anonymous implementation for functional interfaces like {@link Noise}).
         *
         * @return message produced by the anonymous {@link Noise}
         */
        public String anonymousCall() {
            return sound(() -> name + " quiet down" + " please");
        }

        private String sound(Noise noise) {
            return noise.sound();
        }
    }

    /** Functional interface that the anonymous class example implements. */
    @FunctionalInterface
    public interface Noise {

        String sound();
    }
}
