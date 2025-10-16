package ch13.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SynchronizationExamplesTest {

    @Test
    void counterSynchronizesAccess() throws InterruptedException {
        SynchronizationExamples.Counter counter = new SynchronizationExamples.Counter();
        Thread t1 = new Thread(counter::increment);
        Thread t2 = new Thread(counter::increment);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        assertEquals(2, counter.getCount());
    }

    @Test
    void atomicCounterIncrements() {
        assertEquals(5, SynchronizationExamples.atomicCounter(5));
    }

    @Test
    void concurrentMapOperations() {
        var map = SynchronizationExamples.concurrentMapUsage();
        assertEquals(2, map.get("lion"));
        assertEquals(2, map.get("tiger"));
    }

    @Test
    void synchronizedListWrapsList() {
        assertEquals(java.util.List.of(1, 2), SynchronizationExamples.synchronizedListExample());
    }
}
