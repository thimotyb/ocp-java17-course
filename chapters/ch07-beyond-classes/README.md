# Chapter 7 – Beyond Classes

## Learning Objectives
- Declare interfaces with implicit modifiers, implement multiple interfaces, and resolve default-method conflicts.
- Use private, static, and default interface methods, plus functional interfaces suitable for lambda expressions.
- Model domain data with enums, sealed hierarchies, and records while maintaining encapsulation and immutability.
- Differentiate nested type flavours (static nested, inner, local, anonymous) and understand their scoping rules.
- Apply polymorphism rules when combining classes, interfaces, and sealed hierarchies.

## Chapter Summary
### Interfaces
- Interfaces are implicitly `abstract`; their fields are `public static final`, and abstract methods are implicitly `public`.
- A class may implement multiple interfaces; an interface may extend multiple interfaces. All abstract members must be implemented by the first concrete class.
- Default methods supply reusable behaviour but must be overridden to break conflicts. Interface static and private helpers support encapsulated reuse.

### Functional Interfaces
- A functional interface declares exactly one abstract method; annotate with `@FunctionalInterface` to enforce the contract.
- Lambdas and method references can target functional interfaces, with default/static methods available alongside the single abstract method.

### Enums, Records, and Sealed Types
- Enums declare constructors, fields, and even abstract methods per constant, and default to `static final` instances.
- Records provide concise immutable carriers; the canonical constructor can validate inputs, while compact constructors adjust state pre-assignment.
- Sealed classes/interfaces restrict permitted subclasses, balancing extensibility with exhaustive pattern handling.

### Encapsulation and Immutability
- Keep mutable state `private`, expose defensive copies or read-only views, and prefer constructors for mandatory state.
- Use helper builders or records to avoid telescoping constructors while maintaining invariants.

### Nested and Inner Types
- Static nested classes behave like top-level classes namespaced inside the outer class. Inner classes capture an instance; local and anonymous classes capture effectively final locals.
- Anonymous classes implement single-use custom behaviour; lambdas can replace them when targeting functional interfaces.

## Practical Exercises
1. **Default Conflicts** – Add a second interface with a clashing default method in `InterfaceConflictExamples` and implement the explicit override to pick one implementation.
2. **Sealed Expansion** – Introduce a new permitted subclass in `SealedZooExamples` and verify pattern matching handles it.
3. **Record Validation** – Extend `AnimalRecordExamples` with a compact constructor that normalises text, then assert the result in tests.
4. **Enum Strategy** – Add an enum constant with a distinct override in `FeedingSchedule` and validate behaviour via tests.
5. **Nested Types** – Create a new method in `NestedTypeExamples` that returns the noise from an anonymous class, and assert the captured variables remain effectively final.

## Run the Examples
```bash
# Ensure Java 17 is active
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk use java 17.0.14-tem

# Compile the Chapter 7 module
mvn -pl chapters/ch07-beyond-classes compile

# Run the demo
java -cp chapters/ch07-beyond-classes/target/classes ch07.examples.Chapter07Demo

# Execute the unit tests
mvn -pl chapters/ch07-beyond-classes -Dtest='ch07.examples.*Test' test
```

## Exam Prep (1Z0-829 style)
1. Which modifier is implicitly applied to interface fields?
   - A. `protected`
   - B. `static`
   - C. `volatile`
   - D. `transient`
2. Two interfaces define default `void fly()`. A class implements both and supplies no override. What happens?
   - A. It inherits the first interface’s method.
   - B. Compilation fails due to ambiguity.
   - C. The JVM chooses one at runtime.
   - D. The class becomes abstract automatically.
3. Which feature is unique to records compared to classes?
   - A. Allowing static fields
   - B. Automatically generated canonical constructor, accessors, and `equals/hashCode`
   - C. Ability to implement interfaces
   - D. Support for mutable instance fields
4. What must a sealed class declare?
   - A. `final` subclasses only
   - B. A `permits` clause or nested permitted types
   - C. A private constructor
   - D. A companion record
5. Where may an anonymous class access a local variable from the enclosing scope?
   - A. Always—no restrictions
   - B. Only if the variable is `static`
   - C. Only if the variable is effectively final
   - D. Only inside constructors

<details>
<summary>Answers</summary>
1: B  
2: B  
3: B  
4: B  
5: C  
</details>

## Next Steps
- Continue with Chapter 8 to cover lambdas and functional interfaces in depth.
- Revisit earlier chapters to connect polymorphism and sealed hierarchies with pattern matching in Chapter 11.
