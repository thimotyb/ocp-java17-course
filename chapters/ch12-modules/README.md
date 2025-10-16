# Chapter 12 – Modules

## Learning Objectives
- Define module descriptors (`module-info.java`) with directives such as `requires`, `exports`, `opens`, `uses`, and `provides`.
- Compile and run modular applications using `javac`, `jar`, and `java` with module paths.
- Understand readability, accessibility, and services within the Java Platform Module System (JPMS).
- Inspect module metadata at runtime using the `Module` API.

## Chapter Summary
### Module Basics
- A module is a named collection of packages and resources described by `module-info.java`.
- `requires` expresses module dependencies; `exports` exposes packages for compile-time and runtime access.

### Advanced Directives
- `requires transitive` propagates dependencies to consumers; `requires static` is compile-time only.
- `exports ... to` restricts access to specific modules. `opens` and `open module` relax reflective access.
- Service directives: `uses` declares a dependency on a service, and `provides ... with` registers implementations.

### Building Modules
- Use `javac --module-path` to compile modules and `jar --create --file` to package them.
- Launch modular applications with `java --module-path mods -m module/package.Class`.

### Module Reflection
- The `Module` API exposes descriptors, read edges, and exports at runtime, enabling dynamic inspection.

## Practical Exercises
1. **Descriptor Practice** – Add examples of `opens` and `requires static` to the descriptor strings and write tests asserting their presence.
2. **Service Provider** – Extend the service example to load implementations via `ServiceLoader`.
3. **Runtime Inspection** – Use `ModuleLayer.boot()` to list modules loaded at application startup.
4. **Compiler Flags** – Experiment with `--add-reads` and `--add-opens` to override module restrictions in tests.
5. **Modular Jar Layout** – Create a small script to compile and run a modular app mimicking the book’s commands.

## Run the Examples
```bash
# Ensure Java 17 is active
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk use java 17.0.14-tem

# Compile the Chapter 12 module
mvn -pl chapters/ch12-modules compile

# Run the demo
java -cp chapters/ch12-modules/target/classes ch12.examples.Chapter12Demo

# Execute the tests
mvn -pl chapters/ch12-modules -Dtest='ch12.examples.*Test' test
```

## Exam Prep (1Z0-829 style)
1. Which directive exports a package to a specific module?
   - A. `requires module.name`
   - B. `exports package.name to module.name`
   - C. `opens package.name`
   - D. `uses package.Service`
2. What does `requires transitive` accomplish?
   - A. Adds dependencies only at runtime.
   - B. Makes the dependency available to modules requiring the current module.
   - C. Opens the dependency for reflection.
   - D. Declares a service provider.
3. Which command runs a modular application?
   - A. `java -cp mods module.Main`
   - B. `java --module-path mods -m module/package.Main`
   - C. `java --module module.Main`
   - D. `java --class-path mods module.Main`
4. How do you declare that a module consumes a service?
   - A. `provides Service with Impl`
   - B. `requires static Service`
   - C. `uses Service`
   - D. `exports Service`
5. What does `Module::getDescriptor` return?
   - A. `Optional<ModuleDescriptor>`
   - B. `ModuleDescriptor`
   - C. `ModuleLayer`
   - D. `ModuleReader`

<details>
<summary>Answers</summary>
1: B  
2: B  
3: B  
4: C  
5: B  
</details>

## Next Steps
- Explore service loading with actual interfaces and implementations.
- Experiment with module layering and custom class loaders for advanced modularity scenarios.
