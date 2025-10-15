package ch01.scope;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class ScopePlaygroundTest {

    private final ScopePlayground playground = new ScopePlayground();

    @Test
    void collectsMessagesWhenHungry() {
        List<String> messages = playground.collectScopeMessages(true, 3);
        assertIterableEquals(List.of(
                "hungry=true",
                "bites=1",
                "consumed=3",
                "final=base-extended"
        ), messages);
    }

    @Test
    void collectsMessagesWhenNotHungry() {
        List<String> messages = playground.collectScopeMessages(false, 0);
        assertEquals(3, messages.size());
        assertEquals("hungry=false", messages.get(0));
        assertTrue(messages.stream().noneMatch(msg -> msg.startsWith("bites")));
    }

    @Test
    void calculatePortionsConsumesInStepsOfTwo() {
        assertEquals(0, playground.calculatePortions(-1));
        assertEquals(2, playground.calculatePortions(2));
        assertEquals(5, playground.calculatePortions(5));
    }

    @Test
    void branchInitializationEnsuresValueAssigned() {
        assertTrue(playground.branchInitialization(true));
        assertTrue(playground.branchInitialization(false));
    }
}
