package ch05.examples;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public final class OverloadingExamples {

    private OverloadingExamples() {
    }

    public static final class Chimpanzee {

        public void climb(long t) {
        }

        public void swing(Integer u) {
        }

        public void jump(int v) {
        }
    }

    public static final class Gorilla {

        public void rest(Long x) {
        }
    }

    public static final class Falcon {

        public String fly(int numMiles) {
            return "int";
        }

        public String fly(short numFeet) {
            return "short";
        }

        public boolean fly() {
            return false;
        }

        void fly(int numMiles, short numFeet) {
        }

        public void fly(short numFeet, int numMiles) throws Exception {
            if (numFeet < 0 || numMiles < 0) {
                throw new Exception("negative distance");
            }
        }
    }

    public static final class Eagle {

        public void fly(int numMiles) {
        }
        // public int fly(int numMiles) { return 1; } // DOES NOT COMPILE
    }

    public static final class Hawk {

        public void fly(int numMiles) {
        }
        // public static void fly(int numMiles) {} // DOES NOT COMPILE
        // public void fly(int numKilometers) {} // DOES NOT COMPILE
    }

    public static final class Dove {

        public String fly(int numMiles) {
            return "int";
        }

        public String fly(short numFeet) {
            return "short";
        }
    }

    public static final class Pelican {

        public String fly(String s) {
            return "string";
        }

        public String fly(Object o) {
            return "object";
        }

        public List<String> evaluateCalls() {
            return List.of(fly("test"), fly(56));
        }
    }

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

    public static final class Ostrich {

        public String fly(int i) {
            return "int";
        }

        public String fly(long l) {
            return "long";
        }
    }

    public static final class Kiwi {

        public String fly(int numMiles) {
            return "int";
        }

        public String fly(Integer numMiles) {
            return "Integer";
        }
    }

    public static final class Toucan {

        public void fly(int[] lengths) {
        }

        // public void fly(int... lengths) {} // DOES NOT COMPILE
    }

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
