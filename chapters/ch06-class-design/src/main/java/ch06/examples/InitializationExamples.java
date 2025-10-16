package ch06.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates static and instance initialization order from Chapter 6.
 */
public final class InitializationExamples {

    private InitializationExamples() {
    }

    public static class Animal {

        static {
            OUTPUT.add("A");
        }
    }

    public static class Hippo extends Animal {

        static {
            OUTPUT.add("B");
        }

        public static void runMain(List<String> collector) {
            collector.add("C");
            new Hippo();
            new Hippo();
        }
    }

    public static final class HippoFriend {

        public static void run(List<String> collector) {
            collector.add("C");
            new Hippo();
        }
    }

    private static final List<String> OUTPUT = new ArrayList<>();

    public static List<String> hippoSequence() {
        OUTPUT.clear();
        Hippo.runMain(OUTPUT);
        return new ArrayList<>(OUTPUT);
    }

    public static final class MouseHouse {

        private final int volume;
        private final String type;

        {
            this.volume = 10;
        }

        public MouseHouse(String type) {
            this.type = type;
        }

        public MouseHouse() {
            this(null);
        }

        public int getVolume() {
            return volume;
        }

        public String getType() {
            return type;
        }
    }

    public static final class ZooTickets {

        private String name = "BestZoo";
        {
            OUTPUT.add(name + "-");
        }
        private static int COUNT = 0;
        static {
            OUTPUT.add(COUNT + "-");
        }
        static {
            COUNT += 10;
            OUTPUT.add(COUNT + "-");
        }

        public ZooTickets() {
            OUTPUT.add("z-");
        }

        public static void generate() {
            OUTPUT.clear();
            new ZooTickets();
        }
    }

    public static class Primate {

        public Primate() {
            OUTPUT.add("Primate-");
        }
    }

    public static class Ape extends Primate {

        public Ape(int fur) {
            OUTPUT.add("Ape1-");
        }

        public Ape() {
            OUTPUT.add("Ape2-");
        }
    }

    public static class Chimpanzee extends Ape {

        public Chimpanzee() {
            super(2);
            OUTPUT.add("Chimpanzee-");
        }
    }

    public static class Cuttlefish {

        private String name = "swimmy";
        {
            OUTPUT.add(name);
        }
        private static int COUNT = 0;
        static {
            OUTPUT.add(String.valueOf(COUNT));
        }
        {
            COUNT++;
            OUTPUT.add(String.valueOf(COUNT));
        }

        public Cuttlefish() {
            OUTPUT.add("Constructor");
        }
    }

    public static class GiraffeFamily {

        static {
            OUTPUT.add("A");
        }
        {
            OUTPUT.add("B");
        }

        public GiraffeFamily(String name) {
            this(1);
            OUTPUT.add("C");
        }

        public GiraffeFamily() {
            OUTPUT.add("D");
        }

        public GiraffeFamily(int stripes) {
            OUTPUT.add("E");
        }
    }

    public static class Okapi extends GiraffeFamily {

        static {
            OUTPUT.add("F");
        }
        {
            OUTPUT.add("H");
        }

        public Okapi(int stripes) {
            super("sugar");
            OUTPUT.add("G");
        }
    }

    public static List<String> getOutput() {
        return new ArrayList<>(OUTPUT);
    }

    public static void clearOutput() {
        OUTPUT.clear();
    }
}
