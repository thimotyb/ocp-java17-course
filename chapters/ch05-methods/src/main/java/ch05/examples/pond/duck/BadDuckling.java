package ch05.examples.pond.duck;

/**
 * Demonstrates the Chapter 5 rule that {@code private} members in {@code FatherDuck} are
 * inaccessible, even to classes within the same package.
 */
public class BadDuckling {

    /**
     * @return a message explaining the access failure; the commented lines match the book's
     *     compilation errors.
     */
    public String attemptMakeNoise() {
        var father = new FatherDuck();
        // father.quack(); // DOES NOT COMPILE in the book example
        // return father.noise; // DOES NOT COMPILE in the book example
        father.callPrivateMembers();
        return "cannot access";
    }
}
