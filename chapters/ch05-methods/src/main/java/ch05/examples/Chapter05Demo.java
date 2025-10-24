package ch05.examples;

/**
 * Convenience launcher that stitches together the Chapter 5 code listings so learners can observe
 * the output from the varargs, static data, and overload resolution examples in one run.
 */
public final class Chapter05Demo {

    private Chapter05Demo() {
    }

    public static void main(String[] args) {
        var dogSteps = VarargsExamples.DogWalker.walkDog(1, 2, 3);
        System.out.println("Dog walked segments: " + dogSteps);

        var penguin1 = new StaticExamples.Penguin();
        penguin1.setName("Lilly");
        StaticExamples.Penguin.setNameOfTallestPenguin("Lilly");
        System.out.println("Tallest penguin so far: " + StaticExamples.Penguin.getNameOfTallestPenguin());

        var gliderResults = OverloadingExamples.Glider.demonstrate();
        System.out.println("Glider overload resolution: " + String.join(",", gliderResults));
    }
}
