package ch07.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class InterfaceBasicsExamplesTest {

    @Test
    void fieldMouseImplementsCompatibleMethods() {
        var mouse = new InterfaceBasicsExamples.FieldMouse();
        assertEquals(5.5f, mouse.getSpeed(1));
        assertEquals(8.0f, mouse.getSpeed(5));
    }

    @Test
    void owlImplementsMultipleInterfaces() {
        var owl = new InterfaceBasicsExamples.Owl();
        assertEquals(5, owl.hunt());
    }

    @Test
    void commonSealImplementsInheritedMethods() {
        var seal = new InterfaceBasicsExamples.CommonSeal();
        assertEquals(15, seal.getTailLength());
        assertEquals(24, seal.getNumberOfWhiskers());
    }

    @Test
    void bearImplementsDuplicateAbstractMethods() {
        new InterfaceBasicsExamples.Bear().eatPlants();
    }
}
