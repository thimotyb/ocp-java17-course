package ch09.examples;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Demonstrates set, queue/deque, and map behaviours.
 */
public final class SetQueueMapExamples {

    private SetQueueMapExamples() {
    }

    public static Set<String> preserveInsertionOrder() {
        Set<String> birds = new LinkedHashSet<>();
        birds.add("duck");
        birds.add("goose");
        birds.add("duck");
        birds.add("swan");
        return birds;
    }

    public static NavigableSet<Integer> treeNavigation() {
        NavigableSet<Integer> numbers = new TreeSet<>();
        numbers.addAll(Set.of(2, 4, 6, 8));
        return numbers;
    }

    public static Queue<String> queueBehavior() {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        queue.poll();
        return queue;
    }

    public static Deque<String> dequeBehavior() {
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("front");
        deque.addLast("back");
        deque.push("top");
        deque.pop();
        return deque;
    }

    public static Map<String, Integer> mapOperations() {
        Map<String, Integer> scores = new LinkedHashMap<>();
        scores.put("lion", 3);
        scores.putIfAbsent("tiger", 5);
        scores.compute("tiger", (k, v) -> v + 1);
        scores.merge("bear", 2, Integer::sum);
        scores.merge("bear", 1, Integer::sum);
        return scores;
    }

    public static TreeMap<String, Integer> treeMapOrdering() {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("d", 4);
        map.put("b", 2);
        map.put("a", 1);
        map.put("c", 3);
        return map;
    }
}
