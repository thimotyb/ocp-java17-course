package ch01.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ChickenTest {

    @Test
    void initializesFieldsInConstructorAndOnDeclaration() {
        Chicken chicken = new Chicken();
        assertEquals(12, chicken.numEggs);
        assertEquals("Duke", chicken.name);
    }
}
