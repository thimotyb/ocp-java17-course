# Chapter 13 – Concurrency

## Learning Objectives
- Create and manage threads using `Thread`, `Runnable`, and `Callable`.
- Employ `ExecutorService` for task submission, synchronization, and graceful shutdown.
- Utilize thread-safe collections, locks, and atomic variables to prevent race conditions.
- Harness parallel streams to process large datasets while understanding performance trade-offs.

## Chapter Summary
### Thread Fundamentals
- Threads execute concurrently; create them by extending `Thread` or passing a `Runnable`. Synchronize shared state with `synchronized` or atomic classes.

### Executor Services
- `ExecutorService` decouples task submission from execution. Methods `submit`, `invokeAny`, and `invokeAll` support advanced execution patterns.
- Always shut down executors to avoid resource leaks (`shutdown`, `awaitTermination`, `shutdownNow`).

### Synchronization and Concurrency Utilities
- Use `synchronized`, `Lock`, and atomic classes (`AtomicInteger`) to provide thread-safe access.
- Concurrent collections (`ConcurrentHashMap`, `Collections.synchronizedList`) manage thread-safe data structures with improved performance.

### Parallel Streams
- Parallel streams split work across threads automatically; ensure operations are stateless, non-interfering, and associative for correctness.

## Practical Exercises
1. **Race Condition Demo** – Create an unsafe counter and observe non-deterministic results without synchronization.
2. **Scheduled Executors** – Extend examples with `ScheduledExecutorService` to run periodic tasks.
3. **Deadlock Detection** – Model a deadlock scenario and apply timeouts or reentrant locks to resolve it.
4. **Atomic vs. Synchronized** – Compare performance of atomics versus synchronized methods under load.
5. **Stream Performance** – Benchmark sequential and parallel stream processing to find when parallelism helps.

## Run the Examples
```bash
# Ensure Java 17 is active
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk use java 17.0.14-tem

# Compile the Chapter 13 module
mvn -pl chapters/ch13-concurrency compile

# Run the demo
java -cp chapters/ch13-concurrency/target/classes ch13.examples.Chapter13Demo

# Execute the tests
mvn -pl chapters/ch13-concurrency -Dtest='ch13.examples.*Test' test
```

## Exam Prep (1Z0-829 style)
1. Which class implements `Runnable` and returns no result?
   - A. `Callable`
   - B. `Runnable`
   - C. `Future`
   - D. `CompletableFuture`
2. What does `shutdown()` do on an `ExecutorService`?
   - A. Immediately interrupts running tasks.
   - B. Rejects new tasks but lets running tasks finish.
   - C. Blocks until tasks finish.
   - D. Throws an exception.
3. Which collection is thread-safe without wrapping?
   - A. `ArrayList`
   - B. `HashSet`
   - C. `ConcurrentHashMap`
   - D. `TreeMap`
4. When are parallel streams appropriate?
   - A. Always faster than sequential streams.
   - B. When operations are stateless, non-interfering, and associative.
   - C. Only on small datasets.
   - D. Only on I/O-bound tasks.
5. What does `invokeAll` return?
   - A. Single result
   - B. `List<Future<T>>`
   - C. `Optional<T>`
   - D. `CompletionStage<T>`

<details>
<summary>Answers</summary>
1: B  
2: B  
3: C  
4: B  
5: B  
</details>

## Next Steps
- Explore `CompletableFuture` for asynchronous pipelines.
- Investigate thread pools, fork/join, and concurrency performance tuning.
