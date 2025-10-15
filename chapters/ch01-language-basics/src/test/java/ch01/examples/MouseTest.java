package ch01.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MouseTest {

    @Test
    void growStopsAtMaximumLength() {
        Mouse mouse = new Mouse();
        mouse.grow(3);
        assertEquals(3, mouse.length);
        mouse.grow(3);
        assertEquals(6, mouse.length);
        mouse.grow(2);
        assertEquals(6, mouse.length);
    }
}
