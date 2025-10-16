package ch05.examples;

import java.util.Arrays;

public final class VarargsExamples {

    private VarargsExamples() {
    }

    public static final class VisitAttractions {

        public void walk1(int... steps) {
        }

        public void walk2(int start, int... steps) {
        }

        // public void walk3(int... steps, int start) {} // DOES NOT COMPILE
        // public void walk4(int... start, int... steps) {} // DOES NOT COMPILE
    }

    public static final class VarargUtilities {

        public static int lengthOf(int... steps) {
            return steps.length;
        }

        public static int secondElement(int... steps) {
            return steps[1];
        }
    }

    public static final class DogWalker {

        public static int walkDog(int start, int... steps) {
            return steps.length;
        }

        public static int walkDogWithArray(int start, int[] steps) {
            return walkDog(start, steps);
        }

        public static int explodeOnNull(int start, int... steps) {
            return steps.length;
        }
    }

    public static int[] copySteps(int... steps) {
        int[] copy = Arrays.copyOf(steps, steps.length);
        return copy;
    }
}
