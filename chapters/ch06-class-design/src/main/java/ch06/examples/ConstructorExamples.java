package ch06.examples;

import java.util.Objects;

/**
 * Collects the listings from Chapter 6 "Declaring Constructors" and "Calling Parent Constructors
 * with super()". The nested types show how Java inserts default constructors, enforces chaining
 * rules, and requires explicit super calls when the parent lacks a no-arg constructor.
 *
 * <p>Key concepts from the chapter:</p>
 * <ul>
 *   <li>Each constructor must start with either {@code this(...)} or {@code super(...)}.</li>
 *   <li>Java supplies a default no-argument constructor only when none are declared.</li>
 *   <li>Constructor chaining cannot form cycles and {@code this(...)} must be the first statement.</li>
 *   <li>Subclasses must invoke an explicit parent constructor when the parent defines no default.</li>
 * </ul>
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c06.xhtml">OCP Java SE 17 Study Guide – Chapter 6: Declaring Constructors</a>
 */
public final class ConstructorExamples {

    private ConstructorExamples() {
    }

    /**
     * Demonstrates constructor overloading with different parameter types.
     * <p>
     * From Chapter 6: "Creating a Constructor"
     * <p>
     * Key concepts:
     * <ul>
     *   <li>Multiple constructors with unique signatures (constructor overloading)</li>
     *   <li>Constructors can have different parameter types (int, long, String, varargs)</li>
     *   <li>Each constructor must have a distinct parameter list</li>
     * </ul>
     */
    public static final class Turtle {

        private String name;

        /**
         * No-argument constructor.
         * <p>
         * Initializes the turtle with a default name.
         */
        public Turtle() {
            name = "John Doe";
        }

        /**
         * Constructs a Turtle with an age as an int.
         * <p>
         * Demonstrates constructor overloading with primitive int type.
         *
         * @param age the age as an int
         */
        public Turtle(int age) {
            name = "Age:" + age;
        }

        /**
         * Constructs a Turtle with an age as a long.
         * <p>
         * Demonstrates constructor overloading with primitive long type.
         * This constructor has a different signature from Turtle(int).
         *
         * @param age the age as a long
         */
        public Turtle(long age) {
            name = "Long:" + age;
        }

        /**
         * Constructs a Turtle with a name and favorite foods.
         * <p>
         * Demonstrates constructor with varargs parameter.
         * Varargs must be the last parameter in the parameter list.
         *
         * @param newName the turtle's name
         * @param favoriteFoods variable number of favorite foods
         */
        public Turtle(String newName, String... favoriteFoods) {
            name = newName + ":" + favoriteFoods.length;
        }

        /**
         * Returns the turtle's name.
         *
         * @return the name
         */
        public String getName() {
            return name;
        }
    }

    /**
     * Demonstrates default constructor behavior.
     * <p>
     * From Chapter 6: "The Default Constructor"
     * <p>
     * Since no constructor is defined, Java creates a default no-argument
     * constructor automatically. The default constructor has an empty
     * parameter list and an empty body.
     */
    public static final class Rabbit1 {
        // Default constructor provided by Java
    }

    /**
     * Demonstrates explicit no-argument constructor.
     * <p>
     * From Chapter 6: "The Default Constructor"
     * <p>
     * This is equivalent to Rabbit1, but the constructor is explicitly
     * written. Once you write ANY constructor, Java will NOT provide
     * the default constructor.
     */
    public static final class Rabbit2 {

        /**
         * Explicit no-argument constructor.
         * <p>
         * Functionally identical to what Java would generate as default.
         */
        public Rabbit2() {
        }
    }

    /**
     * Demonstrates that having any constructor prevents default constructor.
     * <p>
     * From Chapter 6: "The Default Constructor"
     * <p>
     * Since this class defines a constructor (with a boolean parameter),
     * Java does NOT provide a default no-argument constructor.
     * Attempting to call "new Rabbit3()" would fail to compile.
     */
    public static final class Rabbit3 {

        /**
         * Constructs a Rabbit3 with a boolean parameter.
         * <p>
         * The presence of this constructor means no default constructor is generated.
         *
         * @param b a boolean value (required non-null)
         */
        public Rabbit3(boolean b) {
            Objects.requireNonNull(b);  // Validates parameter
        }
    }

