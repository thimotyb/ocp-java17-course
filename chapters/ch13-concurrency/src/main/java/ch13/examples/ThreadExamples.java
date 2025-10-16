package ch13.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Basic thread creation and lifecycle examples.
 */
public final class ThreadExamples {

    private ThreadExamples() {
    }

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

    public static Thread newThread(String message) {
        Thread thread = new Thread(new PrintTask(message));
        thread.setDaemon(false);
        return thread;
    }

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
