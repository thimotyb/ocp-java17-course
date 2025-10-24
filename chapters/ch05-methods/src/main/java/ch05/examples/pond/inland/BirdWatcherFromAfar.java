package ch05.examples.pond.inland;

import ch05.examples.pond.shore.Bird;

/**
 * Represents a non-subclass located in a different package, matching Chapter 5's example of
 * denied access to protected members.
 */
public class BirdWatcherFromAfar {

    /**
     * @return message describing the access failure; the commented references mirror the book
     */
    public String watchBird() {
        Bird bird = new Bird();
        // bird.floatInWater(); // DOES NOT COMPILE in the book example
        // bird.text; // DOES NOT COMPILE in the book example
        return "cannot access";
    }
}
