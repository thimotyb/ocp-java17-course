package ch06.examples;

/**
 * Mirrors the Chapter 6 walkthroughs from "Declaring a Subclass", "Accessing the this Reference",
 * and "Calling the super Reference" so learners can observe how scope, access modifiers, and
 * variable hiding interact across an inheritance hierarchy.
 *
 * <p>Concepts reinforced:</p>
 * <ul>
 *   <li>{@code protected} members are inherited but still respect package and subclass boundaries.</li>
 *   <li>{@code this} resolves naming conflicts by pointing at the current instance, whereas
 *       {@code super} targets the parent portion of the object.</li>
 *   <li>Variable hiding stores separate copies of fields with the same name at different hierarchy
 *       levels.</li>
 * </ul>
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c06.xhtml">OCP Java SE 17 Study Guide – Chapter 6: Understanding Inheritance</a>
 */
public final class InheritanceExamples {

    private InheritanceExamples() {
    }

    /**
     * Demonstrates protected field access in inheritance.
     * <p>
     * From Chapter 6: "Declaring a Subclass"
     * <p>
     * Key concepts:
     * <ul>
     *   <li>Protected members are accessible in subclasses</li>
     *   <li>Protected members are inherited by child classes</li>
     * </ul>
     */
    public static class BigCat {

        /** Size of the big cat, accessible to subclasses */
        protected double size;
    }

    /**
     * Subclass demonstrating inheritance of protected members.
     * <p>
     * From Chapter 6: "Declaring a Subclass"
     * <p>
     * The Jaguar class inherits from BigCat and can directly access
     * the protected 'size' field as if it were its own member.
     */
    public static class Jaguar extends BigCat {

        /**
         * Constructs a Jaguar and initializes the inherited size field.
         * Demonstrates that subclasses can directly read/write protected members.
         */
        public Jaguar() {
            size = 10.2;  // Accessing inherited protected field
        }

        /**
         * Returns the size of the jaguar.
         * <p>
         * Demonstrates accessing an inherited protected field.
         *
         * @return the size value inherited from BigCat
         */
        public double printDetails() {
            return size;  // Reading inherited protected field
        }
    }

    /**
     * Demonstrates that non-inherited classes cannot access protected members.
     * <p>
     * From Chapter 6: "Declaring a Subclass"
     * <p>
     * Spider does not extend BigCat, so it has no access to BigCat's protected
     * members. The commented line would not compile if uncommented.
     */
    public static class Spider {

        // public void printDetails() { System.out.println(size); } // DOES NOT COMPILE
        // Spider has no access to 'size' since it doesn't inherit from BigCat
    }

    /**
     * Demonstrates using 'this' reference to resolve naming conflicts.
     * <p>
     * From Chapter 6: "Accessing the this Reference"
     * <p>
     * Key concepts:
     * <ul>
     *   <li>Java uses the most granular scope when resolving variable names</li>
     *   <li>The 'this' keyword refers to the current instance of the class</li>
     *   <li>Use 'this' to distinguish instance variables from method parameters</li>
     * </ul>
     */
    public static class Flamingo {

        /** The color of the flamingo */
        private String color;

        /**
         * Sets the color of the flamingo.
         * <p>
         * Uses 'this.color' to distinguish the instance variable from the
         * method parameter with the same name.
         *
         * @param color the color to set
         */
        public void setColor(String color) {
            this.color = color;  // 'this' required to access instance variable
        }

        /**
         * Returns the color of the flamingo.
         *
         * @return the flamingo's color
         */
        public String getColor() {
            return color;
        }
    }

    /**
     * Demonstrates common mistakes with 'this' reference.
     * <p>
     * From Chapter 6: "Accessing the this Reference"
     * <p>
     * This class intentionally shows incorrect usage on line 52 where
     * 'length = this.length' assigns backwards (parameter to instance variable),
     * leaving the instance variable at its default value.
     */
    public static class DuckData {

        private String color;
        private int height;
        private int length;

