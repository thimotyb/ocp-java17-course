package ch13.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Test;

class ExecutorExamplesTest {

    @Test
    void submitTasksReturnSquares() throws InterruptedException, ExecutionException {
        ExecutorService service = ExecutorExamples.singleThreadExecutor();
        try {
            assertEquals(java.util.List.of(0, 1, 4), ExecutorExamples.submitTasks(service, 3));
        } finally {
            ExecutorExamples.shutdownGracefully(service);
        }
    }

    @Test
    void invokeAnyReturnsOneResult() throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newCachedThreadPool();
        try {
            String result = ExecutorExamples.invokeAnyExample(service);
            assertTrue(result.equals("lion") || result.equals("tiger"));
        } finally {
            ExecutorExamples.shutdownGracefully(service);
        }
    }

    @Test
    void invokeAllReturnsAllResults() throws InterruptedException, ExecutionException {
        ExecutorService service = ExecutorExamples.fixedThreadPool(2);
        try {
            assertEquals(java.util.List.of("ape", "bear"), ExecutorExamples.invokeAllExample(service));
        } finally {
            ExecutorExamples.shutdownGracefully(service);
        }
    }
}
