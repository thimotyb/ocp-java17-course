package ch06.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class InheritanceExamplesTest {

    @Test
    void jaguarInheritsProtectedSize() {
        var jaguar = new InheritanceExamples.Jaguar();
        assertEquals(10.2, jaguar.printDetails(), 0.0001);
    }

    @Test
    void flamingoUsesThisReference() {
        var flamingo = new InheritanceExamples.Flamingo();
        flamingo.setColor("PINK");
        assertEquals("PINK", flamingo.getColor());
    }

    @Test
    void duckDataSummaryRevealsShadowing() {
        var duck = new InheritanceExamples.DuckData();
        duck.setData(1, 2);
        assertEquals("0 2 white", duck.summary());
    }

    @Test
    void crocodileAccessesParentSpeed() {
        var croc = new InheritanceExamples.Crocodile();
        assertEquals(20, croc.getSpeed());
        assertEquals(10, croc.getParentSpeed());
    }

    @Test
    void giftShopSelectsParentAndChildLabels() {
        var shop = new InheritanceExamples.GiftShop();
        assertEquals("Gift Shop-Gift Shop-Zoo", shop.printData());
    }
}