    /**
     * Demonstrates private constructor preventing instantiation from outside.
     * <p>
     * From Chapter 6: "The Default Constructor"
     * <p>
     * A private constructor cannot be called from outside the class,
     * effectively making the class non-instantiable externally.
     * This pattern is often used for utility classes.
     */
    public static final class Rabbit4 {

        /**
         * Private constructor prevents external instantiation.
         */
        private Rabbit4() {
        }
    }

    /**
     * Helper class demonstrating which Rabbit classes can be instantiated.
     * <p>
     * From Chapter 6: "The Default Constructor"
     * <p>
     * Shows that Rabbit1, Rabbit2, and Rabbit3 can be instantiated,
     * but Rabbit4 cannot (due to private constructor).
     */
    public static final class RabbitsMultiply {

        /**
         * Creates instances of various Rabbit classes.
         * <p>
         * Demonstrates:
         * <ul>
         *   <li>Rabbit1 - uses Java-generated default constructor</li>
         *   <li>Rabbit2 - uses explicit no-argument constructor</li>
         *   <li>Rabbit3 - requires boolean parameter</li>
         * </ul>
         * Note: Cannot instantiate Rabbit4 due to private constructor.
         *
         * @return array of booleans indicating successful instantiation
         */
        public static boolean[] create() {
            return new boolean[] {
                new Rabbit1() != null,  // Default constructor
                new Rabbit2() != null,  // Explicit no-arg constructor
                new Rabbit3(true) != null  // Parameterized constructor
            };
        }
    }

    /**
     * Demonstrates calling overloaded constructors with this().
     * <p>
     * From Chapter 6: "Calling Overloaded Constructors with this()"
     * <p>
     * Key concepts:
     * <ul>
     *   <li>Use this() to call another constructor in the same class</li>
     *   <li>this() must be the FIRST statement in the constructor</li>
     *   <li>Reduces code duplication by reusing constructor logic</li>
     * </ul>
     */
    public static final class Hamster {

        private String color;
        private int weight;

        /**
         * Constructs a Hamster with weight and color.
         * <p>
         * This is the "main" constructor that initializes all fields.
         *
         * @param weight the hamster's weight
         * @param color the hamster's color
         */
        public Hamster(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        /**
         * Constructs a Hamster with weight, using default color.
         * <p>
         * Demonstrates constructor chaining with this().
         * Calls the two-parameter constructor with a default color of "brown".
         *
         * @param weight the hamster's weight
         */
        public Hamster(int weight) {
            this(weight, "brown");  // Calls Hamster(int, String) constructor
        }

        /**
         * Returns the hamster's color.
         *
         * @return the color
         */
        public String getColor() {
            return color;
        }

        /**
         * Returns the hamster's weight.
         *
         * @return the weight
         */
        public int getWeight() {
            return weight;
        }
    }

    /**
     * Parent class demonstrating that subclasses must call parent constructor.
     * <p>
     * From Chapter 6: "Calling Parent Constructors with super()"
     * <p>
     * This class has no default constructor since it defines a parameterized
     * constructor. Subclasses must explicitly call super(age).
     */
    public static class Animal {

        private int age;

        /**
         * Constructs an Animal with the specified age.
         * <p>
         * Since this parameterized constructor exists, there is NO default
         * no-argument constructor. Subclasses must call this constructor.
         *
         * @param age the animal's age
         */
        public Animal(int age) {
            this.age = age;
        }

        /**
         * Returns the animal's age.
         *
         * @return the age
         */
        public int getAge() {
            return age;
        }
    }

    /**
     * Demonstrates calling parent constructor with super() and this().
     * <p>
     * From Chapter 6: "Calling Parent Constructors with super()"
     * <p>
     * Key concepts:
     * <ul>
     *   <li>super() calls the parent class constructor</li>
     *   <li>super() must be the FIRST statement if present</li>
     *   <li>Can use either this() or super(), but not both</li>
     *   <li>Constructor chaining: this() -> super()</li>
     * </ul>
     */
    public static final class Zebra extends Animal {

