# Chapter 4 – Core APIs

## Learning Objectives
- Manipulate immutable `String` values with concatenation, searching, and text processing helpers.
- Apply `StringBuilder` for mutable text, using append, insert, delete, replace, and reverse operations.
- Create and manage arrays, including declaration syntax, length rules, loops, and the `java.util.Arrays` helpers (`sort`, `binarySearch`, `compare`, `mismatch`).
- Format, strip, indent, and translate text blocks while working with whitespace and internationalised output.
- Construct and manipulate dates, times, periods, durations, and time zones with the `java.time` API.

## Chapter Summary
### Working with Strings
- Java concatenation follows three rules: numeric addition for two numbers, concatenation when a `String` is involved, and left-to-right evaluation. `+=` essentially calls concatenation.
- Common `String` methods include `length`, `charAt`, `indexOf`, `substring`, `toUpperCase`, `toLowerCase`, `equals`, `equalsIgnoreCase`, `startsWith`, `endsWith`, `contains`, `replace`, `strip`, `stripLeading`, `stripTrailing`, `trim`, `indent`, `stripIndent`, `translateEscapes`, `isEmpty`, `isBlank`, and formatted output with `format`/`formatted`.
- Strings are immutable; each method call returns a new `String` instance, so store the result if you need it.

### Building Strings with `StringBuilder`
- `StringBuilder` is mutable. Methods such as `append`, `insert`, `delete`, `deleteCharAt`, `replace`, and `reverse` mutate the existing object and return the same instance, enabling chaining.
- `StringBuilder` does not override `equals`; compare by converting to `String` when logical equivalence is needed.

### Arrays
- Arrays require a fixed length and store either primitives or references. Declaration syntax allows brackets before or after the variable name, although consistent placement improves readability.
- Use `Arrays.sort` for ascending order and `Arrays.binarySearch` on sorted arrays. `Arrays.compare` determines ordering of two arrays, and `Arrays.mismatch` returns the first differing index or `-1` when equal.
- Remember that `length` is a field (no parentheses) and indices start at 0.

### Formatting and Text Blocks
- Methods such as `strip`, `stripLeading`, `stripTrailing`, and `trim` handle whitespace, while `indent` adjusts indentation and normalises line endings. `stripIndent` removes incidental whitespace from multiline strings. `translateEscapes` turns escape sequences into their literal characters.
- `String.format` and `String.formatted` substitute variables using format specifiers like `%s`, `%d`, `%f`, and `%n`.

### Date and Time API
- Use factories like `LocalDate.of`, `LocalTime.of`, `LocalDateTime.of`, and `ZonedDateTime.of` to create immutable date/time objects. Months are 1-based.
- `Period` models date-based amounts; `Duration` models time-based amounts. Only use `Period` with date-based types and `Duration` with time-based types. `ChronoUnit.between` measures differences between temporal values.
- Many date/time methods return new objects; adding a `Period` to a `LocalTime` or a `Duration` to a `LocalDate` throws an exception.

## Practical Exercises
1. **String diagnostics** – Run `StringExamples` and `StringStripExamples` to view concatenation, indexing, whitespace trimming, and formatting results. Modify the literals and observe how outputs change.
2. **Mutable builders** – Experiment with `StringBuilderExamples` to see how append/insert/delete/replace affect the same underlying object. Try chaining additional methods.
3. **Array manipulation** – Use `ArrayDeclarationsExamples` and `ArraySortSearchExamples` to explore declaration syntax, casting, loops, sorting, and binary search behaviour.
4. **Array comparison helpers** – Evaluate `ArraySortSearchExamples` to see how `Arrays.compare` and `Arrays.mismatch` interpret ordering and equality.
5. **Date/time construction** – Run `DateTimeCreationExamples`, `DateTimePeriodExamples`, and `DateTimeDurationExamples` to observe the effects of `Period`, `Duration`, and zone operations. Extend them with your own examples.

## Run the Examples
```bash
# Ensure Java 17 is active
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk use java 17.0.14-tem

# Compile the module
mvn -pl chapters/ch04-core-apis compile

# Run selected listings from the book
java -cp chapters/ch04-core-apis/target/classes ch04.examples.StringExamples
java -cp chapters/ch04-core-apis/target/classes ch04.examples.ArraySortSearchExamples
java -cp chapters/ch04-core-apis/target/classes ch04.examples.DateTimeCreationExamples

# Execute the chapter-aligned tests
mvn -pl chapters/ch04-core-apis -Dtest='ch04.examples.*Test' test
```

## Exam Prep (1Z0-829 style)
1. What does `System.out.println("c" + 1 + 2);` output?
   - A. `3c`
   - B. `c3`
   - C. `c12`
   - D. An exception is thrown
2. Which `StringBuilder` method reverses the character sequence in-place?
   - A. `append`
   - B. `reverse`
   - C. `replace`
   - D. `deleteCharAt`
3. Given `int[] numbers = {6, 9, 1}; Arrays.sort(numbers);`, what is `Arrays.binarySearch(numbers, 9);`?
   - A. `-1`
   - B. `2`
   - C. `3`
   - D. `-3`
4. Which statement creates a `LocalDateTime` for 20 January 2022 at 06:15?
   - A. `LocalDateTime.of(2022, 0, 20, 6, 15)`
   - B. `LocalDateTime.of(2022, Month.JANUARY, 20, 6, 15)`
   - C. `new LocalDateTime(2022, 1, 20, 6, 15)`
   - D. `LocalDateTime.parse(2022-01-20T06:15)`
5. What does `Arrays.mismatch(new int[]{1, 2}, new int[]{1});` return?
   - A. `-1`
   - B. `0`
   - C. `1`
   - D. `2`

<details>
<summary>Answers</summary>
1: C  
2: B  
3: B  
4: B  
5: C  
</details>

## Next Steps
- Continue extracting additional string, array, collection, and date/time listings from the chapter and place them under `src/main/java/ch04/examples/` with matching tests.
- Extend the examples to cover varargs, `Arrays.compare` edge cases, and more `java.time` scenarios as you progress.
- Keep the tests aligned with new snippets to ensure the examples remain executable references.
