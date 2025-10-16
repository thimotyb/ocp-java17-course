package ch07.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NestedTypeExamplesTest {

    @Test
    void staticNestedClassSharesOuterContext() {
        var status = new NestedTypeExamples.Enclosure.Status("Open");
        assertEquals("North status: Open", status.label());
    }

    @Test
    void innerClassCapturesOuterInstance() {
        var enclosure = new NestedTypeExamples.Enclosure("Aviary");
        var resident = enclosure.new Resident("Parrot");
        assertEquals("Aviary houses Parrot", resident.description());
    }

    @Test
    void localAndAnonymousClassesUseEffectivelyFinalVariables() {
        var enclosure = new NestedTypeExamples.Enclosure("Savannah");
        assertEquals("Alex completed 3 rounds in Savannah", enclosure.caretakerReport("Alex"));
        assertEquals("Savannah quiet down please", enclosure.anonymousCall());
    }
}
