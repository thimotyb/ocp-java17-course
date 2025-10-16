package ch05.examples.pond.goose;

public class GooseWatcher {

    public String watch() {
        Goose goose = new Goose();
        // goose.floatInWater(); // DOES NOT COMPILE in the book example
        return "cannot access";
    }
}
