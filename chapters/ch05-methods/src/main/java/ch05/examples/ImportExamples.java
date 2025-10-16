package ch05.examples;

import java.util.Arrays;
import java.util.List;

public final class ImportExamples {

    private ImportExamples() {
    }

    public static final class Imports {

        public List<String> createList() {
            return Arrays.asList("one", "two");
        }
    }

    public static final class ZooParking {

        public List<String> createList() {
            return Arrays.asList("one", "two");
        }
    }

    public static final class BadZooParking {

        // import static java.util.Arrays; // DOES NOT COMPILE in the book example
        // static import java.util.Arrays.*; // DOES NOT COMPILE in the book example

        public void attempt() {
            // Arrays.asList("one"); // DOES NOT COMPILE without proper import
        }
    }

    public static final class DuplicateStaticImports {
        // import static zoo.A.TYPE; // DOES NOT COMPILE
        // import static zoo.B.TYPE; // DOES NOT COMPILE
    }
}
