package ch07.examples;

/**
 * Demonstrates enumerations (enums) from Chapter 7: Beyond Classes.
 *
 * <p><strong>From Chapter 7: Working with Enums</strong><br>
 * An enumeration, or enum for short, is like a fixed set of constants.
 * Using an enum is much better than using constants because it provides
 * type-safety. You can't pass an invalid value and find out at runtime.
 * With enums, it is impossible to create an invalid enum value without
 * introducing a compiler error.
 *
 * <p><strong>Key Concepts:</strong>
 * <ul>
 *   <li>Enums are declared with the {@code enum} keyword</li>
 *   <li>Enum values are constants (commonly written in UPPER_SNAKE_CASE)</li>
 *   <li>Each enum value is initialized only once in the JVM</li>
 *   <li>Enums cannot be extended (implicitly final)</li>
 *   <li>Enums can have constructors, fields, and methods</li>
 *   <li>Enum constructors are implicitly private</li>
 *   <li>Enum values can have their own method implementations (constant-specific methods)</li>
 *   <li>Enums provide built-in methods: values(), valueOf(String), ordinal(), name()</li>
 *   <li>Enums can be used in switch statements and expressions</li>
 * </ul>
 *
 * @see RecordExamples
 * @see SealedExamples
 */
public final class EnumExamples {

    private EnumExamples() {
    }

    /**
     * Complex enum demonstrating fields, constructors, methods, and constant-specific implementations.
     *
     * <p><strong>From Chapter 7: Adding Constructors, Fields, and Methods</strong><br>
     * While a simple enum is composed of just a list of values, we can define a
     * complex enum with additional elements including:
     * <ul>
     *   <li>Fields to store data for each enum constant</li>
     *   <li>Constructors to initialize those fields</li>
     *   <li>Methods that can be overridden by specific enum constants</li>
     *   <li>Default method implementations that apply to all constants</li>
     * </ul>
     *
     * <p><strong>Execution Order:</strong>
     * <ol>
     *   <li>Enum constants are created first (calling constructor for each)</li>
     *   <li>Constructor sets the averageTemperature field</li>
     *   <li>Each constant can override methods with its own implementation</li>
     *   <li>Constants without overrides use the default activity() implementation</li>
     * </ol>
     *
     * <p><strong>Important Rules:</strong>
     * <ul>
     *   <li>When an enum has members besides values, the list must end with semicolon (;)</li>
     *   <li>Enum constructors are implicitly private (cannot be called externally)</li>
     *   <li>The first statement must be the list of enum values</li>
     *   <li>Enum values are created before any static initialization</li>
     * </ul>
     */
    public enum Season {
        /**
         * Winter season with specific activity override.
         * Demonstrates constant-specific method implementation.
         */
        WINTER(5) {
            /**
             * Overrides the default activity for winter.
             *
             * @return "Hibernate" as the winter-specific activity
             */
            @Override
            public String activity() {
                return "Hibernate";
            }
        },

        /**
         * Spring season using default activity implementation.
         */
        SPRING(15),

        /**
         * Summer season with specific activity override.
         * Demonstrates constant-specific method implementation.
         */
        SUMMER(25) {
            /**
             * Overrides the default activity for summer.
             *
             * @return "Swim" as the summer-specific activity
             */
            @Override
            public String activity() {
                return "Swim";
            }
        },

        /**
         * Autumn season using default activity implementation.
         */
        AUTUMN(10);

        // Fields in enums are typically final to maintain immutability
        private final int averageTemperature;

        /**
         * Enum constructor - implicitly private.
         *
         * <p><strong>From Chapter 7: Adding Constructors, Fields, and Methods</strong><br>
         * Enum constructors are called once for each constant when the enum is
         * first loaded. Constructors are implicitly private and cannot be called
         * directly. They are only invoked when the enum constants are created.
         *
         * @param averageTemperature the average temperature for this season
         */
        Season(int averageTemperature) {
            this.averageTemperature = averageTemperature;
        }

        /**
         * Returns the average temperature for this season.
         *
         * <p>This is a standard getter method available to all enum constants.
         *
         * @return the average temperature in degrees
         */
        public int getAverageTemperature() {
            return averageTemperature;
        }

        /**
         * Returns the typical activity for this season.
         *
         * <p>This is a default implementation that can be overridden by
         * individual enum constants. WINTER and SUMMER provide their own
         * implementations, while SPRING and AUTUMN use this default.
         *
         * @return the activity description for this season
         */
        public String activity() {
            return "Stroll";
        }
    }

    /**
     * Simple enum demonstrating basic enum structure with fields and methods.
     *
     * <p><strong>From Chapter 7: Creating Simple Enums</strong><br>
     * This is a straightforward enum that stores a single field for each constant
     * and provides a getter method. It demonstrates the common pattern of:
     * <ol>
     *   <li>Declaring enum constants with constructor arguments</li>
     *   <li>Storing data in final fields</li>
     *   <li>Providing public accessor methods</li>
     * </ol>
     *
     * <p><strong>Usage in Switch:</strong><br>
     * Enums can be used in switch statements and expressions. When using enums
     * in switch, you only specify the constant name, not the fully qualified name:
     * <pre>{@code
     * ZooTrainTour tour = ZooTrainTour.NORTH;
     * switch (tour) {
     *     case NORTH -> System.out.println("Cold animals");  // Not ZooTrainTour.NORTH
     *     case SOUTH -> System.out.println("Warm animals");
     *     // ...
     * }
     * }</pre>
     */
    public enum ZooTrainTour {
        /**
         * North section featuring penguins.
         */
        NORTH("Penguins"),

        /**
         * South section featuring reptiles.
         */
        SOUTH("Reptiles"),

        /**
         * East section featuring savannah animals.
         */
        EAST("Savannah"),

        /**
         * West section featuring bears.
         */
        WEST("Bears");

        // The main attraction in each section
        private final String highlight;

        /**
         * Constructor for tour sections - implicitly private.
         *
         * <p>Called once for each enum constant during class initialization.
         *
         * @param highlight the main attraction for this section
         */
        ZooTrainTour(String highlight) {
            this.highlight = highlight;
        }

        /**
         * Returns the highlight attraction for this tour section.
         *
         * @return the name of the main attraction
         */
        public String getHighlight() {
            return highlight;
        }
    }
}
