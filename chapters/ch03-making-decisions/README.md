# Chapter 3 – Making Decisions

## Learning Objectives
- Build control-flow logic using `if`, `if/else-if/else`, and nested blocks while enforcing boolean conditions.
- Apply pattern matching with `instanceof`, guarding blocks and variables safely.
- Choose and configure classic `switch` statements: supported types, fall-through rules, `break`, `default`, and unreachable code constraints.
- Leverage switch expressions with arrow labels and `yield`, and compare their behaviour to statement form.
- Recognise exam pitfalls such as missing braces, assignment in conditions, and non-constant `case` labels.

## Chapter Summary
### Statements, Blocks, and Boolean Guards
- Control-flow statements can target a single statement or a `{}` block; indentation alone does not bind code to a condition.
- `if` requires a boolean expression; numeric values (e.g., `if(1)`) are illegal. Use braces even for one-liners to avoid accidental fall-through.
- Pattern matching with `instanceof` (Java 16+) combines the test and cast: `if (obj instanceof String s && s.length() > 3) ...`.

### Chaining Decisions with `if/else`
- `if/else-if/else` chains evaluate in order until the first `true`. Ensure mutually exclusive conditions or use `else` for “catch-all” cases.
- Assignments inside conditions (`if ((value = method()) > 0)`) compile but may hide bugs; double-check operator usage (`==` vs `=`).

### Classic `switch` Statements
- Legacy `switch` accepts `byte`, `short`, `char`, `int`, their wrappers, `enum`, and `String`. All `case` labels must be constant expressions.
- Fall-through occurs when `break` (or `return`, `throw`) is omitted; `default` can appear anywhere but executes at most once.
- The compiler rejects duplicate or unreachable `case` labels, and multiple labels can share one block (`case MONDAY, TUESDAY ->` in expression form).

### Switch Expressions and `yield`
- Arrow labels (`case MONDAY ->`) execute exactly one expression or block; traditional labels still require `break` to avoid fall-through.
- Switch expressions produce a value; use `yield` inside block cases to supply it. Exhaustive coverage is enforced—`default` may be required.
- Mixing statement and expression styles in the same switch is illegal; pick one.

### Flow Control Aids
- `break` exits the nearest loop or switch; `continue` skips to the next loop iteration. Labeled `break`/`continue` work with nested constructs.
- Guarded pattern matching (`case String s when s.length() > 5 ->`) allows additional boolean filters in switch expressions.

## Practical Exercises
1. **If/else routing** – Step through `IfExamples` under `ch03.examples` to observe how chain ordering and braces affect execution. Extend it with additional branches and trace the output.
2. **Switch statements** – Compare `DayOfWeekStatement` and `DayOfWeekExpression` to see the difference between classic and expression-based `switch`. Add new cases for other values.
3. **Loop control with labels** – Execute `CleaningSchedule`, `FindInMatrix`, and `FindInMatrixUsingReturn` to study labeled `break` and `continue` as well as early `return`.
4. **Pattern guards and do/while** – Explore `FishTank` and `PrintIntegers` to reinforce pattern matching behavior and `do/while` ordering.

## Run the Examples
```bash
# Ensure Java 17 is active
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk use java 17.0.14-tem

# Compile the module
mvn -pl chapters/ch03-making-decisions compile

# Run selected book listings
java -cp chapters/ch03-making-decisions/target/classes ch03.examples.CleaningSchedule
java -cp chapters/ch03-making-decisions/target/classes ch03.examples.FindInMatrix
java -cp chapters/ch03-making-decisions/target/classes ch03.examples.PrintIntegers

# Execute the chapter-aligned tests
mvn -pl chapters/ch03-making-decisions -Dtest='ch03.examples.*Test' test
```

## Exam Prep (1Z0-829 style)
1. Which types are valid in a classic `switch` statement? (Select all that apply)
   - A. `long`
   - B. `byte`
   - C. `String`
   - D. `enum`
   - E. `var`
2. What is printed?
   ```java
   int score = 80;
   if (score > 90)
       if (score > 95)
           System.out.print("A");
       else
           System.out.print("B");
   else
       System.out.print("C");
   ```
   - A. `A`
   - B. `B`
   - C. `C`
   - D. Nothing (compilation fails)
3. Which statements about switch expressions are true? (Select all that apply)
   - A. A switch expression must cover all possible values or include `default`.
   - B. `yield` is optional when the right-hand side is a single expression after `->`.
   - C. Mixing `case value:` and `case value ->` in the same switch is allowed.
   - D. `break` with a value replaces `yield` inside block cases.
4. Given `Object obj = "java";` what does this print?
   ```java
   if (obj instanceof String s && s.length() > 4) {
       System.out.print(s.toUpperCase());
   } else {
       System.out.print("short");
   }
   ```
   - A. `JAVA`
   - B. `java`
   - C. `short`
   - D. Compilation fails
5. Which `switch` snippet compiles? (Select one)
   - A. `switch(day) { case MONDAY, TUESDAY -> "start"; default -> "other"; }`
   - B. `switch(day) { case 1: yield "one"; default: yield "other"; }`
   - C. `switch(day) { case 1: return "one"; case 1: return "again"; }`
   - D. `switch(day) { case "SUN" -> { break "sun"; } default -> "other"; }`

<details>
<summary>Answers</summary>
1: B, C, D  
2: C  
3: A, B  
4: C  
5: A  
</details>

## Next Steps
- Continue extracting additional decision-making listings (for example, more `switch` samples or label variations) into `ch03.examples`.
- Keep iterating on the tests to mirror the behaviour described in the book, adding assertions for new scenarios.
- Re-run `mvn -pl chapters/ch03-making-decisions test` whenever new snippets are added to ensure everything compiles and runs.
