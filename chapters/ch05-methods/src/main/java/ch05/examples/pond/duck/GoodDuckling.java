package ch05.examples.pond.duck;

/**
 * Shows the valid access combination from Chapter 5: classes in the same package can reach
 * package-private members ({@code MotherDuck.quack()} and {@code noise}).
 */
public class GoodDuckling {

    /**
     * @return the package-private {@code noise} retrieved after calling the package-private method
     */
    public String learnToQuack() {
        var mother = new MotherDuck();
        mother.quack();
        return mother.noise;
    }
}
