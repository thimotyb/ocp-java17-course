package ch13.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class ThreadExamplesTest {

    @Test
    void newThreadIsNotDaemon() {
        Thread thread = ThreadExamples.newThread("test");
        assertFalse(thread.isDaemon());
    }

    @Test
    void runAndCaptureCompletes() throws InterruptedException {
        assertEquals(3, ThreadExamples.runAndCapture().size());
    }
}
