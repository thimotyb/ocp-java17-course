# Chapter 9 – Collections and Generics

## Learning Objectives
- Choose appropriate collection types (`List`, `Set`, `Queue`, `Map`, `Deque`) and apply their common operations.
- Sort data using `Comparable`, `Comparator`, and collection helpers such as `Collections.sort()` and `binarySearch()`.
- Leverage `java.util` iterators, navigation methods, and map bulk operations (`compute`, `merge`, `putIfAbsent`).
- Create reusable generic classes, interfaces, and methods, including bounded and wildcard parameters.
- Recognise raw-type pitfalls and enforce type safety using generics.

## Chapter Summary
### Core Collection APIs
- `List` preserves order and may contain duplicates; `Arrays.asList()` returns a fixed-size view, while `List.of()` returns an immutable list.
- `Set` eliminates duplicates; `LinkedHashSet` preserves insertion order and `TreeSet` keeps elements sorted with navigation helpers (`higher`, `lower`).
- `Queue`/`Deque` differentiate between FIFO (`offer`, `poll`, `peek`) and stack-like (`push`, `pop`) operations.
- `Map` stores key/value pairs; `putIfAbsent`, `compute`, and `merge` simplify conditional updates.

### Sorting and Searching
- Implement `Comparable<T>` for natural ordering; use `Comparator` for custom orderings and chaining (`reversed`, `thenComparing`).
- `Collections.binarySearch()` requires the list to be sorted according to the same ordering used for searching.

### Generics Fundamentals
- Generic classes and interfaces (`Crate<T>`, `Shippable<T>`) store typed values without casts.
- Generic methods (`<T> T identity(T value)`) enable reusable logic across types.
- Upper-bounded wildcards (`? extends Number`) read safely; lower-bounded (`? super Integer`) allow controlled mutation.
- Raw types avoid compile-time checks and should be avoided; they may cause `ClassCastException` at runtime.

## Practical Exercises
1. **List Utilities** – Implement reverse sorting and sublist extraction using `ListExamples` and verify search indices.
2. **Set/Map Drill** – Experiment with `NavigableSet` floor/ceiling operations and `TreeMap` view methods (e.g., `headMap`).
3. **Comparator Practice** – Create a comparator that groups animals by name length before alphabetical order.
4. **Wildcard Clinic** – Implement a copy method using `? super T` and add unit tests showing type flexibility.
5. **Deque as Stack** – Demonstrate undo/redo behaviour using `ArrayDeque` push/pop operations.

## Run the Examples
```bash
# Ensure Java 17 is active
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk use java 17.0.14-tem

# Compile the Chapter 9 module
mvn -pl chapters/ch09-collections-generics compile

# Run the demo
java -cp chapters/ch09-collections-generics/target/classes ch09.examples.Chapter09Demo

# Execute the tests
mvn -pl chapters/ch09-collections-generics -Dtest='ch09.examples.*Test' test
```

## Exam Prep (1Z0-829 style)
1. Which `List` factory method returns an immutable list?
   - A. `Arrays.asList()`
   - B. `List.of()`
   - C. `Collections.unmodifiableList(new ArrayList<>())`
   - D. `new ArrayList<>()`
2. What does `Queue.poll()` return when the queue is empty?
   - A. Throws an exception
   - B. Returns `null`
   - C. Returns a sentinel value
   - D. Blocks until an element is available
3. What does `Comparable` provide that `Comparator` does not?
   - A. Ability to sort without external comparator
   - B. Multiple ordering strategies
   - C. Access to stream operations
   - D. Reverse ordering by default
4. Which wildcard allows adding an `Integer` value to a collection parameter?
   - A. `List<?>`
   - B. `List<? extends Number>`
   - C. `List<? super Integer>`
   - D. `List<Integer>` only
5. What risk arises from using raw types?
   - A. Slower iteration
   - B. Increased memory usage
   - C. Loss of compile-time type checking, leading to potential `ClassCastException`
   - D. Inability to use streams

<details>
<summary>Answers</summary>
1: B  
2: B  
3: A  
4: C  
5: C  
</details>

## Next Steps
- Combine these collections and generics concepts with streams in Chapter 10.
- Practice implementing custom collection utilities that exploit generics for type safety.
