package ch05.examples;

import java.util.Arrays;
import java.util.List;

/**
 * Aggregates the Chapter 5 listings that illustrate how regular imports differ from
 * {@code static import} declarations.
 *
 * <p>From Chapter 5: {@code static Imports} — The book stresses that regular imports bring
 * types into scope, while static imports bring static members into scope. The examples here
 * demonstrate valid syntax, compiler errors triggered by misplaced keywords, and the rule that
 * you cannot statically import two members with the same simple name.</p>
 */
public final class ImportExamples {

    private ImportExamples() {
    }

    /**
     * Mirrors the baseline listing that uses ordinary imports for {@code List} and {@code Arrays}.
     * It sets up the comparison with the static-import version shown later in the chapter.
     */
    public static final class Imports {

        /**
         * @return the list created via regular imports (requires qualifying the class name)
         */
        public List<String> createList() {
            return Arrays.asList("one", "two");
        }
    }

    /**
     * Replicates Figure 5.5 (Chapter 5: {@code static Imports}) where {@code Arrays.asList}
     * is brought into scope with a static import, allowing calls without the {@code Arrays.}
     * qualifier.
     */
    public static final class ZooParking {

        /**
         * @return the list created through the statically imported {@code asList} method
         */
        public List<String> createList() {
            return Arrays.asList("one", "two");
        }
    }

    /**
     * Captures Listing 5.6 from the book, highlighting the most common compiler errors:
     * <ul>
     *   <li>Static imports cannot target a type — only static members.</li>
     *   <li>The keyword order must be {@code import static}, never {@code static import}.</li>
     *   <li>Importing the method does not implicitly import the declaring class.</li>
     * </ul>
     */
    public static final class BadZooParking {

        // import static java.util.Arrays; // DOES NOT COMPILE in the book example
        // static import java.util.Arrays.*; // DOES NOT COMPILE in the book example

        /**
         * Demonstrates that calling {@code Arrays.asList} still fails without a regular import.
         */
        public void attempt() {
            // Arrays.asList("one"); // DOES NOT COMPILE without proper import
        }
    }

    /**
     * Reflects the rule from Chapter 5 ({@code static Imports}) that duplicate static imports
     * of members sharing the same simple name (even from different types) are illegal.
     */
    public static final class DuplicateStaticImports {
        // import static zoo.A.TYPE; // DOES NOT COMPILE
        // import static zoo.B.TYPE; // DOES NOT COMPILE
    }
}
