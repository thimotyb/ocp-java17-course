package ch07.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implements the Chapter 7 guidance from "Understanding Encapsulation". The example converts the
 * mutable POJO structure into an immutable, well-encapsulated type so callers cannot compromise its
 * invariants.
 *
 * <p>Key takeaways from the section:</p>
 * <ul>
 *   <li>Expose state through methods rather than directly accessible fields.</li>
 *   <li>Defensive copies or unmodifiable views prevent external code from mutating internal
 *       collections.</li>
 *   <li>Classes marked {@code final} and composed of {@code private final} fields support the
 *       immutable object pattern highlighted in the book.</li>
 * </ul>
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c07.xhtml">OCP Java SE 17 Study Guide – Chapter 7: Understanding Encapsulation</a>
 */
public final class EncapsulationExamples {

    private EncapsulationExamples() {
    }

    /**
     * Encapsulated version of the inventory listing. Clients can add animals through the provided
     * method but receive an unmodifiable view when reading them back.
     */
    public static final class ZooInventory {

        private final List<String> animals = new ArrayList<>();

        /**
         * Adds a new animal entry. Mutating methods operate on the private collection so the class
         * retains full control over its invariants.
         *
         * @param name species or identifier to store
         */
        public void addAnimal(String name) {
            animals.add(name);
        }

        /**
         * @return an unmodifiable view that callers cannot mutate, mirroring the defensive copy
         *     pattern recommended in the chapter
         */
        public List<String> getAnimals() {
            return Collections.unmodifiableList(animals);
        }
    }
}
