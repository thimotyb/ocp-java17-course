# Chapter 5 – Methods

## Learning Objectives
- Identify valid method declarations, including access modifiers, optional specifiers, return types, and parameter lists.
- Distinguish between local, instance, static, and final variables and predict when they are initialised.
- Create and invoke methods that rely on varargs, overloading, autoboxing, and pass-by-value semantics.
- Apply access-control rules (private, package, protected, public) across packages and inheritance hierarchies.
- Use static members, static initialisers, and static imports without violating compilation rules.

## Chapter Summary
### Designing Methods
- Method declarations follow the order: optional access modifier(s) → optional specifier(s) → return type → name → parameter list → optional `throws` clause → body.
- Method signatures consist only of the name and parameter types/order; return types, modifiers, and throws clauses do not affect signature uniqueness.
- Return types must match the value produced in the body. `void` methods may use `return;` for early exit without a value.

### Working with Variables Inside Methods
- Local variables exist only within their block and must be initialised before use; marking them `final` or leaving them effectively final prevents reassignment.
- Instance variables belong to each object; `final` instance variables must be assigned exactly once via field declarations, initialiser blocks, or constructors.
- `static` variables belong to the class. `static final` fields act as constants and are typically initialised in a single static block.

### Varargs and Parameter Passing
- A method can declare at most one varargs parameter and it must be last; callers may pass individual arguments, arrays, or nothing (resulting in an empty array).
- Java is strictly pass-by-value: reassigning a parameter (primitive or reference) never affects the caller, but mutating the referenced object does.

### Access Modifiers
- `private` restricts use to the declaring class, package access allows usage within the package, `protected` adds inheritance access, and `public` allows access from anywhere in the module.
- Protected members can be accessed via inheritance or package membership but not through unrelated references to the superclass type.

### Static Members and Imports
- `static` methods/fields are tied to the class, not instances; instance members require an object reference even when referenced from static contexts.
- Static initialisers run once on class load and can perform multi-step constant setup. Static imports bring static members into scope, but misuse (wrong syntax or naming collisions) yields compile errors.

### Method Overloading and Autoboxing
- Overloaded methods differ by parameter list (number, types, order). Java chooses the most specific applicable overload using the order: exact match → wider primitive → autoboxing → varargs.
- Autoboxing/unboxing bridges primitives and wrapper types but will not combine with a narrowing conversion automatically.

## Practical Exercises
1. **Validate Declarations** – Review `MethodDeclarationExamples` and identify why the commented lines would fail; add additional valid overloads to reinforce the signature rules.
2. **Varargs in Action** – Modify `VarargsExamples.DogWalker` to log the distances walked and assert the behaviour in tests.
3. **Access Control Lab** – Extend the `pond.*` packages with a new species and verify which members are visible from each package.
4. **Static Diagnostics** – Enhance `StaticExamples.MantaRay` to track invocation order of `first`, `second`, and `third`, then write assertions for the expected sequence.
5. **Overload Resolution** – Add new overloads to `OverloadingExamples.Falcon` and predict (via tests) which overload Java selects for different argument combinations.

## Run the Examples
```bash
# Ensure Java 17 is active
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk use java 17.0.14-tem

# Compile the Chapter 5 module
mvn -pl chapters/ch05-methods compile

# Run the lightweight demo driver
java -cp chapters/ch05-methods/target/classes ch05.examples.Chapter05Demo

# Execute the chapter-specific tests
mvn -pl chapters/ch05-methods -Dtest='ch05.examples.*Test' test
```

## Exam Prep (1Z0-829 style)
1. Which combination of modifiers is valid on a method declaration?
   - A. `void public jump()`
   - B. `static final void glide()`
   - C. `public void final fly()`
   - D. `public modifier void dive()`
2. Given `void sprint(int... laps)`, which call compiles?
   - A. `sprint()`
   - B. `sprint(new int[]{1}, 2)`
   - C. `sprint(null)`
   - D. `sprint(1, new int[]{2, 3})`
3. In which scenario can a subclass access a `protected` member of its superclass?
   - A. Using a reference of the superclass type created in another package.
   - B. Invoking the member on an instance of the subclass.
   - C. When both classes are unrelated but in the same package.
   - D. Only when the member is also `static`.
4. What does passing a `StringBuilder` to a method that appends text demonstrate?
   - A. Methods can reassign parameters to share changes with the caller.
   - B. Pass-by-value prevents any mutation of the original object.
   - C. Mutating the object inside the method affects the caller.
   - D. Strings and builders behave identically when passed to methods.
5. Java prefers which overload order when multiple candidates match?
   - A. Varargs → autoboxed → wider primitive → exact
   - B. Exact → wider primitive → autoboxed → varargs
   - C. Autoboxed → wider primitive → exact → varargs
   - D. Wider primitive → exact → autoboxed → varargs

<details>
<summary>Answers</summary>
1: B  
2: A  
3: B  
4: C  
5: B  
</details>

## Next Steps
- Continue extracting code listings on constructors, records, and initialiser blocks as you progress to Chapter 6.
- Expand tests to cover additional overload resolution puzzles (mixing primitives, wrappers, and varargs).
- Capture more protected/package access edge cases once inheritance topics deepen in later chapters.
