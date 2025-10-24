package ch13.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Demonstrates synchronization constructs from Chapter 13 "Managing Concurrency" including
 * intrinsic locks, atomic variables, synchronized wrappers, and concurrent collections.
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c13.xhtml">OCP Java SE 17 Study Guide – Chapter 13: Managing Concurrency</a>
 */
public final class SynchronizationExamples {

    private SynchronizationExamples() {
    }

    /** Simple synchronized counter shared across threads. */
    public static class Counter {

        private int count;

        public synchronized void increment() {
            count++;
        }

        public synchronized int getCount() {
            return count;
        }
    }

    /**
     * Uses {@link AtomicInteger} to safely increment across multiple threads without explicit locks.
     */
    public static int atomicCounter(int iterations) {
        AtomicInteger atomic = new AtomicInteger();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < iterations; i++) {
            threads.add(new Thread(atomic::incrementAndGet));
        }
        threads.forEach(Thread::start);
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        return atomic.get();
    }

    /** @return synchronized list wrapper produced by {@link Collections#synchronizedList(List)}. */
    public static List<Integer> synchronizedListExample() {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        list.add(1);
        list.add(2);
        return list;
    }

    /**
     * @return {@link ConcurrentHashMap} after performing {@code putIfAbsent}, {@code computeIfPresent},
     *     and {@code computeIfAbsent} operations.
     */
    public static ConcurrentMap<String, Integer> concurrentMapUsage() {
        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
        map.putIfAbsent("lion", 1);
        map.computeIfPresent("lion", (k, v) -> v + 1);
        map.computeIfAbsent("tiger", k -> 2);
        return map;
    }
}
