package ch07.examples;

/**
 * Implements the Chapter 7 sealed-hierarchy listings. Sealed types restrict which classes may
 * implement or extend them, enabling exhaustive pattern matching at compile time.
 *
 * <p>From "Declaring a Sealed Class" and "Reviewing Sealed Class Rules" — reminders:</p>
 * <ul>
 *   <li>Use {@code sealed} with a {@code permits} clause to enumerate all allowed subclasses.</li>
 *   <li>Every permitted subclass must be in the same module (or package) and declare exactly one of
 *       {@code final}, {@code sealed}, or {@code non-sealed}.</li>
 *   <li>Pattern matching over a sealed hierarchy can safely omit a {@code default} branch once all
 *       known subclasses are handled.</li>
 * </ul>
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c07.xhtml">OCP Java SE 17 Study Guide – Chapter 7: Declaring a Sealed Class</a>
 */
public final class SealedExamples {

    private SealedExamples() {
    }

    /**
     * Sealed interface that limits implementations to the three permitted zoo animals described in
     * the book's example hierarchy.
     */
    public sealed interface ZooAnimal permits Lion, Tiger, Penguin {

        /**
         * @return the animal's display name
         */
        String name();
    }

    /** Final permitted implementation representing a lion. */
    public static final class Lion implements ZooAnimal {

        @Override
        public String name() {
            return "Lion";
        }
    }

    /** Final permitted implementation representing a tiger. */
    public static final class Tiger implements ZooAnimal {

        @Override
        public String name() {
            return "Tiger";
        }
    }

    /** Final permitted implementation representing a penguin. */
    public static final class Penguin implements ZooAnimal {

        @Override
        public String name() {
            return "Penguin";
        }
    }

    /**
     * Pattern-matching example that demonstrates exhaustive handling of the sealed interface.
     *
     * @param animal permitted zoo animal instance
     * @return behavioural description drawn from the book example
     */
    public static String describe(ZooAnimal animal) {
        if (animal instanceof Lion lion) {
            return lion.name() + " roars";
        }
        if (animal instanceof Tiger tiger) {
            return tiger.name() + " stalks";
        }
        if (animal instanceof Penguin penguin) {
            return penguin.name() + " waddles";
        }
        throw new IllegalStateException("Unknown animal: " + animal);
    }
}
