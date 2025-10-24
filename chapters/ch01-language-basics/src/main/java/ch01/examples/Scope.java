package ch01.examples;

/**
 * Evaluate eligibility for garbage collection
 */
public class Scope {
    
    public static void main(String[] args) {
        String one, two;
        one = new String("a");
        two = new String("b");
        one = two;
        String three = one;
        one = null;
    }

}