        /**
         * Constructs a Zebra with the specified age.
         * <p>
         * Explicitly calls the parent Animal(int) constructor with super().
         *
         * @param age the zebra's age
         */
        public Zebra(int age) {
            super(age);  // Calls Animal(int) constructor
        }

        /**
         * Constructs a Zebra with default age of 4.
         * <p>
         * Demonstrates constructor chaining: this() calls Zebra(int),
         * which then calls super(age). The chain is: this(4) -> super(4).
         */
        public Zebra() {
            this(4);  // Calls Zebra(int) constructor, which calls super()
        }
    }

    /**
     * Demonstrates multiple constructors calling super() directly.
     * <p>
     * From Chapter 6: "Calling Parent Constructors with super()"
     * <p>
     * Unlike Zebra which uses this() chaining, both Gorilla constructors
     * directly call super(). This results in duplicated initialization code.
     */
    public static final class Gorilla extends Animal {

        private String name;

        /**
         * Constructs a Gorilla with specified age.
         * <p>
         * Calls parent constructor and initializes name.
         *
         * @param age the gorilla's age
         */
        public Gorilla(int age) {
            super(age);  // Calls Animal(int) constructor
            this.name = "Gorilla";
        }

        /**
         * Constructs a Gorilla with default age of 5.
         * <p>
         * Calls parent constructor directly (not using this() chaining).
         * Note: name initialization is duplicated from other constructor.
         */
        public Gorilla() {
            super(5);  // Calls Animal(int) constructor
            this.name = "Gorilla";  // Duplicated initialization
        }

        /**
         * Returns the gorilla's name.
         *
         * @return the name
         */
        public String getName() {
            return name;
        }
    }

    /**
     * Demonstrates explicit super() call to Object constructor.
     * <p>
     * From Chapter 6: "Calling Parent Constructors with super()"
     * <p>
     * Every class implicitly extends Object. The explicit super() call
     * is optional and redundant here, as Java would insert it automatically.
     */
    public static final class Donkey {

        /**
         * No-argument constructor with explicit super() call.
         * <p>
         * The super() call is redundant - Java would insert it automatically
         * if omitted. Calls Object's no-argument constructor.
         */
        public Donkey() {
            super();  // Explicit call to Object(), inserted by Java if omitted
        }
    }

    /**
     * Parent class requiring explicit super() call from subclasses.
     * <p>
     * From Chapter 6: "Calling Parent Constructors with super()"
     * <p>
     * This class defines only a parameterized constructor, so subclasses
     * cannot rely on a default parent constructor.
     */
    public static class Mammal {

        /**
         * Constructs a Mammal with the specified age.
         * <p>
         * No default constructor exists, so subclasses must call this.
         *
         * @param age the mammal's age
         */
        public Mammal(int age) {
        }
    }

    /**
     * Demonstrates that subclass must call parent's parameterized constructor.
     * <p>
     * From Chapter 6: "Calling Parent Constructors with super()"
     * <p>
     * Since Mammal has no default constructor, Seal must explicitly call
     * super(int). Java cannot insert super() automatically because
     * there's no matching no-argument constructor in Mammal.
     */
    public static class Seal extends Mammal {

        /**
         * Constructs a Seal with default age of 0.
         * <p>
         * Must explicitly call super(0) because Mammal has no default constructor.
         */
        public Seal() {
            super(0);  // Required explicit call to Mammal(int)
        }
    }

    /**
     * Demonstrates constructor overloading in inheritance hierarchy.
     * <p>
     * From Chapter 6: "Calling Parent Constructors with super()"
     * <p>
     * Shows two constructors, both properly calling parent constructor.
     */
    public static class Elephant extends Mammal {

        /**
         * Constructs an Elephant with default age of 10.
         * <p>
         * Calls parent Mammal(int) constructor with default value.
         */
        public Elephant() {
            super(10);  // Calls Mammal(int) with default age
        }

        /**
         * Constructs an Elephant with specified age.
         * <p>
         * Calls parent Mammal(int) constructor with provided age.
         *
         * @param age the elephant's age
         */
        public Elephant(int age) {
            super(age);  // Calls Mammal(int) with provided age
        }
    }
}
