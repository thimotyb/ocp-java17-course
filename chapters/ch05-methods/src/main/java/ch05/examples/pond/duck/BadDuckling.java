package ch05.examples.pond.duck;

public class BadDuckling {

    public String attemptMakeNoise() {
        var father = new FatherDuck();
        // father.quack(); // DOES NOT COMPILE in the book example
        // return father.noise; // DOES NOT COMPILE in the book example
        father.callPrivateMembers();
        return "cannot access";
    }
}
