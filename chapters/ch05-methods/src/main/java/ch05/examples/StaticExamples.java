package ch05.examples;

import java.util.Arrays;
import java.util.List;

/**
 * Contains the Chapter 5 listings that teach how {@code static} members belong to the class rather
 * than an instance, including static initializers and constant patterns.
 *
 * <p>From Chapter 5: {@code Designing static Methods and Variables} and {@code Initializing Static
 * Variables} — these snippets visualise shared state, the ability to call static members through
 * references, and the ordering rules for static initialization blocks.</p>
 */
public final class StaticExamples {

    private StaticExamples() {
    }

    /**
     * From Chapter 5: {@code Designing static Methods and Variables}. Demonstrates that instance
     * fields (each penguin's {@code name}) are distinct, while the static field is shared across
     * all objects.
     */
    public static final class Penguin {

        private String name;
        private static String nameOfTallestPenguin;

        /** Assigns the per-instance name discussed in the chapter narrative. */
        public void setName(String name) {
            this.name = name;
        }

        /** Records the tallest penguin for the entire class, not a single object. */
        public static void setNameOfTallestPenguin(String name) {
            nameOfTallestPenguin = name;
        }

        /**
         * @return the shared value showing how a later assignment replaces earlier ones for every
         *     instance
         */
        public static String getNameOfTallestPenguin() {
            return nameOfTallestPenguin;
        }

        /** @return the instance-specific name that does not affect other penguins */
        public String getName() {
            return name;
        }
    }

    /**
     * Recreates the {@code Koala} example in Chapter 5 showing that {@code main} is just another
     * static method and can be invoked by other classes.
     */
    public static final class Koala {

        public static int count;

        public static void main(String[] args) {
            // called via Koala.main(new String[0])
        }
    }

    /**
     * From Chapter 5: {@code Accessing a static Variable or Method}. Highlights that static fields
     * are read via the reference type, even when the reference is {@code null}.
     */
    public static final class Snake {

        public static long hiss = 2;
    }

    /**
     * Mirrors the book's compilation error when a static method tries to access an instance method
     * without an object reference, and the subsequent fix by passing a {@link MantaRay} instance.
     */
    public static final class MantaRay {

        private String name = "Sammy";

        public static void first() {
        }

        public static void second() {
        }

        /** Instance method that relies on object state. */
        public void third() {
            if (name == null) {
                throw new IllegalStateException("name missing");
            }
        }

        /**
         * Supplies the needed instance, matching the solution recommended in Chapter 5.
         *
         * @param ray the manta ray whose state will be used inside {@link #third()}
         */
        public static void callThird(MantaRay ray) {
            ray.third();
        }
    }

    /**
     * Reiterates the rule that instance members need an instance reference, while static members do
     * not. Also used in the book to show mixed calls inside one class.
     */
    public static final class Giraffe {

        public void eat(Giraffe g) {
        }

        public void drink() {
        }

        public static void allGiraffeGoHome(Giraffe g) {
        }

        public static void allGiraffeComeOut() {
        }
    }

    /**
     * From Chapter 5: {@code Mixing Static and Instance Members}. Demonstrates that both static and
     * instance methods can update the same static counter, and that instance methods can call static
     * helpers directly.
     */
    public static final class Gorilla {

        public static int count;

        public static void addGorilla() {
            count++;
        }

        public void babyGorilla() {
            count++;
        }

        public void announceBabies() {
            addGorilla();
            babyGorilla();
        }

        public static String announceBabiesToEveryone() {
            addGorilla();
            return "announced";
        }
    }

    /**
     * Implements the shared counter example where each constructor invocation increments a static
     * field, illustrating state shared across instances.
     */
    public static final class Counter {

        private static int count;

        public Counter() {
            count++;
        }

        public static int getCount() {
            return count;
        }
    }

    /**
     * Shows the preferred pattern for simple constants: a {@code private static final} field with a
     * public accessor, in line with the chapter's discussion on encapsulating static state.
     */
    public static final class ZooPen {

        private static final int NUM_BUCKETS = 45;

        public static int buckets() {
            return NUM_BUCKETS;
        }
    }

    /**
     * Demonstrates a static array shared across the application, and how {@code Arrays.asList}
     * exposes it as discussed under static initializers.
     */
    public static final class ZooInventoryManager {

        private static final String[] TREATS = new String[10];

        public static void setTreat(int index, String value) {
            TREATS[index] = value;
        }

        public static List<String> treats() {
            return Arrays.asList(TREATS);
        }
    }

    /**
     * Reflects the constant initialization block example in which some static finals are assigned in
     * the field declaration and others inside a static block.
     */
    public static final class Panda {

        public static final String NAME = "Ronda";
        public static final int BAMBOO;
        public static final double HEIGHT; // intentionally left without value in book

        static {
            BAMBOO = 5;
            HEIGHT = 1.9;
        }
    }

    /**
     * Aggregates the two static initializer blocks that compute dependent constants, as shown in the
     * {@code TimeConstants} listing in Chapter 5.
     */
    public static final class TimeConstants {

        private static final int NUM_SECONDS_PER_MINUTE;
        private static final int NUM_MINUTES_PER_HOUR;
        private static final int NUM_SECONDS_PER_HOUR;

        static {
            NUM_SECONDS_PER_MINUTE = 60;
            NUM_MINUTES_PER_HOUR = 60;
        }

        static {
            NUM_SECONDS_PER_HOUR = NUM_SECONDS_PER_MINUTE * NUM_MINUTES_PER_HOUR;
        }

        private TimeConstants() {
        }

        public static int secondsPerHour() {
            return NUM_SECONDS_PER_HOUR;
        }
    }
}
