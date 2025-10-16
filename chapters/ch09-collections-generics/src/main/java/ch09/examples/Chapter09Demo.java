package ch09.examples;

import java.util.List;

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
