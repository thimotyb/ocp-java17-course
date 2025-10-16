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
 * Demonstrates ExecutorService usage from Chapter 13.
 */
public final class ExecutorExamples {

    private ExecutorExamples() {
    }

    public static ExecutorService singleThreadExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    public static ExecutorService fixedThreadPool(int size) {
        return Executors.newFixedThreadPool(size);
    }

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

    public static boolean shutdownGracefully(ExecutorService service) throws InterruptedException {
        service.shutdown();
        if (!service.awaitTermination(2, TimeUnit.SECONDS)) {
            service.shutdownNow();
        }
        return service.isShutdown();
    }

    public static String invokeAnyExample(ExecutorService service) throws InterruptedException, ExecutionException {
        return service.invokeAny(List.of(() -> "lion", () -> "tiger"));
    }

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
