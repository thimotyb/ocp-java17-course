package ch05.examples.pond.swan;

import ch05.examples.pond.shore.Bird;

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
