package ch07.examples;

/**
 * Collects the foundational interface listings from Chapter 7.
 */
public final class InterfaceBasicsExamples {

    private InterfaceBasicsExamples() {
    }

    public interface Climb {

        Number getSpeed(int age);
    }

    public interface CanBurrow {

        Float getSpeed(int age);
    }

    public static final class FieldMouse implements Climb, CanBurrow {

        @Override
        public Float getSpeed(int age) {
            return age < 3 ? 5.5f : 8.0f;
        }
    }

    public interface Nocturnal {

        int hunt();
    }

    public interface CanFly {

        void flap();
    }

    public interface HasBigEyes extends Nocturnal, CanFly {
    }

    public static final class Owl implements HasBigEyes {

        @Override
        public int hunt() {
            return 5;
        }

        @Override
        public void flap() {
            // print avoided to keep tests deterministic
        }
    }

    public interface HasTail {

        int getTailLength();
    }

    public interface HasWhiskers {

        int getNumberOfWhiskers();
    }

    public abstract static class HarborSeal implements HasTail, HasWhiskers {
    }

    public static final class CommonSeal extends HarborSeal {

        @Override
        public int getTailLength() {
            return 15;
        }

        @Override
        public int getNumberOfWhiskers() {
            return 24;
        }
    }

    public interface Herbivore {

        void eatPlants();
    }

    public interface Omnivore {

        void eatPlants();
    }

    public static final class Bear implements Herbivore, Omnivore {

        @Override
        public void eatPlants() {
            // shared implementation satisfies both interfaces
        }
    }
}
