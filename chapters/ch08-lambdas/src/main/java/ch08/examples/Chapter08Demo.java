package ch08.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple command-line harness that wires together the Chapter 8 lambda and method-reference
 * listings so students can observe the behaviour described in the study guide.
 */
public final class Chapter08Demo {

    private Chapter08Demo() {
    }

    public static void main(String[] args) {
        var animals = AnimalFilteringExamples.sampleAnimals();
        System.out.println("Hoppers: " + AnimalFilteringExamples.filterAnimals(animals, AnimalFilteringExamples.Animal::canHop));

        BuiltInFunctionalExamples.listAppender(new ArrayList<>()).accept("Giraffe");

        var penguins = MethodReferenceExamples.createPenguins(List.of("Skipper", "Kowalski"));
        System.out.println("Penguins: " + penguins.stream().map(MethodReferenceExamples.Penguin::name).toList());

        System.out.println("Concatenated: " + VariableScopeExamples.concatenate(List.of("lambda", "s")));
    }
}
