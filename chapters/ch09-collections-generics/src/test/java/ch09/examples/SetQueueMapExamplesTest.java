package ch09.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Queue;

import org.junit.jupiter.api.Test;

class SetQueueMapExamplesTest {

    @Test
    void linkedHashSetPreservesOrder() {
        assertEquals(List.of("duck", "goose", "swan"), SetQueueMapExamples.preserveInsertionOrder().stream().toList());
    }

    @Test
    void treeNavigationProvidesNeighbors() {
        NavigableSet<Integer> numbers = SetQueueMapExamples.treeNavigation();
        assertEquals(4, numbers.higher(2));
        assertEquals(6, numbers.lower(8));
    }

    @Test
    void queuePollRemovesHead() {
        Queue<String> queue = SetQueueMapExamples.queueBehavior();
        assertEquals("two", queue.peek());
        assertEquals(2, queue.size());
    }

    @Test
    void dequePushPopActsAsStack() {
        ArrayDeque<String> deque = (ArrayDeque<String>) SetQueueMapExamples.dequeBehavior();
        assertEquals("front", deque.peekFirst());
        assertEquals("back", deque.peekLast());
    }

    @Test
    void mapOperationsDemonstrateMergeAndCompute() {
        Map<String, Integer> scores = SetQueueMapExamples.mapOperations();
        assertEquals(3, scores.get("lion"));
        assertEquals(6, scores.get("tiger"));
        assertEquals(3, scores.get("bear"));
    }

    @Test
    void treeMapOrdersKeys() {
        assertEquals(List.of("a", "b", "c", "d"), SetQueueMapExamples.treeMapOrdering().keySet().stream().toList());
        assertNull(SetQueueMapExamples.treeMapOrdering().lowerKey("a"));
    }
}
