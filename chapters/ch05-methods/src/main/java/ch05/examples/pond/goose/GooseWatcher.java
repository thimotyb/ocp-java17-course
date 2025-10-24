package ch05.examples.pond.goose;

/**
 * Represents a non-subclass in a different package, matching the Chapter 5 scenario where
 * protected members are inaccessible.
 */
public class GooseWatcher {

    /**
     * @return explanatory message; the commented call matches the compilation error in the book
     */
    public String watch() {
        Goose goose = new Goose();
        // goose.floatInWater(); // DOES NOT COMPILE in the book example
        return "cannot access";
    }
}
