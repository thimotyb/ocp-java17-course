package ch07.examples;

/**
 * Demonstrates implicit modifiers, defaults, static helpers, and private interface methods.
 */
public final class InterfaceFeatureExamples {

    private InterfaceFeatureExamples() {
    }

    public interface Soar {

        int MAX_HEIGHT = 10;
        boolean UNDERWATER = true;

        void fly(int speed);

        default String takeoff() {
            return prepare("Taking off");
        }

        static double dive() {
            return Math.random();
        }

        private String prepare(String action) {
            return action + " at max height " + MAX_HEIGHT;
        }
    }

    public static final class Eagle implements Soar {

        private int lastSpeed;

        @Override
        public void fly(int speed) {
            lastSpeed = speed;
        }

        public int getLastSpeed() {
            return lastSpeed;
        }
    }

    public interface IsColdBlooded {

        default double getTemperature() {
            return 10.0;
        }
    }

    public interface LivesInOcean {

        default double getTemperature() {
            return 12.0;
        }
    }

    public static final class Shark implements IsColdBlooded, LivesInOcean {

        @Override
        public double getTemperature() {
            return LivesInOcean.super.getTemperature();
        }
    }
}
