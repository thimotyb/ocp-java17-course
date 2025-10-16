package ch13.examples;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class Chapter13Demo {

    private Chapter13Demo() {
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadExamples.newThread("Demo thread").start();

        ExecutorService service = ExecutorExamples.fixedThreadPool(2);
        System.out.println("Squares: " + ExecutorExamples.submitTasks(service, 3));
        ExecutorExamples.shutdownGracefully(service);

        System.out.println("Atomic count: " + SynchronizationExamples.atomicCounter(5));
        System.out.println("Parallel squares: " + ParallelStreamExamples.parallelSquares(5));
    }
}
