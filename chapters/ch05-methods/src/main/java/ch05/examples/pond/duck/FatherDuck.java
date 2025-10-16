package ch05.examples.pond.duck;

public class FatherDuck {

    private final String noise = "quack";

    private void quack() {
        // prints inside class only
    }

    public String callPrivateMembers() {
        quack();
        return noise;
    }
}
