package ch08.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class MethodReferenceExamplesTest {

    @Test
    void methodReferencesMapToFunctionalInterfaces() {
        var penguin = new MethodReferenceExamples.Penguin("Skipper");
        assertEquals("Penguin:Skipper", MethodReferenceExamples.staticReference().apply(penguin));
        assertEquals("Skipper", MethodReferenceExamples.instanceReference().apply(penguin));
        assertEquals("Skipper slides on ice", MethodReferenceExamples.arbitraryInstanceReference().apply(penguin, "ice"));
        assertEquals("Unnamed", MethodReferenceExamples.constructorReference().get().name());
        List<MethodReferenceExamples.Penguin> penguins = MethodReferenceExamples.createPenguins(List.of("Rico", "Private"));
        assertEquals(List.of("Rico", "Private"), penguins.stream().map(MethodReferenceExamples.Penguin::name).toList());
    }
}
