package ch05.examples.pond.swan;

import ch05.examples.pond.duck.MotherDuck;

public class BadCygnet {

    public String attemptNoise() {
        var duck = new MotherDuck();
        // duck.quack(); // DOES NOT COMPILE in the book example
        // return duck.noise; // DOES NOT COMPILE in the book example
        return "cannot access";
    }
}
