package ch05.examples;

import java.util.Arrays;
import java.util.List;

public final class StaticExamples {

    private StaticExamples() {
    }

    public static final class Penguin {

        private String name;
        private static String nameOfTallestPenguin;

        public void setName(String name) {
            this.name = name;
        }

        public static void setNameOfTallestPenguin(String name) {
            nameOfTallestPenguin = name;
        }

        public static String getNameOfTallestPenguin() {
            return nameOfTallestPenguin;
        }

        public String getName() {
            return name;
        }
    }

    public static final class Koala {

        public static int count;

        public static void main(String[] args) {
            // called via Koala.main(new String[0])
        }
    }

    public static final class Snake {

        public static long hiss = 2;
    }

    public static final class MantaRay {

        private String name = "Sammy";

        public static void first() {
        }

        public static void second() {
        }

        public void third() {
            if (name == null) {
                throw new IllegalStateException("name missing");
            }
        }

        public static void callThird(MantaRay ray) {
            ray.third();
        }
    }

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

    public static final class Counter {

        private static int count;

        public Counter() {
            count++;
        }

        public static int getCount() {
            return count;
        }
    }

    public static final class ZooPen {

        private static final int NUM_BUCKETS = 45;

        public static int buckets() {
            return NUM_BUCKETS;
        }
    }

    public static final class ZooInventoryManager {

        private static final String[] TREATS = new String[10];

        public static void setTreat(int index, String value) {
            TREATS[index] = value;
        }

        public static List<String> treats() {
            return Arrays.asList(TREATS);
        }
    }

    public static final class Panda {

        public static final String NAME = "Ronda";
        public static final int BAMBOO;
        public static final double HEIGHT; // intentionally left without value in book

        static {
            BAMBOO = 5;
            HEIGHT = 1.9;
        }
    }

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
