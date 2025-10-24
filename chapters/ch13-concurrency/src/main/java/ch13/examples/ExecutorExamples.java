package ch13.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Implements the Chapter 13 "Using the Concurrency API" scenarios. Methods cover creating executor
 * services, submitting tasks, shutting down, and leveraging {@code invokeAny()} / {@code invokeAll()}.
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c13.xhtml">OCP Java SE 17 Study Guide – Chapter 13: Using Concurrency APIs</a>
 */
public final class ExecutorExamples {

    private ExecutorExamples() {
    }

    /**
     * @return single-thread executor produced with {@link Executors#newSingleThreadExecutor()}.
     */
    public static ExecutorService singleThreadExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    /**
     * @return fixed-size pool using {@link Executors#newFixedThreadPool(int)}.
     */
    public static ExecutorService fixedThreadPool(int size) {
        return Executors.newFixedThreadPool(size);
    }

    /**
     * Submits square-calculating callables and captures their results, showing future retrieval.
     */
    public static List<Integer> submitTasks(ExecutorService service, int tasks) throws InterruptedException, ExecutionException {
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < tasks; i++) {
            int value = i;
            futures.add(service.submit(() -> value * value));
        }
        List<Integer> results = new ArrayList<>();
        for (Future<Integer> future : futures) {
            results.add(future.get());
        }
        return results;
    }

    /**
     * Performs the orderly shutdown sequence recommended in the chapter (shutdown → await →
     * shutdownNow as fallback).
     */
    public static boolean shutdownGracefully(ExecutorService service) throws InterruptedException {
        service.shutdown();
        if (!service.awaitTermination(2, TimeUnit.SECONDS)) {
            service.shutdownNow();
        }
        return service.isShutdown();
    }

    /**
     * Demonstrates {@link ExecutorService#invokeAny(java.util.Collection)} returning the first result.
     */
    public static String invokeAnyExample(ExecutorService service) throws InterruptedException, ExecutionException {
        return service.invokeAny(List.of(() -> "lion", () -> "tiger"));
    }

    /**
     * Demonstrates {@link ExecutorService#invokeAll(java.util.Collection)} and collecting outputs.
     */
    public static List<String> invokeAllExample(ExecutorService service) throws InterruptedException, ExecutionException {
        List<Callable<String>> tasks = List.of(() -> "ape", () -> "bear");
        List<Future<String>> futures = service.invokeAll(tasks);
        List<String> results = new ArrayList<>();
        for (Future<String> future : futures) {
            results.add(future.get());
        }
        return results;
    }
}
