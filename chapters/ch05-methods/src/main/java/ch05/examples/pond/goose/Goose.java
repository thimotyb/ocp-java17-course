package ch05.examples.pond.goose;

import ch05.examples.pond.shore.Bird;

/**
 * From Chapter 5: {@code Working with Protected Members}. Illustrates that a subclass can access
 * protected members only through references whose compile-time type is the subclass (or another
 * subtype), not through the superclass type.
 */
public class Goose extends Bird {

    /**
     * @return the protected members accessed via another {@code Goose} instance (legal in the book)
     */
    public String helpGooseSwim() {
        Goose other = new Goose();
        return other.floatInWater() + other.text;
    }

    /**
     * @return message indicating the access failure when using a {@link Bird}-typed reference
     */
    public String helpOtherGooseSwim() {
        Bird other = new Goose();
        // other.floatInWater(); // DOES NOT COMPILE in the book example
        // other.text; // DOES NOT COMPILE in the book example
        return "cannot access";
    }
}
