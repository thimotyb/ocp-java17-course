package ch05.examples.pond.duck;

public class GoodDuckling {

    public String learnToQuack() {
        var mother = new MotherDuck();
        mother.quack();
        return mother.noise;
    }
}
