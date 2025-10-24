package ch07.examples;

import java.util.Objects;

/**
 * Demonstrates records from Chapter 7: Beyond Classes.
 *
 * <p><strong>From Chapter 7: Encapsulating Data with Records</strong><br>
 * Records are a special type of data-oriented class that removes boilerplate code.
 * A record is a special type of class designed to store immutable data. Records
 * automatically provide implementations for constructors, accessors, equals(),
 * hashCode(), and toString() methods.
 *
 * <p><strong>Key Concepts:</strong>
 * <ul>
 *   <li>Records are declared with the {@code record} keyword</li>
 *   <li>Every field is inherently final and the record is implicitly final</li>
 *   <li>Records cannot extend other classes (but can implement interfaces)</li>
 *   <li>Records cannot be extended by other classes</li>
 *   <li>Compact constructors provide validation without explicit field assignment</li>
 *   <li>Overloaded constructors must delegate to the canonical constructor</li>
 *   <li>Accessor methods have no prefix (not getX() but x())</li>
 * </ul>
 *
 * <p><strong>Members Automatically Added to Records:</strong>
 * <ul>
 *   <li>Canonical constructor with parameters in declaration order</li>
 *   <li>Accessor methods for each field (name(), not getName())</li>
 *   <li>equals() method comparing all fields</li>
 *   <li>hashCode() method using all fields</li>
 *   <li>toString() method showing field names and values</li>
 * </ul>
 *
 * @see EnumExamples
 * @see SealedExamples
 */
public final class RecordExamples {

    private RecordExamples() {
    }

    /**
     * Record demonstrating compact constructor with validation and transformation.
     *
     * <p><strong>From Chapter 7: Declaring Constructors</strong><br>
     * A compact constructor is a special type of constructor used for records to
     * process validation and transformations succinctly. Unlike normal constructors,
     * compact constructors:
     * <ul>
     *   <li>Do not have parameter list (parameters are implicit from record declaration)</li>
     *   <li>Do not explicitly assign fields (compiler does this automatically)</li>
     *   <li>Can modify parameter values before they are assigned to fields</li>
     *   <li>Cannot modify the fields directly (fields don't exist yet)</li>
     * </ul>
     *
     * <p><strong>Execution Order:</strong>
     * <ol>
     *   <li>Compact constructor body executes (validation and transformation)</li>
     *   <li>Compiler implicitly assigns parameters to final fields</li>
     *   <li>Record instance is created with immutable state</li>
     * </ol>
     *
     * <p>This record also demonstrates an overloaded constructor that must
     * delegate to the canonical constructor using {@code this()}.
     */
    public record Keeper(String name, int experienceYears) {

        /**
         * Compact constructor with validation and transformation.
         *
         * <p><strong>From Chapter 7: Compact Constructors</strong><br>
         * This compact constructor:
         * <ol>
         *   <li>Validates that name is not null and trims whitespace</li>
         *   <li>Validates that the trimmed name is not empty</li>
         *   <li>Validates that experienceYears is non-negative</li>
         *   <li>Transforms the name parameter (trimming) before field assignment</li>
         * </ol>
         *
         * <p>The compiler automatically assigns the (potentially modified) parameters
         * to the final fields after this constructor body executes.
         *
         * @throws NullPointerException if name is null
         * @throws IllegalArgumentException if name is blank or experienceYears is negative
         */
        public Keeper {
            // Transform: trim the name (this modifies the parameter, not the field)
            name = Objects.requireNonNull(name).trim();

            // Validate: ensure name is not blank after trimming
            if (name.isEmpty()) {
                throw new IllegalArgumentException("name must not be blank");
            }

            // Validate: ensure experience is non-negative
            if (experienceYears < 0) {
                throw new IllegalArgumentException("experience must be non-negative");
            }

            // Compiler implicitly assigns: this.name = name; this.experienceYears = experienceYears;
        }

        /**
         * Overloaded constructor providing a default experience value.
         *
         * <p><strong>From Chapter 7: Overloaded Constructors</strong><br>
         * Overloaded constructors in records must delegate to the canonical constructor
         * (the one matching the record declaration) using {@code this()}. This ensures
         * all validation logic in the compact constructor is executed.
         *
         * <p>This constructor allows creating a Keeper with just a name, defaulting
         * experienceYears to 0.
         *
         * @param name the keeper's name
         * @throws NullPointerException if name is null
         * @throws IllegalArgumentException if name is blank
         */
        public Keeper(String name) {
            // Must delegate to canonical constructor
            this(name, 0);
        }

        // Compiler automatically generates:
        // - public String name() { return name; }
        // - public int experienceYears() { return experienceYears; }
        // - public boolean equals(Object o) { ... }
        // - public int hashCode() { ... }
        // - public String toString() { return "Keeper[name=" + name + ", experienceYears=" + experienceYears + "]"; }
    }

    /**
     * Simple record demonstrating basic compact constructor validation.
     *
     * <p><strong>From Chapter 7: Understanding Record Immutability</strong><br>
     * This record demonstrates the minimal pattern for a record with validation.
     * Every field is inherently final and cannot be modified after construction.
     * To "modify" a record, you must create a new instance.
     *
     * <p>Records are implicitly final, just like enums. This means:
     * <ul>
     *   <li>Records cannot be extended by other classes</li>
     *   <li>All fields are implicitly final</li>
     *   <li>Records can implement interfaces (regular or sealed)</li>
     * </ul>
     */
    public record Exhibit(String title, int capacity) {

        /**
         * Compact constructor validating the capacity field.
         *
         * <p>Demonstrates that compact constructors can contain only validation
         * without transformation. The title field is accepted as-is, while
         * capacity is validated to ensure it's positive.
         *
         * @throws IllegalArgumentException if capacity is not positive
         */
        public Exhibit {
            // Validate: ensure capacity is positive (greater than 0)
            if (capacity <= 0) {
                throw new IllegalArgumentException("capacity must be positive");
            }

            // No transformation needed for title, it's used as-is
            // Compiler implicitly assigns: this.title = title; this.capacity = capacity;
        }

        // Compiler automatically generates:
        // - public String title() { return title; }
        // - public int capacity() { return capacity; }
        // - public boolean equals(Object o) { ... }
        // - public int hashCode() { ... }
        // - public String toString() { return "Exhibit[title=" + title + ", capacity=" + capacity + "]"; }
    }
}
