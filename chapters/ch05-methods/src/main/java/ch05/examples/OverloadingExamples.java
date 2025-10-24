package ch05.examples;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

/**
 * Collects the Chapter 5 overload listings used to explain how the compiler selects among
 * candidates by comparing method signatures, parameter types, and optional varargs.
 *
 * <p>From Chapter 5: {@code Working with Overloaded Methods} — the code in this class touches
 * the exam rules supplied in the book:</p>
 * <ul>
 *   <li>Two methods are overloaded when their signatures differ by parameter list only.</li>
 *   <li>Return type, access modifier, and checked exceptions do not participate in the signature.</li>
 *   <li>Invocation resolution prefers exact matches, then widening primitives, then boxing, and
 *       finally varargs.</li>
 *   <li>Conflicting overloads (same signature, differing only by return type or modifiers) cause
 *       compilation failure.</li>
 * </ul>
 */
public final class OverloadingExamples {

    private OverloadingExamples() {
    }

    /**
     * From Chapter 5: {@code Declaring Overloaded Methods}. Demonstrates that changing the
     * parameter type or count (long vs. {@link Integer} vs. {@code int}) is sufficient to create
     * unique overloads within the same class.
     */
    public static final class Chimpanzee {

        /** Accepts a widened primitive value. */
        public void climb(long t) {
        }

        /** Accepts a boxed argument. */
        public void swing(Integer u) {
        }

        /** Accepts an exact primitive match. */
        public void jump(int v) {
        }
    }

    /**
     * From Chapter 5: {@code Working with Overloaded Methods}. Shows that overloading operates
     * independently in each class—only the parameter list of this method matters.
     */
    public static final class Gorilla {

        /** Uses {@link Long} to contrast with the {@code long} parameter in other examples. */
        public void rest(Long x) {
        }
    }

    /**
     * Presents a variety of overload signatures to illustrate invocation selection and how checked
     * exceptions can be declared on only some overloads.
     */
    public static final class Falcon {

        /**
         * @return {@code "int"} to make call-site resolution observable when an {@code int}
         *     argument is provided.
         */
        public String fly(int numMiles) {
            return "int";
        }

        /** @return {@code "short"} when the caller supplies a {@code short}. */
        public String fly(short numFeet) {
            return "short";
        }

        /** Overload with no parameters, demonstrating that arity alone can differentiate methods. */
        public boolean fly() {
            return false;
        }

        /** Package-private overload used to highlight that access modifier differences are allowed. */
        void fly(int numMiles, short numFeet) {
        }

        /**
         * Adds a checked exception to reinforce the book's point that throws clauses do not affect
         * overloading, yet callers must handle or declare the checked exception when choosing this
         * signature.
         */
        public void fly(short numFeet, int numMiles) throws Exception {
            if (numFeet < 0 || numMiles < 0) {
                throw new Exception("negative distance");
            }
        }
    }

    /**
     * Shows the compile-time failure that occurs when two methods differ only by return type.
     */
    public static final class Eagle {

        public void fly(int numMiles) {
        }
        // public int fly(int numMiles) { return 1; } // DOES NOT COMPILE
    }

    /**
     * Demonstrates two invalid overload attempts: differing only by {@code static} modifier and by
     * parameter name, both of which Chapter 5 identifies as compilation errors.
     */
    public static final class Hawk {

        public void fly(int numMiles) {
        }
        // public static void fly(int numMiles) {} // DOES NOT COMPILE
        // public void fly(int numKilometers) {} // DOES NOT COMPILE
    }

    /**
     * Replays the book's scenario for overload resolution between primitive widening and exact
     * matches. Returning a string literal makes the outcome easy to assert in tests.
     */
    public static final class Dove {

        public String fly(int numMiles) {
            return "int";
        }

        public String fly(short numFeet) {
            return "short";
        }
    }

    /**
     * Highlights how the compiler prefers the most specific matching overload: {@code String}
     * beats {@code Object} for string literals, whereas boxing an {@code int} selects the {@code Object}
     * overload. The {@link #evaluateCalls()} helper mirrors the book's walkthrough table.
     */
    public static final class Pelican {

        public String fly(String s) {
            return "string";
        }

        public String fly(Object o) {
            return "object";
        }

        /**
         * @return a list of the overload results for a {@code String} literal and an {@code int},
         *     matching the book explanation.
         */
        public List<String> evaluateCalls() {
            return List.of(fly("test"), fly(56));
        }
    }

    /**
     * Implements the precedence chain (exact match → wider primitive → boxing) as discussed in
     * Chapter 5. The concatenated return value makes the chosen overloads visible.
     */
    public static final class Parrot {

        public static String print(List<Integer> i) {
            return "I";
        }

        public static String print(CharSequence c) {
            return "C";
        }

        public static String print(Object o) {
            return "O";
        }

        public static String demonstrate() {
            return print("abc") + print(Arrays.asList(3))
                + print(LocalDate.of(2019, Month.JULY, 4));
        }
    }

    /**
     * Shows widening beats boxing: passing an {@code int} selects the {@code long} overload when
     * no exact match exists, echoing the decision tree from the book.
     */
    public static final class Ostrich {

        public String fly(int i) {
            return "int";
        }

        public String fly(long l) {
            return "long";
        }
    }

    /**
     * Demonstrates how boxing competes with exact matches. When both {@code int} and
     * {@link Integer} overloads exist, primitives choose the exact primitive signature.
     */
    public static final class Kiwi {

        public String fly(int numMiles) {
            return "int";
        }

        public String fly(Integer numMiles) {
            return "Integer";
        }
    }

    /**
     * Represents the prohibition on declaring two overloads whose signatures collapse to the same
     * erased form (array vs. varargs). The commented line matches the book's compiler error.
     */
    public static final class Toucan {

        public void fly(int[] lengths) {
        }

        // public void fly(int... lengths) {} // DOES NOT COMPILE
    }

    /**
     * Applies the varargs resolution order covered in Chapter 5. The results indicate which
     * overload is chosen when a single {@code String}, a pair of {@code String}s, or an explicit array
     * is supplied.
     */
    public static final class Glider {

        public static String glide(String s) {
            return "1";
        }

        public static String glide(String... s) {
            return "2";
        }

        public static String glide(Object o) {
            return "3";
        }

        public static String glide(String s, String t) {
            return "4";
        }

        public static String[] demonstrate() {
            return new String[] {
                glide("a"),
                glide("a", "b"),
                glide(new String[] {"a", "b", "c"})
            };
        }
    }
}
