# Chapter 11 – Exceptions and Localization

## Learning Objectives
- Classify exceptions as checked, unchecked, or errors and manage them using `try`, `catch`, `finally`, multi-catch, and try-with-resources.
- Create and throw custom exceptions while preserving causes and suppressed exceptions.
- Format and parse locale-sensitive numbers, currencies, dates, and times.
- Manage internationalisation with `Locale` and `ResourceBundle`, including key validation and fallback behaviour.

## Chapter Summary
### Exception Handling
- Unchecked exceptions (`RuntimeException` and subclasses) indicate programming errors; checked exceptions represent recoverable conditions.
- `try` blocks support multi-catch (`catch (IOException | SQLException e)`) and `finally` always executes (even overriding a `return`).
- Try-with-resources auto-closes resources in reverse order, collecting suppressed exceptions accessible via `Throwable::getSuppressed`.
- Chain exceptions with constructor overloads to maintain the root cause.

### Localization Basics
- `Locale` encapsulates language and region; choose locales via constructors or constants such as `Locale.US`.
- Use `NumberFormat.getCurrencyInstance(locale)` or `DateTimeFormatter.ofLocalizedDateTime()` for locale-aware output.
- `ResourceBundle` loads locale-specific properties (with fallback). Use `containsKey` to validate keys and avoid `MissingResourceException`.

## Practical Exercises
1. **Custom Exception** – Add a domain-specific checked exception that logs details before rethrowing.
2. **Suppressed Exceptions** – Extend try-with-resources tests to verify multiple suppressed exceptions from custom `AutoCloseable` implementations.
3. **Formatting Variants** – Experiment with different `FormatStyle` options and compare locale outputs.
4. **Bundle Hierarchy** – Create `zoo_fr.properties` to observe locale fallback behaviour.
5. **Parsing Pitfalls** – Demonstrate parsing failures when using mismatched locales, catching `ParseException` gracefully.

## Run the Examples
```bash
# Ensure Java 17 is active
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk use java 17.0.14-tem

# Compile the Chapter 11 module
mvn -pl chapters/ch11-exceptions-localization compile

# Run the demo
java -cp chapters/ch11-exceptions-localization/target/classes ch11.examples.Chapter11Demo

# Execute the tests
mvn -pl chapters/ch11-exceptions-localization -Dtest='ch11.examples.*Test' test
```

## Exam Prep (1Z0-829 style)
1. Which statement about checked exceptions is correct?
   - A. They must be handled or declared using `throws`.
   - B. They extend `RuntimeException`.
   - C. They cannot be thrown from constructors.
   - D. They are ignored by try-with-resources.
2. When does a `finally` block execute?
   - A. Only when no exception occurs.
   - B. Only when an exception occurs.
   - C. Always, even after a `return` or `throw`.
   - D. Never if try-with-resources is used.
3. How are suppressed exceptions accessed?
   - A. `e.getSuppressed()`
   - B. `e.getCause()`
   - C. `e.getMessage()`
   - D. `e.printStackTrace()`
4. Which class reads locale-specific messages from property files?
   - A. `LocaleBundle`
   - B. `ResourceBundle`
   - C. `LocaleManager`
   - D. `PropertiesLoader`
5. Which formatter provides locale-specific currency formatting?
   - A. `NumberFormat.getCurrencyInstance(locale)`
   - B. `DecimalFormat("¤###")`
   - C. `DateTimeFormatter.ofPattern("¤###")`
   - D. `CurrencyFormatter.of(locale)`

<details>
<summary>Answers</summary>
1: A  
2: C  
3: A  
4: B  
5: A  
</details>

## Next Steps
- Integrate localisation with resource bundles into UI or API responses.
- Refine exception hierarchies for domain-specific error handling and logging.
