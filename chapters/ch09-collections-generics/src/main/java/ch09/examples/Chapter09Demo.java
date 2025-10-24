package ch09.examples;

import java.util.List;

/**
 * Console harness that executes a sampling of Chapter 9 collection and generics snippets so learners
 * can see the runtime effects described in the study guide.
 */
public final class Chapter09Demo {

    private Chapter09Demo() {
    }

    public static void main(String[] args) {
        System.out.println("Mutable animals: " + ListExamples.mutableAnimals());
        System.out.println("LinkedHashSet order: " + SetQueueMapExamples.preserveInsertionOrder());

        var animals = List.of(
            new ComparatorExamples.Animal("lion", 190),
            new ComparatorExamples.Animal("antelope", 80)
        );
        System.out.println("Sorted natural: " + ComparatorExamples.sortNatural(animals));

        var crate = new GenericsExamples.Crate<String>();
        crate.pack("Bananas");
        System.out.println("Crate contents: " + crate.unpack());
    }
}
