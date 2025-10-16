package ch05.examples.pond.inland;

import ch05.examples.pond.shore.Bird;

public class BirdWatcherFromAfar {

    public String watchBird() {
        Bird bird = new Bird();
        // bird.floatInWater(); // DOES NOT COMPILE in the book example
        // bird.text; // DOES NOT COMPILE in the book example
        return "cannot access";
    }
}
