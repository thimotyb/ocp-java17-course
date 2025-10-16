package ch07.examples;

public final class SealedExamples {

    private SealedExamples() {
    }

    public sealed interface ZooAnimal permits Lion, Tiger, Penguin {

        String name();
    }

    public static final class Lion implements ZooAnimal {

        @Override
        public String name() {
            return "Lion";
        }
    }

    public static final class Tiger implements ZooAnimal {

        @Override
        public String name() {
            return "Tiger";
        }
    }

    public static final class Penguin implements ZooAnimal {

        @Override
        public String name() {
            return "Penguin";
        }
    }

    public static String describe(ZooAnimal animal) {
        if (animal instanceof Lion lion) {
            return lion.name() + " roars";
        }
        if (animal instanceof Tiger tiger) {
            return tiger.name() + " stalks";
        }
        if (animal instanceof Penguin penguin) {
            return penguin.name() + " waddles";
        }
        throw new IllegalStateException("Unknown animal: " + animal);
    }
}
