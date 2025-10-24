package ch06.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements the Chapter 6 scenarios for "Initializing Classes", "Initializing Instances", and
 * "Order of Initialization". Each nested type records the execution order into {@link #OUTPUT} so
 * you can confirm the paths described in the book.
 *
 * <p>Key takeaways:</p>
 * <ul>
 *   <li>Static initializers execute once per class, parent before child.</li>
 *   <li>Instance initializers run before the constructor body every time a new object is created.</li>
 *   <li>Constructors chain from parent to child, respecting any {@code this(...)} calls.</li>
 *   <li>Initialization order is fixed: static → instance → constructor for each level of the
 *       hierarchy.</li>
 * </ul>
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c06.xhtml">OCP Java SE 17 Study Guide – Chapter 6: Initializing Objects</a>
 */
public final class InitializationExamples {

    private InitializationExamples() {
    }

    /**
     * Parent class demonstrating static initialization.
     * <p>
     * From Chapter 6: "Initializing Classes"
     * <p>
     * Static initializers run when the class is first loaded by the JVM,
     * before any static methods are called or instances created.
     */
    public static class Animal {

        static {
            OUTPUT.add("A");  // Runs when Animal class is loaded
        }
    }

    /**
     * Child class demonstrating static initialization order in inheritance.
     * <p>
     * From Chapter 6: "Initializing Classes"
     * <p>
     * Key concepts:
     * <ul>
     *   <li>Parent static initializers run before child static initializers</li>
     *   <li>Static initializers run only once when class is first loaded</li>
     *   <li>Creating multiple instances doesn't re-run static initializers</li>
     * </ul>
     * <p>
     * Execution order when runMain is called:
     * 1. Animal static block (A) - parent class initialization
     * 2. Hippo static block (B) - child class initialization
     * 3. runMain method body (C)
     * 4. Instance creation (twice) - no static blocks re-run
     */
    public static class Hippo extends Animal {

        static {
            OUTPUT.add("B");  // Runs after Animal's static block
        }

        /**
         * Demonstrates that static blocks run before any static method.
         * <p>
         * Creates two instances to show static blocks run only once.
         *
         * @param collector list to collect execution order markers
         */
        public static void runMain(List<String> collector) {
            collector.add("C");  // Runs after both static blocks
            new Hippo();  // Instance creation
            new Hippo();  // Second instance - no static blocks re-run
        }
    }

    /**
     * Helper class demonstrating static initialization from external reference.
     * <p>
     * From Chapter 6: "Initializing Classes"
     * <p>
     * When HippoFriend references Hippo, Hippo's class is loaded,
     * triggering its static initialization chain (Animal -> Hippo).
     */
    public static final class HippoFriend {

        /**
         * Creates a Hippo instance, triggering class initialization.
         *
         * @param collector list to collect execution order markers
         */
        public static void run(List<String> collector) {
            collector.add("C");
            new Hippo();  // Triggers Hippo class load if not already loaded
        }
    }

    /** Shared output list to track initialization order */
    private static final List<String> OUTPUT = new ArrayList<>();

    /**
     * Demonstrates the complete static initialization sequence.
     * <p>
     * Expected output: [A, B, C]
     * - A: Animal static block
     * - B: Hippo static block
     * - C: runMain method execution
     *
     * @return list showing initialization order
     */
    public static List<String> hippoSequence() {
        OUTPUT.clear();
        Hippo.runMain(OUTPUT);
        return new ArrayList<>(OUTPUT);
    }

    /**
     * Demonstrates instance initializer blocks and final field initialization.
     * <p>
     * From Chapter 6: "Initializing Instances" and "Initializing Final Fields"
     * <p>
     * Key concepts:
     * <ul>
     *   <li>Instance initializers run before constructor body</li>
     *   <li>Instance initializers can initialize final fields</li>
     *   <li>Final fields must be initialized exactly once</li>
     * </ul>
     * <p>
     * Execution order when creating an instance:
     * 1. Instance initializer block (sets volume = 10)
     * 2. Constructor body (sets type)
     */
    public static final class MouseHouse {

        /** Final field initialized in instance initializer */
        private final int volume;
        /** Final field initialized in constructor */
        private final String type;

        {
            // Instance initializer runs before constructor
            this.volume = 10;
        }

        /**
         * Constructs a MouseHouse with specified type.
         * <p>
         * The instance initializer runs first, then this constructor body.
         *
         * @param type the type of mouse house
         */
        public MouseHouse(String type) {
            this.type = type;
        }

        /**
         * Constructs a MouseHouse with null type.
         * <p>
         * Delegates to MouseHouse(String) using this().
         * Execution order: instance initializer -> this(null)
         */
        public MouseHouse() {
            this(null);  // Calls MouseHouse(String) constructor
        }

        /**
         * Returns the volume.
         *
         * @return the volume initialized in instance initializer
         */
        public int getVolume() {
            return volume;
        }

        /**
         * Returns the type.
         *
         * @return the type initialized in constructor
         */
        public String getType() {
            return type;
        }
    }

    /**
     * Demonstrates complex initialization order with static and instance blocks.
     * <p>
     * From Chapter 6: "Order of Initialization"
     * <p>
     * Key concepts:
     * <ul>
     *   <li>Static blocks execute in order they appear, once per class</li>
     *   <li>Instance blocks execute in order they appear, before constructor</li>
     *   <li>Fields can be initialized inline or in initializers</li>
     * </ul>
     * <p>
     * Execution order when generate() is called:
     * 1. Static blocks: COUNT=0 -> "0-" -> COUNT=10 -> "10-"
     * 2. Instance block: "BestZoo-"
     * 3. Constructor: "z-"
     * <p>
     * Final OUTPUT: ["0-", "10-", "BestZoo-", "z-"]
     */
    public static final class ZooTickets {

        /** Instance field initialized inline */
        private String name = "BestZoo";
        {
            // Instance initializer - runs before constructor
            OUTPUT.add(name + "-");
        }
        /** Static field initialized inline */
        private static int COUNT = 0;
        static {
            // First static block - runs when class loads
            OUTPUT.add(COUNT + "-");
        }
        static {
            // Second static block - runs after first static block
            COUNT += 10;
            OUTPUT.add(COUNT + "-");
        }

        /**
         * Constructor - runs after instance initializers.
         */
        public ZooTickets() {
            OUTPUT.add("z-");
        }

        /**
         * Demonstrates complete initialization sequence.
         * <p>
         * Output order: static blocks -> instance block -> constructor
         */
        public static void generate() {
            OUTPUT.clear();
            new ZooTickets();
        }
    }

    /**
     * Parent class demonstrating constructor order in inheritance.
     * <p>
     * From Chapter 6: "Order of Initialization"
     */
    public static class Primate {

        /**
         * Primate constructor.
         * <p>
         * In inheritance, parent constructor always runs before child constructor.
         */
        public Primate() {
            OUTPUT.add("Primate-");
        }
    }

    /**
     * Child class demonstrating overloaded constructors in inheritance.
     * <p>
     * From Chapter 6: "Order of Initialization"
     */
    public static class Ape extends Primate {

        /**
         * Parameterized constructor.
         * <p>
         * Implicitly calls super() first, then executes body.
         *
         * @param fur number of fur units
         */
        public Ape(int fur) {
            // Implicit super() call here
            OUTPUT.add("Ape1-");
        }

        /**
         * No-argument constructor.
         * <p>
         * Implicitly calls super() first, then executes body.
         */
        public Ape() {
            // Implicit super() call here
            OUTPUT.add("Ape2-");
        }
    }

    /**
     * Demonstrates complete constructor chain in inheritance.
     * <p>
     * From Chapter 6: "Order of Initialization"
     * <p>
     * Execution order when creating new Chimpanzee():
     * 1. super(2) calls Ape(int)
     * 2. Ape(int) implicitly calls super()
     * 3. Primate() executes -> "Primate-"
     * 4. Ape(int) body executes -> "Ape1-"
     * 5. Chimpanzee() body executes -> "Chimpanzee-"
     * <p>
     * Final OUTPUT: ["Primate-", "Ape1-", "Chimpanzee-"]
     */
    public static class Chimpanzee extends Ape {

        /**
         * Chimpanzee constructor.
         * <p>
         * Explicitly calls super(2), which triggers parent constructor chain.
         */
        public Chimpanzee() {
            super(2);  // Calls Ape(int) constructor
            OUTPUT.add("Chimpanzee-");
        }
    }

    /**
     * Demonstrates instance blocks accessing static variables.
     * <p>
     * From Chapter 6: "Order of Initialization"
     * <p>
     * Key concepts:
     * <ul>
     *   <li>Instance blocks can access and modify static variables</li>
     *   <li>Multiple instance blocks execute in order they appear</li>
     *   <li>Each instance creation increments COUNT</li>
     * </ul>
     * <p>
     * Execution order when creating new Cuttlefish():
     * 1. Static block: "0" (class initialization, once only)
     * 2. First instance block: "swimmy" (reads name)
     * 3. Second instance block: COUNT becomes 1, outputs "1"
     * 4. Constructor: "Constructor"
     */
    public static class Cuttlefish {

        private String name = "swimmy";
        {
            // First instance initializer
            OUTPUT.add(name);
        }
        private static int COUNT = 0;
        static {
            // Static initializer - runs once when class loads
            OUTPUT.add(String.valueOf(COUNT));
        }
        {
            // Second instance initializer - modifies static COUNT
            COUNT++;
            OUTPUT.add(String.valueOf(COUNT));
        }

        /**
         * Constructor - runs after all instance initializers.
         */
        public Cuttlefish() {
            OUTPUT.add("Constructor");
        }
    }

    /**
     * Demonstrates complex constructor chaining with this().
     * <p>
     * From Chapter 6: "Order of Initialization"
     * <p>
     * Key concepts:
     * <ul>
     *   <li>Constructors can chain with this()</li>
     *   <li>Instance blocks run before ANY constructor body</li>
     *   <li>this() must be first statement in constructor</li>
     * </ul>
     */
    public static class GiraffeFamily {

        static {
            OUTPUT.add("A");  // Static block - runs once at class load
        }
        {
            OUTPUT.add("B");  // Instance block - runs before every constructor
        }

        /**
         * Constructor with String parameter.
         * <p>
         * Chains to GiraffeFamily(int) with this(1).
         * Execution: instance block -> this(1) -> this constructor body
         *
         * @param name the giraffe name (unused in implementation)
         */
        public GiraffeFamily(String name) {
            this(1);  // Calls GiraffeFamily(int) constructor
            OUTPUT.add("C");
        }

        /**
         * No-argument constructor.
         * <p>
         * Implicitly calls super(), then executes body.
         * Execution: instance block -> constructor body
         */
        public GiraffeFamily() {
            // Implicit super() call
            OUTPUT.add("D");
        }

        /**
         * Constructor with int parameter.
         * <p>
         * Implicitly calls super(), then executes body.
         * Execution: instance block -> constructor body
         *
         * @param stripes number of stripes
         */
        public GiraffeFamily(int stripes) {
            // Implicit super() call
            OUTPUT.add("E");
        }
    }

    /**
     * Demonstrates complete initialization order in inheritance with chaining.
     * <p>
     * From Chapter 6: "Order of Initialization"
     * <p>
     * Complete execution order when creating new Okapi(1):
     * 1. GiraffeFamily static block: "A" (parent class load)
     * 2. Okapi static block: "F" (child class load)
     * 3. super("sugar") calls GiraffeFamily(String)
     * 4. GiraffeFamily instance block: "B" (parent instance init)
     * 5. GiraffeFamily(String) calls this(1)
     * 6. GiraffeFamily(int) body: "E"
     * 7. GiraffeFamily(String) body: "C"
     * 8. Okapi instance block: "H" (child instance init)
     * 9. Okapi constructor body: "G"
     * <p>
     * Final OUTPUT: ["A", "F", "B", "E", "C", "H", "G"]
     */
    public static class Okapi extends GiraffeFamily {

        static {
            OUTPUT.add("F");  // Static block - runs after parent static
        }
        {
            OUTPUT.add("H");  // Instance block - runs after parent constructor completes
        }

        /**
         * Okapi constructor.
         * <p>
         * Calls parent constructor with super("sugar"), triggering complex chain.
         *
         * @param stripes number of stripes (unused in implementation)
         */
        public Okapi(int stripes) {
            super("sugar");  // Calls GiraffeFamily(String) constructor
            OUTPUT.add("G");
        }
    }

    /**
     * Returns a copy of the output list.
     * <p>
     * Used for testing initialization order.
     *
     * @return copy of OUTPUT list
     */
    public static List<String> getOutput() {
        return new ArrayList<>(OUTPUT);
    }

    /**
     * Clears the output list.
     * <p>
     * Used to reset state between tests.
     */
    public static void clearOutput() {
        OUTPUT.clear();
    }
}
