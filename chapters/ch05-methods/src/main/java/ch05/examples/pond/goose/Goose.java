package ch05.examples.pond.goose;

import ch05.examples.pond.shore.Bird;

public class Goose extends Bird {

    public String helpGooseSwim() {
        Goose other = new Goose();
        return other.floatInWater() + other.text;
    }

    public String helpOtherGooseSwim() {
        Bird other = new Goose();
        // other.floatInWater(); // DOES NOT COMPILE in the book example
        // other.text; // DOES NOT COMPILE in the book example
        return "cannot access";
    }
}
