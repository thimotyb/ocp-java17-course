# Chapter 1 – Building Blocks

## Learning Objectives
- Review the Java 17 toolchain (`java`, `javac`, `jar`, `javadoc`) and run single-file programs.
- Structure classes with fields, methods, comments, and understand the relationship between source files, packages, and imports.
- Define the `main` entry point, handle command-line arguments, and respect the declaration order `package` → `import` → `class`.
- Distinguish primitive and reference types, manage numeric/text literals, wrapper classes, and multiline text output.
- Apply initialization rules, scope, `final`, local type inference (`var`), and garbage-collection eligibility.

## Chapter Summary
### Environment and Toolchain
- The JDK ships the essential commands (`javac`, `java`, `jar`, `javadoc`); since JDK 11 the standalone JRE is gone in favour of custom runtimes.
- Stick to Java 17 when preparing for the exam to avoid behavioural differences introduced in later releases.
- The launcher supports single-file source programs: `java MyFile.java` compiles and runs in one step.

### Class Structure Basics
- Top-level classes: at most one `public` per file and the class name must match the filename (`Animal.java`).
- Building blocks: fields store state, methods operate on it; comments (`//`, `/* */`, `/** */`) can appear almost anywhere to aid readability.
- Method signature = name plus parameter list. Constructors share the class name and omit the return type.
- Initialization order: fields and instance initializer blocks in declaration order, followed by the constructor body.

### `main` Method and Arguments
- Canonical signature `public static void main(String[] args)`; optional modifiers (`final`) and array syntax variations (`String... args`) are allowed.
- CLI arguments are space-delimited; quotes keep spaces together; reading a missing index triggers `ArrayIndexOutOfBoundsException`.

### Packages and Imports
- If present, `package` must be the first statement; imports follow, then the class declaration.
- Specific imports take precedence over wildcards (`import java.util.Random;` beats `import java.util.*;`). Wildcards do not include sub-packages.
- `java.lang` is always available implicitly; use fully qualified names to resolve conflicts (for example `java.util.Date` vs `java.sql.Date`).

### Data Types and Literals
- Eight primitives: `boolean`, `byte`, `short`, `int`, `long`, `float`, `double`, `char`. Numeric literals support binary (`0b`), octal (`0`), hexadecimal (`0x`), and embedded underscores (`1_000`).
- `float` literals require `f/F`; `long` literals require `L` to avoid implicit `int` overflow.
- Wrapper classes (`Integer`, `Double`, …) extend `Number` (except `Boolean`/`Character`) and expose factories (`valueOf`), parsing helpers, and conversion methods (`intValue()` …).
- Multiline strings can be built with text blocks or explicit line breaks, showing how whitespace is preserved.

### References, `var`, Scope
- Only reference types can be `null`; use wrappers when a primitive needs a “no value” state.
- `var` is limited to local variables initialized in the same statement; it cannot be used for fields, parameters, multi-declarations, or `null`-only assignments.
- `final` on local variables prevents reassigning the reference but not mutating the object.
- Scope rules: parameters live for the method duration; local variables live until the block closes; instance fields live with the object; `static` fields live for the program lifetime.

### Garbage Collection
- An object becomes eligible when no references reach it or when all references fall out of scope.
- `System.gc()` is only a hint; the JVM decides if and when to trigger the collector.

## Practical Exercises
1. **Class anatomy** – Explore `Animal`, `VisitorCounter`, and `Chicken` under `ch01.examples` to review fields, accessors, and constructors. Extend them with additional getters and constructor logic.
2. **Main methods and arguments** – Run `Zoo` and `ZooArguments` to observe entry points and CLI parameters. Experiment with optional modifiers (`final`) and missing arguments.
3. **Imports and random numbers** – Inspect `NumberPicker` to see how explicit imports resolve `Random`. Replace the star import with specific class imports and verify behaviour with tests.
4. **Initialization order and scope** – Study `Egg`, `Bird`, `NameTag`, and `Mouse` to follow field initialization, instance initializers, and variable scope. Modify the classes to see how execution order changes.
5. **Local variable type inference** – Execute `ZooVar` and alter the `var` declarations to reinforce the compile-time rules about inference.

## Run the Examples
```bash
# Ensure Java 17 is active
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk use java 17.0.14-tem

# Compile the module
mvn -pl chapters/ch01-language-basics compile

# Run the book snippets
java -cp chapters/ch01-language-basics/target/classes ch01.examples.Zoo
java -cp chapters/ch01-language-basics/target/classes ch01.examples.ZooArguments Bronx Zoo
java -cp chapters/ch01-language-basics/target/classes ch01.examples.NumberPicker

# Execute the focused tests that mirror the chapter
mvn -pl chapters/ch01-language-basics -Dtest='ch01.examples.*Test' test
```

## Exam Prep (1Z0-829 style)
1. Which `main` declarations are valid entry points? (Select all that apply)
   - A. `static public void main(String... args)`
   - B. `public void main(String[] args)`
   - C. `public static final void main(String[] zoo)`
   - D. `public static void main(String args)`
   - E. `default static void main(String[] args)`
2. Which statements about imports are true? (Select all that apply)
   - A. `import java.util.*;` also brings in `java.util.concurrent.*`.
   - B. Two classes that share the same simple name across packages require at least one fully qualified reference.
   - C. When clashes exist, a specific import wins over a wildcard import.
   - D. `java.lang` must be imported explicitly.
   - E. Imports must follow class declarations.
3. Consider `var value = 10; value = "ten";`. What is true? (Select all that apply)
   - A. It compiles and prints `ten`.
   - B. It compiles but throws `ClassCastException`.
   - C. It does not compile because `var` infers `int` at declaration time.
   - D. It compiles if the code is inside a static block.
   - E. It compiles if `value` is declared `final`.
4. Which variables are out of scope at the line marked `// print`?
   ```java
   void feed(boolean hungry) {
       int bites = 1;
       if (hungry) {
           var portion = 2;
           while (portion > 0) {
               int consumed = 1;
               portion -= consumed;
           }
       }
       System.out.println(bites); // print
   }
   ```
   - A. `hungry`
   - B. `bites`
   - C. `portion`
   - D. `consumed`
   - E. None of the above
5. Which scenarios make an object eligible for garbage collection? (Select all that apply)
   - A. Every reference to the object is set to `null`.
   - B. A local reference falls out of the block where it is declared.
   - C. The object is still referenced by a `static` field.
   - D. `System.gc()` is invoked.
   - E. The object remains referenced by another live instance.

<details>
<summary>Answers</summary>
1: A, C  
2: B, C  
3: C  
4: C, D  
5: A, B  
</details>

## Next Steps
- Map additional grey-box snippets from the book (for example, `Park`, `Chick`, `Swan`) into the module as you progress.
- Keep the accompanying tests in `ch01.examples` aligned with the source listings so you can verify behaviour quickly.
- Experiment with variations (adding packages, alternative imports) while preserving the original book examples for reference.
