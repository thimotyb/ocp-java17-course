# Chapter 10 – Streams

## Learning Objectives
- Construct stream pipelines that source, transform, and terminate data using intermediate and terminal operations.
- Work with `Optional` to represent optional results and chain operations safely.
- Differentiate object streams and primitive streams (`IntStream`, `LongStream`, `DoubleStream`) and use their specialised operations.
- Apply common collectors (`groupingBy`, `partitioningBy`, `joining`, `toMap`) and reduction operations.
- Understand pipeline behaviour: laziness, side-effect awareness, and order of execution.

## Chapter Summary
### Optional Essentials
- `Optional` encapsulates a possible absence of value. Create with `Optional.empty()`, `Optional.of()`, or `Optional.ofNullable()` and unwrap with `orElse`, `orElseGet`, or `orElseThrow`.

### Stream Basics
- A stream pipeline consists of a source, zero or more intermediate operations (e.g. `filter`, `map`, `distinct`, `sorted`), and a terminal operation (`forEach`, `collect`, `reduce`).
- Streams are lazy; intermediate operations do nothing until a terminal operation triggers execution.

### Primitive Streams
- `IntStream`, `LongStream`, and `DoubleStream` avoid boxing overhead and offer numeric helpers (`sum`, `average`, `summaryStatistics`). Use `mapToInt`, `mapToLong`, or `mapToDouble` to convert.

### Collectors and Reduction
- `collect()` with `Collectors` supports grouping (`groupingBy`), partitioning (`partitioningBy`), joining strings, and building maps (`toMap`, `mapping`).
- `reduce()` combines elements into a single result via associative accumulation, optionally with an identity value.

### Infinite Streams
- `Stream.generate()` and `Stream.iterate()` can create infinite streams; use `limit`, `skip`, or short-circuiting terminal operations to prevent unbounded processing.

## Practical Exercises
1. **Pipeline Practice** – Add a pipeline that filters mammals by weight, maps to names, and collects to a sorted set.
2. **Collector Exploration** – Use `collectingAndThen` to create an immutable list after grouping animals by length.
3. **Optional Chains** – Compose `Optional` operations (`map`, `flatMap`, `filter`) to look up values across nested maps.
4. **Primitive Streams** – Compute variance using primitive stream operations.
5. **Custom Collector** – Implement a custom collector to accumulate stream results into a delimited string with a prefix/suffix.

## Run the Examples
```bash
# Ensure Java 17 is active
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk use java 17.0.14-tem

# Compile the Chapter 10 module
mvn -pl chapters/ch10-streams compile

# Run the demo
java -cp chapters/ch10-streams/target/classes ch10.examples.Chapter10Demo

# Execute the tests
mvn -pl chapters/ch10-streams -Dtest='ch10.examples.*Test' test
```

## Exam Prep (1Z0-829 style)
1. What is true about intermediate operations?
   - A. They execute immediately when called.
   - B. They are lazy and only run when a terminal operation executes.
   - C. They must be stateful to work.
   - D. Each pipeline may contain at most one intermediate operation.
2. Which operation short-circuits a stream?
   - A. `map`
   - B. `sorted`
   - C. `findFirst`
   - D. `peek`
3. Which primitive stream method returns summary information for all elements?
   - A. `stats()`
   - B. `summaryStatistics()`
   - C. `collect`
   - D. `inspect`
4. What happens if a `Stream` pipeline lacks a terminal operation?
   - A. It throws an exception.
   - B. Intermediate operations run twice when the pipeline closes.
   - C. Nothing executes; intermediate operations remain lazy.
   - D. The JVM optimises the pipeline away at compile time.
5. Which collector partitions data into two lists based on a predicate?
   - A. `Collectors.partitioningBy`
   - B. `Collectors.groupingBy`
   - C. `Collectors.toMap`
   - D. `Collectors.mapping`

<details>
<summary>Answers</summary>
1: B  
2: C  
3: B  
4: C  
5: A  
</details>

## Next Steps
- Combine streams with parallel processing and collectors introduced in later chapters.
- Practice custom `Collector` implementations to deepen understanding of reduction mechanics.
