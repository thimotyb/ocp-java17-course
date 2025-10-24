package ch05.examples.pond.goose;

import ch05.examples.pond.shore.Bird;

/**
 * Subclass example from Chapter 5 showing how a child class can access its inherited protected
 * members directly.
 */
public class Gosling extends Bird {

    /**
     * @return the inherited protected members, accessed without qualification per the book example
     */
    public String swim() {
        return floatInWater() + text;
    }
}
