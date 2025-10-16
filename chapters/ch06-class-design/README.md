# Chapter 6 – Class Design

## Learning Objectives
- Differentiate between inherited, hidden, and redeclared members while working with `this` and `super` references.
- Apply constructor chaining rules, including default constructors, `this(...)`, and `super(...)` invocations.
- Trace static and instance initialization order across complex hierarchies and ensure `final` fields are assigned exactly once.
- Enforce method overriding constraints (access levels, checked exceptions, covariant returns) and recognise when methods or variables are hidden instead.
- Design abstract class hierarchies that require concrete subclasses to supply behaviour.

## Chapter Summary
### Inheritance Essentials
- Subclasses inherit accessible members (`public`, `protected`, package) but never private ones; use `this` to resolve field shadowing and `super` to reach parent members.
- A class may extend only one direct parent; `final` classes cannot be subclassed.

### Constructor Rules
- The compiler inserts a default no-arg constructor only when no constructors are declared.
- Overloaded constructors must be distinguished by signature; `this(...)` must appear first and cannot form cycles.
- Every constructor implicitly calls either another constructor in the same class or a parent constructor via `super(...)`.

### Initialization Order
- Static initialization runs once per class: parent static members → child static members.
- Instance creation initialises parent instance members/initialisers → parent constructor → child instance members/initialisers → child constructor.
- `final` fields must be assigned exactly once (declaration, initializer block, or constructor).

### Method Overriding and Hiding
- Overridden methods require identical signatures, broader-or-equal access, no new/broader checked exceptions, and covariant return types.
- Static methods and fields are hidden, not overridden; behaviour depends on the reference type.
- `final` methods cannot be overridden or hidden.

### Abstract Classes
- Abstract classes may define abstract methods and cannot be instantiated directly; the first concrete subclass must implement every inherited abstract method.
- Abstract constructors behave like normal constructors and execute during subclass instantiation.

## Practical Exercises
1. **Field Access** – Extend `InheritanceExamples.Crocodile` with a method that combines `speed` values from parent and child, then assert the result in a new test.
2. **Constructor Flow** – Add a new overloaded constructor to `ConstructorExamples.Gorilla` and adjust tests to confirm the chaining path.
3. **Initialization Trace** – Modify `InitializationExamples.Okapi` to log which constructor was chosen and update assertions for the new output.
4. **Override Constraints** – Try adding an overriding method to `MethodInheritanceExamples.BactrianCamel` that throws a broader checked exception; observe the compiler failure.
5. **Abstract Expansion** – Create another `AbstractExamples.Canine` subtype with a distinct sound and verify `bark()` prints the expected value.

## Run the Examples
```bash
# Ensure Java 17 is active
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk use java 17.0.14-tem

# Compile the Chapter 6 module
mvn -pl chapters/ch06-class-design compile

# Run the demo driver
java -cp chapters/ch06-class-design/target/classes ch06.examples.Chapter06Demo

# Execute the chapter-specific tests
mvn -pl chapters/ch06-class-design -Dtest='ch06.examples.*Test' test
```

## Exam Prep (1Z0-829 style)
1. Which statement about constructors is true?
   - A. `super()` may appear after other statements in a constructor.
   - B. A class with any constructor never receives a compiler-generated default constructor.
   - C. Constructors may be invoked like regular methods without `new`.
   - D. Constructors can form cyclic calls as long as they compile.
2. Given `protected void climb() throws IOException` in a superclass, which override is valid?
   - A. `void climb() throws Exception`
   - B. `public void climb() throws FileNotFoundException`
   - C. `private void climb() throws IOException`
   - D. `protected void climb() throws RuntimeException, IOException`
3. When does a `final` instance field need to be assigned?
   - A. Only if a getter is provided.
   - B. Before the constructor completes.
   - C. Never; it receives the default value.
   - D. After all constructors finish.
4. Which combination illustrates method hiding rather than overriding?
   - A. Parent and child both define `void act()` (instance methods).
   - B. Parent defines `static void rest()`, child defines `static void rest()`.
   - C. Parent defines `final void eat()`, child defines `void eat()`.
   - D. Parent defines `void run()`, child defines `void run(int speed)`.
5. What must the first concrete subclass of an abstract class do?
   - A. Provide a no-argument constructor.
   - B. Implement every inherited abstract method.
   - C. Be declared `final`.
   - D. Avoid calling `super()` in constructors.

<details>
<summary>Answers</summary>
1: B  
2: B  
3: B  
4: B  
5: B  
</details>

## Next Steps
- Continue with Chapter 7 to explore interfaces, sealed classes, and nested types that build on these inheritance rules.
- Expand tests with additional polymorphism scenarios once the collections and records material is introduced.