        /**
         * Sets the data fields, demonstrating correct and incorrect use of 'this'.
         * <p>
         * Line 1: INCORRECT - assigns instance variable to parameter (backwards)<br>
         * Line 2: CORRECT - no naming conflict, 'this' not needed<br>
         * Line 3: CORRECT - 'this' optional but clarifies intent
         *
         * @param length the length (incorrectly assigned due to missing 'this')
         * @param theHeight the height to set
         */
        public void setData(int length, int theHeight) {
            length = this.length; // INCORRECT: assigns 0 to parameter, doesn't update field
            height = theHeight;   // Correct: no naming conflict
            this.color = "white"; // Correct: 'this' optional but clear
        }

        /**
         * Returns a summary of the duck's dimensions.
         * <p>
         * Will show length=0 due to the incorrect assignment in setData().
         *
         * @return string representation of length, height, and color
         */
        public String summary() {
            return length + " " + height + " " + color;
        }
    }

    /**
     * Parent class demonstrating variable hiding.
     * <p>
     * From Chapter 6: "Calling the super Reference"
     */
    public static class Reptile {

        /** Speed at the Reptile level */
        protected int speed = 10;
    }

    /**
     * Demonstrates using 'super' to access hidden parent class variables.
     * <p>
     * From Chapter 6: "Calling the super Reference"
     * <p>
     * Key concepts:
     * <ul>
     *   <li>An instance stores TWO separate values for 'speed'</li>
     *   <li>One at the Reptile level and one at the Crocodile level</li>
     *   <li>'this.speed' or 'speed' accesses the current class variable</li>
     *   <li>'super.speed' accesses the parent class variable</li>
     * </ul>
     */
    public static class Crocodile extends Reptile {

        /** Speed at the Crocodile level (hides Reptile's speed) */
        protected int speed = 20;

        /**
         * Returns the current class's speed value.
         * <p>
         * Accesses Crocodile's speed field (value 20).
         *
         * @return the speed defined in Crocodile (20)
         */
        public int getSpeed() {
            return speed;  // Returns 20 (Crocodile's speed)
        }

        /**
         * Returns the parent class's speed value.
         * <p>
         * Uses 'super' to access Reptile's speed field (value 10).
         * Demonstrates that both values exist simultaneously in the instance.
         *
         * @return the speed defined in Reptile (10)
         */
        public int getParentSpeed() {
            return super.speed;  // Returns 10 (Reptile's speed)
        }
    }

    /**
     * Parent class for demonstrating 'this' vs 'super' with inherited members.
     * <p>
     * From Chapter 6: "Calling the super Reference"
     */
    public static class ZooLabel {

        /** Label defined in parent class */
        protected String label = "Zoo";
    }

    /**
     * Demonstrates difference between 'this' and 'super' references.
     * <p>
     * From Chapter 6: "Calling the super Reference"
     * <p>
     * Key concepts:
     * <ul>
     *   <li>'this' includes both current and inherited members</li>
     *   <li>'super' includes only inherited members</li>
     *   <li>Variable hiding creates separate storage for same-named variables</li>
     * </ul>
     */
    public static class GiftShop extends ZooLabel {

        /** Label defined in child class (hides parent's label) */
        private String label = "Gift Shop";

        /**
         * Demonstrates accessing hidden variables using 'this' and 'super'.
         * <p>
         * Returns a string showing three different ways to access the label:
         * <ul>
         *   <li>Unqualified 'label' - uses most granular scope (current class)</li>
         *   <li>'this.label' - explicitly accesses current class member</li>
         *   <li>'super.label' - explicitly accesses parent class member</li>
         * </ul>
         *
         * @return "Gift Shop-Gift Shop-Zoo" demonstrating all three access methods
         */
        public String printData() {
            String a = label;        // Accesses GiftShop's label (most granular scope)
            String b = this.label;   // Explicitly accesses GiftShop's label
            String c = super.label;  // Accesses ZooLabel's label
            return a + "-" + b + "-" + c;  // Returns "Gift Shop-Gift Shop-Zoo"
        }
    }
}
