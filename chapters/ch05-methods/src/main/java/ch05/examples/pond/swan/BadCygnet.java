package ch05.examples.pond.swan;

import ch05.examples.pond.duck.MotherDuck;

/**
 * Contrasts package access with inheritance: being a subclass in another package is not enough to
 * reach package-private members of {@code MotherDuck}, echoing Chapter 5's warning.
 */
public class BadCygnet {

    /**
     * @return explanatory message; the commented code is intentionally uncompilable per the book
     */
    public String attemptNoise() {
        var duck = new MotherDuck();
        // duck.quack(); // DOES NOT COMPILE in the book example
        // return duck.noise; // DOES NOT COMPILE in the book example
        return "cannot access";
    }
}
