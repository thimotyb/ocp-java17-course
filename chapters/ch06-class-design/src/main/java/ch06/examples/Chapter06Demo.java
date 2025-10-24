package ch06.examples;

/**
 * Convenience launcher that runs a sampling of the Chapter 6 examples so students can watch the
 * printed output that the book describes (weights, initialization order, and polymorphic results).
 */
public final class Chapter06Demo {

    private Chapter06Demo() {
    }

    public static void main(String[] args) {
        var jaguar = new InheritanceExamples.Jaguar();
        System.out.println("Jaguar size: " + jaguar.printDetails());

        var hamster = new ConstructorExamples.Hamster(2);
        System.out.println("Hamster weight/color: " + hamster.getWeight() + "/" + hamster.getColor());

        InitializationExamples.clearOutput();
        InitializationExamples.hippoSequence();
        System.out.println("Hippo init order: " + InitializationExamples.getOutput());

        var kangaroo = new MethodInheritanceExamples.Kangaroo();
        System.out.println("Kangaroo average weight: " + kangaroo.getAverageWeight());

        var lion = new AbstractExamples.Lion();
        System.out.println("Lion roar ready for: " + lion.getName());
    }
}
