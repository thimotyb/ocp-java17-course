package ch05.examples.pond.swan;

import ch05.examples.pond.shore.Bird;

/**
 * Another Chapter 5 protected-access example: subclasses can reach inherited members directly and
 * through other subclass instances, but not through a superclass-typed reference.
 */
public class Swan extends Bird {

    public String swim() {
        return floatInWater() + text;
    }

    public String helpOtherSwanSwim() {
        Swan other = new Swan();
        return other.floatInWater() + other.text;
    }

    public String helpOtherBirdSwim() {
        Bird other = new Bird();
        // other.floatInWater(); // DOES NOT COMPILE in the book example
        // other.text; // DOES NOT COMPILE in the book example
        return "cannot access";
    }
}
