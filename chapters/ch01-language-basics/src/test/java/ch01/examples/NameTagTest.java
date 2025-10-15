package ch01.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NameTagTest {

    @Test
    void combinesFieldsOnInitialization() {
        NameTag name = new NameTag();
        assertEquals("Theodore", name.first);
        assertEquals("Moose", name.last);
        assertEquals("TheodoreMoose", name.full);
    }
}
