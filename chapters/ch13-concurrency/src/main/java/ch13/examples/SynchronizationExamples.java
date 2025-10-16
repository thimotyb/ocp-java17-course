package ch13.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Synchronization, locks, and concurrent collections.
 */
public final class SynchronizationExamples {

    private SynchronizationExamples() {
    }

    public static class Counter {

        private int count;

        public synchronized void increment() {
            count++;
        }

        public synchronized int getCount() {
            return count;
        }
    }

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

    public static List<Integer> synchronizedListExample() {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        list.add(1);
        list.add(2);
        return list;
    }

    public static ConcurrentMap<String, Integer> concurrentMapUsage() {
        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
        map.putIfAbsent("lion", 1);
        map.computeIfPresent("lion", (k, v) -> v + 1);
        map.computeIfAbsent("tiger", k -> 2);
        return map;
    }
}
