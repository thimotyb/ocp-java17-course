package ch05.examples.pond.duck;

/**
 * From Chapter 5: {@code Applying Access Modifiers}. Demonstrates that {@code private} members
 * (the {@code quack()} method and {@code noise} field) are accessible only inside the declaring
 * class.
 */
public class FatherDuck {

    private final String noise = "quack";

    private void quack() {
        // prints inside class only
    }

    /**
     * Provides a legal path for other classes to interact with the private members, matching the
     * pattern described in the book.
     *
     * @return the {@code noise} value after invoking the private {@code quack()} method
     */
    public String callPrivateMembers() {
        quack();
        return noise;
    }
}
