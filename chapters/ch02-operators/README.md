# Chapter 2 – Operators

## Learning Objectives
- Classify Java operators (unary, binary, ternary) and recall precedence and associativity rules.
- Apply numeric promotion, casting, and compound assignments without losing precision.
- Compare primitives and reference types using equality, relational, and `instanceof` operators.
- Control evaluation flow with logical, conditional, and ternary operators while understanding short-circuit behaviour.
- Diagnose exam “gotchas” such as assignments inside conditionals and side effects from pre/post increment expressions.

## Chapter Summary
### Operator Taxonomy and Precedence
- Operators fall into unary, binary, and ternary forms; precedence dictates evaluation order when parentheses are absent.
- Multiplicative operators beat additive; assignments associate right-to-left. Use parentheses to make intent explicit and avoid surprises.
- Postfix (`expr++`, `expr--`) run after the expression, whereas prefix (`++expr`, `--expr`) applies first, influencing side effects mid-expression.

### Unary Operators and Numeric Promotion
- Unary plus/minus, logical complement (`!`), bitwise complement (`~`), and casts operate on a single operand.
- Pre/post increment and decrement adjust variables by one; be wary of using them multiple times in the same statement.
- Java promotes smaller integral types (`byte`, `short`, `char`) to `int` before arithmetic; explicit casts are required when storing results back into narrower types unless compound assignments are used.

### Arithmetic, Assignment, and Compound Forms
- Binary arithmetic (`+`, `-`, `*`, `/`, `%`) follow promotion rules and can overflow silently; integer division truncates.
- Compound assignment operators (`+=`, `*=`, etc.) perform an implicit cast to the left-hand side type, often eliminating the need for explicit casts.
- Assignment expressions return a value, meaning `if (flag = true)` assigns and evaluates to `true`—a common exam trap.

### Comparison, Logical, and Ternary Operators
- Relational operators compare numeric values; `instanceof` works with reference types and supports pattern matching in newer releases.
- Equality operators (`==`, `!=`) compare primitives by value, but compare object references unless overridden by `equals`.
- Logical operators (`&`, `|`, `^`) always evaluate both operands; conditional (`&&`, `||`) short-circuit, skipping evaluation when the result is determined.
- The ternary operator `condition ? a : b` selects between two expressions and participates in type inference.

## Practical Exercises
1. **Precedence walkthrough** – Run `OperatorReward`, `OperatorIncrement`, and `OperatorPerimeter` under `ch02.examples` to trace how pre/post operators and parentheses affect evaluation.
2. **Numeric promotion checks** – Experiment with `OperatorPrice`, `OperatorDivisionModulus`, and `OperatorSamples` to observe promotion rules and modulus behaviour.
3. **Boolean logic and ternaries** – Study `OperatorCanine`, `OperatorWaterQuality`, and `OperatorTernary` to review XOR, short-circuiting, and nested ternary expressions.
4. **Type casting drill** – Use `OperatorPig` to see how compound assignments perform implicit casts. Extend the example to include additional casts.

## Run the Examples
```bash
# Ensure Java 17 is active
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk use java 17.0.14-tem

# Compile the module
mvn -pl chapters/ch02-operators compile

# Run selected listings from the book
java -cp chapters/ch02-operators/target/classes ch02.examples.OperatorReward
java -cp chapters/ch02-operators/target/classes ch02.examples.OperatorIncrement
java -cp chapters/ch02-operators/target/classes ch02.examples.OperatorPig

# Execute the chapter-aligned tests
mvn -pl chapters/ch02-operators -Dtest='ch02.examples.*Test' test
```

## Exam Prep (1Z0-829 style)
1. In the expression `int result = 5 + --x * 2;`, which happens first? (Select one)
   - A. `5 + ...`
   - B. `result = ...`
   - C. `--x`
   - D. Multiplication by `2`
2. Which statements about compound assignments are true? (Select all that apply)
   - A. `short s = 1; s = s + 1;` compiles without casting.
   - B. `short s = 1; s += 1;` compiles without casting.
   - C. `int i = 1; i *= 3.5;` compiles and truncates the fractional part.
   - D. `var v = 5; v += "5";` compiles and produces `55`.
3. Given `boolean a = false; boolean b = true;`, what is the result of `a & method()` versus `a && method()` where `method()` returns `true` but increments a counter as a side effect? (Select one)
   - A. Both calls increment the counter.
   - B. Only `a & method()` increments the counter.
   - C. Only `a && method()` increments the counter.
   - D. Neither call increments the counter.
4. Which comparisons evaluate to `true`? (Select all that apply)
   - A. `Integer.valueOf(1000) == Integer.valueOf(1000)`
   - B. `"java" == "java"`
   - C. `"java".trim() == "java"`
   - D. `Objects.equals(Integer.valueOf(1000), Integer.valueOf(1000))`
   - E. `new String("java") == "java"`
5. What does the expression `var label = value > 0 ? "positive" : value == 0 ? "zero" : "negative";` evaluate to when `value` is `0`? (Select one)
   - A. `"positive"`
   - B. `"zero"`
   - C. `"negative"`
   - D. Compilation fails because of nested ternaries.

<details>
<summary>Answers</summary>
1: C  
2: B, C, D  
3: B  
4: B, C, D  
5: B  
</details>

## Next Steps
- Continue extracting remaining operator snippets (for example, additional numeric promotion or shift examples) into `ch02.examples`.
- Add assertions to the existing tests whenever you discover new behaviours or edge cases discussed in the text.
- Explore bitwise and shift operators as you encounter them later in the chapter, keeping the examples package aligned with the book.
