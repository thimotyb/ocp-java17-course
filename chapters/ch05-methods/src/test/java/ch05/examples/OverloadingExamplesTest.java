package ch05.examples;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class OverloadingExamplesTest {

    @Test
    void pelicanPrefersMostSpecificMethod() {
        assertEquals(java.util.List.of("string", "object"), new OverloadingExamples.Pelican().evaluateCalls());
    }

    @Test
    void parrotShowsCharSequenceAndObjectResolution() {
        assertEquals("CIO", OverloadingExamples.Parrot.demonstrate());
    }

    @Test
    void ostrichChoosesExactPrimitiveMatch() {
        var ostrich = new OverloadingExamples.Ostrich();
        assertEquals("int", ostrich.fly(123));
        assertEquals("long", ostrich.fly(123L));
    }

    @Test
    void kiwiPrefersPrimitiveOverAutoboxing() {
        var kiwi = new OverloadingExamples.Kiwi();
        assertEquals("int", kiwi.fly(5));
    }

    @Test
    void falconMethodsAllowDifferentSignatures() throws Exception {
        var falcon = new OverloadingExamples.Falcon();
        assertEquals("int", falcon.fly(1));
        assertEquals("short", falcon.fly((short) 1));
        falcon.fly((short) 1, 5);
    }

    @Test
    void gorillaRestRequiresLongWrapper() {
        assertThrows(NoSuchMethodException.class, () -> OverloadingExamples.Gorilla.class.getDeclaredMethod("rest", long.class));
        new OverloadingExamples.Gorilla().rest(Long.valueOf(8));
    }

    @Test
    void gliderUsesMostSpecificRuleOrder() {
        assertArrayEquals(new String[] {"1", "4", "2"}, OverloadingExamples.Glider.demonstrate());
    }
}
