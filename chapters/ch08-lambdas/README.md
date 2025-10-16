# Chapter 8 – Lambdas and Functional Interfaces

## Learning Objectives
- Translate traditional anonymous classes into lambda expressions and identify valid lambda syntax.
- Create custom functional interfaces and leverage `@FunctionalInterface` to enforce single abstract methods.
- Apply the common `java.util.function` interfaces and understand when to use each.
- Replace lambdas with method references to static methods, instance methods, and constructors.
- Manage variable scope inside lambdas, including effectively final variables and captured state.

## Chapter Summary
### Getting Started with Lambdas
- Lambdas provide inline implementations of functional interfaces; parameter types may be explicit, inferred, or declared with `var`.
- Bodies can be single expressions or blocks; a block requires an explicit `return` when a value is expected.

### Functional Interfaces
- A functional interface contains exactly one abstract method (SAM). Default and static methods do not count toward the SAM requirement.
- Annotate with `@FunctionalInterface` to catch accidental overloads.

### Built-in Functional Interfaces
- `Predicate`, `Consumer`, `Function`, `Supplier`, `UnaryOperator`, `BiPredicate`, `BiFunction`, `BiConsumer`, and `BinaryOperator` cover most common patterns.
- Compose functions using provided default methods like `andThen`, `compose`, `and`, and `or`.

### Method References
- Method references (`Type::staticMethod`, `type::instanceMethod`, `object::instanceMethod`, `Type::new`) provide concise alternatives to lambdas.
- Use them whenever the lambda simply calls an existing method.

### Variables and Scope
- Lambdas can access effectively final variables from the enclosing scope, but cannot reassign them.
- Mutable state can be captured via wrapper objects (e.g., `AtomicInteger`) or instance fields when necessary.

## Practical Exercises
1. **Filter Variations** – Extend `AnimalFilteringExamples` with a new trait (e.g., nocturnal) and verify filtering behaviour with both custom and built-in functional interfaces.
2. **Functional Composition** – Demonstrate `Predicate.negate()` and `Function.andThen()` using the utilities in `BuiltInFunctionalExamples` with additional tests.
3. **Method Reference Substitution** – Replace a lambda with an equivalent method reference in `MethodReferenceExamples` and ensure tests still pass.
4. **Scope Experiments** – Add an example using a loop variable inside a lambda, highlighting the need for effectively final semantics.
5. **Stream Integration** – Use the provided functional interfaces within a Stream pipeline that aggregates animal statistics.

## Run the Examples
```bash
# Ensure Java 17 is active
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk use java 17.0.14-tem

# Compile the Chapter 8 module
mvn -pl chapters/ch08-lambdas compile

# Run the demo
java -cp chapters/ch08-lambdas/target/classes ch08.examples.Chapter08Demo

# Execute the unit tests
mvn -pl chapters/ch08-lambdas -Dtest='ch08.examples.*Test' test
```

## Exam Prep (1Z0-829 style)
1. Which lambda is valid for `Predicate<String>`?
   - A. `s -> { s.isEmpty(); }`
   - B. `String s -> s.length() > 3`
   - C. `(String s) -> s.isBlank()`
   - D. `() -> true`
2. A functional interface declares one abstract method and one default method. How many lambdas can target it?
   - A. None
   - B. Exactly one
   - C. Any number (it remains functional)
   - D. Only if `@FunctionalInterface` is present
3. Which built-in functional interface returns a result of the same type as its argument?
   - A. `Consumer<T>`
   - B. `UnaryOperator<T>`
   - C. `Supplier<T>`
   - D. `Predicate<T>`
4. What does `Type::new` represent when used as a method reference?
   - A. A call to a static factory method
   - B. An object instance method reference
   - C. A constructor reference producing new instances
   - D. A default method reference
5. Why must captured local variables in lambdas be effectively final?
   - A. The JVM copies variable values into the lambda; reassignment would break consistency.
   - B. Performance optimization for streams.
   - C. To avoid `NullPointerException` at runtime.
   - D. To allow multiple return values.

<details>
<summary>Answers</summary>
1: C  
2: C  
3: B  
4: C  
5: A  
</details>

## Next Steps
- Build on these functional patterns in Chapter 9 for collections and Chapter 10 for streams.
- Experiment with composing built-in functional interfaces into utility libraries.
