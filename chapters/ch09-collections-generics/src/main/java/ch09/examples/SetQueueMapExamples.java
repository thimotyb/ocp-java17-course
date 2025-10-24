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
 * Groups together the set, queue/deque, and map demonstrations from Chapter 9 "Understanding Sets",
 * "Working with Queues and Deques", and "Processing Maps". Each method mirrors the operations the
 * book highlights for exam preparation.
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c09.xhtml">OCP Java SE 17 Study Guide – Chapter 9</a>
 */
public final class SetQueueMapExamples {

    private SetQueueMapExamples() {
    }

    /**
     * @return {@link LinkedHashSet} sample showing duplicate elimination while preserving insertion
     *     order
     */
    public static Set<String> preserveInsertionOrder() {
        Set<String> birds = new LinkedHashSet<>();
        birds.add("duck");
        birds.add("goose");
        birds.add("duck");
        birds.add("swan");
        return birds;
    }

    /**
     * @return {@link NavigableSet} illustrating sorting and navigation capabilities of
     *     {@link TreeSet}
     */
    public static NavigableSet<Integer> treeNavigation() {
        NavigableSet<Integer> numbers = new TreeSet<>();
        numbers.addAll(Set.of(2, 4, 6, 8));
        return numbers;
    }

    /**
     * @return queue after enqueue/dequeue operations, backing the explanation of FIFO structures
     */
    public static Queue<String> queueBehavior() {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        queue.poll();
        return queue;
    }

    /**
     * @return deque state after stack-like and queue-like operations, mirroring the dual-ended usage
     */
    public static Deque<String> dequeBehavior() {
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("front");
        deque.addLast("back");
        deque.push("top");
        deque.pop();
        return deque;
    }

    /**
     * @return map populated using {@link Map#put(Object, Object)}, {@link Map#putIfAbsent(Object, Object)},
     *     {@link Map#compute(Object, java.util.function.BiFunction)}, and {@link Map#merge(Object, Object, java.util.function.BiFunction)}
     */
    public static Map<String, Integer> mapOperations() {
        Map<String, Integer> scores = new LinkedHashMap<>();
        scores.put("lion", 3);
        scores.putIfAbsent("tiger", 5);
        scores.compute("tiger", (k, v) -> v + 1);
        scores.merge("bear", 2, Integer::sum);
        scores.merge("bear", 1, Integer::sum);
        return scores;
    }

    /**
     * @return {@link TreeMap} showing natural key ordering, reinforcing the sorted-map discussion
     */
    public static TreeMap<String, Integer> treeMapOrdering() {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("d", 4);
        map.put("b", 2);
        map.put("a", 1);
        map.put("c", 3);
        return map;
    }
}
