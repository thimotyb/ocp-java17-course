package ch05.examples;

import java.util.Objects;

/**
 * Illustrates Chapter 5 method declaration and local variable rules.
 */
public final class MethodDeclarationExamples {

    private MethodDeclarationExamples() {
    }

    /**
     * Mirrors the access modifier ordering examples.
     */
    public static final class ParkTrip {

        public void skip1() {
            // valid public method declaration
        }

        // default void skip2() {} // DOES NOT COMPILE
        // void public skip3() {} // DOES NOT COMPILE

        void skip4() {
            // package-private access is allowed
        }
    }

    /**
     * Mirrors combinations of optional specifiers shown for methods.
     */
    public static final class Exercise {

        public void bike1() {
        }

        public final void bike2() {
        }

        public static final void bike3() {
        }

        public final static void bike4() {
        }

        // public modifier void bike5() {} // DOES NOT COMPILE
        // public void final bike6() {} // DOES NOT COMPILE

        final public void bike7() {
        }
    }

    /**
     * Demonstrates return type rules.
     */
    public static final class Hike {

        public void hike1() {
        }

        public void hike2() {
            return; // optional early exit in void method
        }

        public String hike3() {
            return ""; // returning String matches signature
        }

        // public String hike4() {} // DOES NOT COMPILE
        // public hike5() {} // DOES NOT COMPILE
        // public String int hike6() {} // DOES NOT COMPILE
        // String hike7(int a) { if (1 < 2) return "orange"; } // DOES NOT COMPILE

        public String hike8(int a) {
            if (a > 0) {
                return "orange";
            }
            return "apple";
        }
    }

    /**
     * Shows assignment compatibility when returning data.
     */
    public static final class Measurement {

        public int getHeight1() {
            int temp = 9;
            return temp;
        }

        // int getHeight2() { int temp = 9L; return temp; } // DOES NOT COMPILE
        // int getHeight3() { long temp = 9L; return temp; } // DOES NOT COMPILE
    }

    /**
     * Highlights identifier rules for method names.
     */
    public static final class BeachTrip {

        public void jog1() {
        }

        // public void 2jog() {} // DOES NOT COMPILE
        // public jog3 void() {} // DOES NOT COMPILE

        public void Jog_$() {
        }

        // public _() {} // DOES NOT COMPILE
        // public void() {} // DOES NOT COMPILE
    }

    /**
     * Shows parameter list syntax variations.
     */
    public static final class PhysicalEducation {

        public void run1() {
        }

        // public void run2 {} // DOES NOT COMPILE

        public void run3(int a) {
        }

        // public void run4(int a; int b) {} // DOES NOT COMPILE

        public void run5(int a, int b) {
        }
    }

    /**
     * Demonstrates method signature uniqueness based on parameter types.
     */
    public static final class TripExamples {

        public void visitZoo(String name, int waitTime) {
        }

        // public void visitZoo(String attraction, int rainFall) {} // DOES NOT COMPILE

        public void visitZoo(int rainFall, String attraction) {
        }
    }

    /**
     * Examples of optional exception lists.
     */
    public static final class ZooMonorail {

        public void zeroExceptions() {
        }

        public void oneException() throws IllegalArgumentException {
            throw new IllegalArgumentException("line closed");
        }

        public void twoExceptions() throws IllegalArgumentException, InterruptedException {
            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedException("monorail interrupted");
            }
            throw new IllegalArgumentException("monorail unavailable");
        }
    }

    /**
     * Method body structure practice.
     */
    public static final class BirdDeclaration {

        public void fly1() {
        }

        // public void fly2() // DOES NOT COMPILE

        public void fly3(int repeats) {
            int name = 5;
            for (int i = 0; i < repeats; i++) {
                name += i;
            }
        }
    }

    /**
     * Distinguishes local and instance variables.
     */
    public static final class Lion {

        private int hunger = 4;

        public int feedZooAnimals() {
            int snack = 10;
            if (snack > 4) {
                long dinnerTime = snack++;
                hunger -= dinnerTime > 0 ? 1 : 0;
            }
            return snack;
        }

        public int getHunger() {
            return hunger;
        }
    }

    /**
     * Mirrors the veterinarian examples about final local variables.
     */
    public static final class Veterinarian {

        public int determineRest(boolean isWeekend) {
            final int rest;
            if (isWeekend) {
                rest = 5;
            } else {
                rest = 20;
            }
            return rest;
        }

        public void prepareCheckup() {
            final int rest = 5;
            final Animal giraffe = new Animal("George");
            final int[] friends = new int[5];
            giraffe.setName("George the Giraffe");
            friends[2] = 2;
            Objects.requireNonNull(rest);
            Objects.requireNonNull(giraffe.getName());
            Objects.requireNonNull(friends);
        }

        public boolean effectivelyFinalExample() {
            String name = "Harry the Hippo";
            var size = 10;
            boolean wet;
            if (size > 100) {
                size++;
            }
            name.substring(0);
            wet = true;
            return wet && name.equals("Harry the Hippo");
        }
    }

    /**
     * Simple domain object used by the Veterinarian example.
     */
    public static final class Animal {

        private String name;

        public Animal(String initialName) {
            this.name = initialName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    /**
     * Mirrors the PolarBear example showing allowed final instance initialisation.
     */
    public static final class PolarBear {

        private final int age = 10;
        private final int fishEaten;
        private final String name;

        {
            fishEaten = 10;
        }

        public PolarBear() {
            name = "Robert";
        }

        public int getAge() {
            return age;
        }

        public int getFishEaten() {
            return fishEaten;
        }

        public String getName() {
            return name;
        }
    }
}
