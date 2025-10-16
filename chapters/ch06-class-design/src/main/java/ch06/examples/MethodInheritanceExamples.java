package ch06.examples;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Mirrors the overriding, hiding, and variable shadowing listings.
 */
public final class MethodInheritanceExamples {

    private MethodInheritanceExamples() {
    }

    public static class Marsupial {

        public double getAverageWeight() {
            return 50;
        }
    }

    public static class Kangaroo extends Marsupial {

        @Override
        public double getAverageWeight() {
            return super.getAverageWeight() + 20;
        }
    }

    public static class Camel {

        public int getNumberOfHumps() {
            return 1;
        }
    }

    public static class BactrianCamel extends Camel {

        @Override
        public int getNumberOfHumps() {
            return 2;
        }
    }

    public static class Reptile {

        protected void sleep() throws IOException {
        }

        protected void hide() {
        }

        protected void exitShell() throws FileNotFoundException {
        }
    }

    public static class GalapagosTortoise extends Reptile {

        @Override
        public void sleep() throws FileNotFoundException {
        }

        // public void hide() throws FileNotFoundException {} // DOES NOT COMPILE
        // public void exitShell() throws IOException {} // DOES NOT COMPILE
    }

    public static class Rhino {

        protected CharSequence getName() {
            return "rhino";
        }

        protected String getColor() {
            return "grey, black, or white";
        }
    }

    public static class JavanRhino extends Rhino {

        @Override
        public String getName() {
            return "javan rhino";
        }

        // public CharSequence getColor() { return "grey"; } // DOES NOT COMPILE
    }

    public static class Beetle {

        private String getSize() {
            return "Undefined";
        }
    }

    public static class RhinocerosBeetle extends Beetle {

        private int getSize() {
            return 5;
        }
    }

    public static class Bear {

        public static void eat() {
            System.out.println("Bear is eating");
        }

        public static void sneeze() {
            System.out.println("Bear is sneezing");
        }

        public void hibernate() {
            System.out.println("Bear is hibernating");
        }

        public static void laugh() {
            System.out.println("Bear is laughing");
        }
    }

    public static class Panda extends Bear {

        public static void eat() {
            System.out.println("Panda is chewing");
        }
    }

    public static class SunBear extends Bear {

        // public void sneeze() {} // DOES NOT COMPILE
        // public static void hibernate() {} // DOES NOT COMPILE
        // protected static void laugh() {} // DOES NOT COMPILE
    }

    public static class Carnivore {

        protected boolean hasFur = false;
    }

    public static class Meerkat extends Carnivore {

        protected boolean hasFur = true;
    }

    public static class Bird {

        public final boolean hasFeathers() {
            return true;
        }

        public static final void flyAway() {
        }
    }

    public static class Penguin extends Bird {

        // public boolean hasFeathers() { return false; } // DOES NOT COMPILE
        // public static void flyAway() {} // DOES NOT COMPILE
    }

    public static class Fish {

        public void swim() {
        }
    }

    public static class Shark extends Fish {

        @Override
        public void swim() {
        }

        // public void swim(int speed) {} // with @Override would not compile
    }
}
