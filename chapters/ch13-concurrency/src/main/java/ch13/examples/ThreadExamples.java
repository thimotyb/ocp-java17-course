package ch13.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Revisits the Chapter 13 "Introducing Threads" listings. Demonstrates creating {@link Thread}
 * instances, implementing {@link Runnable}, and joining to wait for completion.
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c13.xhtml">OCP Java SE 17 Study Guide – Chapter 13: Introducing Threads</a>
 */
public final class ThreadExamples {

    private ThreadExamples() {
    }

    /** Runnable implementation used to print a message multiple times. */
    public static class PrintTask implements Runnable {

        private final String message;

        public PrintTask(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println(message + " " + i);
            }
        }
    }

    /**
     * @return new non-daemon thread wrapping the {@link PrintTask}, matching the chapter's example.
     */
    public static Thread newThread(String message) {
        Thread thread = new Thread(new PrintTask(message));
        thread.setDaemon(false);
        return thread;
    }

    /**
     * Executes a lambda-based thread and captures its output, reinforcing {@link Thread#start()} vs
     * {@link Thread#run()} and use of {@link Thread#join()}.
     */
    public static List<String> runAndCapture() throws InterruptedException {
        List<String> log = new ArrayList<>();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                log.add("worker-" + i);
            }
        });
        thread.start();
        thread.join();
        return log;
    }
}
