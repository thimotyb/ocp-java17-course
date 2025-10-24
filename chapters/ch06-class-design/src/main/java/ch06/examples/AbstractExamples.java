package ch06.examples;

/**
 * Recreates the Chapter 6 listings for "Creating Abstract Classes" so learners can study how
 * abstract types enforce contracts and restrict instantiation.
 *
 * <p>From Chapter 6: Creating Abstract Classes / Declaring Abstract Methods — key ideas:</p>
 * <ul>
 *   <li>Applying the {@code abstract} modifier prevents direct instantiation of a class.</li>
 *   <li>Concrete subclasses must provide implementations for all inherited abstract methods.</li>
 *   <li>Abstract classes may include constructors and non-abstract helpers that delegate to
 *       methods overridden by subclasses.</li>
 *   <li>Invoking abstract methods from constructors executes the subclass implementation once the
 *       object is being constructed (see {@link MammalChew}).</li>
 * </ul>
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c06.xhtml">OCP Java SE 17 Study Guide – Chapter 6: Creating Abstract Classes</a>
 */
public final class AbstractExamples {

    private AbstractExamples() {
    }

    /**
     * Abstract parent from "Introducing Abstract Classes" that guarantees a {@code getSound()}
     * implementation in every concrete canine.
     *
     * <p>Key concepts:</p>
     * <ul>
     *   <li>{@code abstract} instance methods supply a contract that subclasses must fulfil.</li>
     *   <li>Non-abstract helpers (like {@link #bark()}) can rely on those overridden methods to
     *       deliver polymorphic behaviour.</li>
     * </ul>
     */
    public abstract static class Canine {

        /**
         * @return the species-specific sound supplied by subclasses
         */
        public abstract String getSound();

        /**
         * Prints the current animal's call; at runtime the subclass override executes.
         */
        public void bark() {
            System.out.println(getSound());
        }
    }

    /** Concrete subclass from the listing that supplies a unique howl. */
    public static class Wolf extends Canine {

        @Override
        public String getSound() {
            return "Wooooooof!";
        }
    }

    /** Demonstrates that each subclass must provide its own {@code getSound()} implementation. */
    public static class Fox extends Canine {

        @Override
        public String getSound() {
            return "Squeak!";
        }
    }

    /** Another concrete subclass used in the chapter walkthrough. */
    public static class Coyote extends Canine {

        @Override
        public String getSound() {
            return "Yip!";
        }
    }

    /** Abstract parent from "Creating a Concrete Class" that requires subclasses to expose a name. */
    public abstract static class Animal {

        /**
         * @return the display name supplied by the concrete animal
         */
        public abstract String getName();
    }

    /**
     * Abstract intermediate class that adds another required behaviour ({@link #roar()}).
     * Demonstrates that abstract classes can combine concrete and abstract members.
     */
    public abstract static class BigCat extends Animal {

        /** Forces subclasses to explain how they roar. */
        protected abstract void roar();
    }

    /**
     * Concrete implementation from Chapter 6 showing that the first non-abstract subclass must
     * implement every inherited abstract method.
     */
    public static class Lion extends BigCat {

        @Override
        public String getName() {
            return "Lion";
        }

        @Override
        protected void roar() {
            System.out.println("The Lion lets out a loud ROAR!");
        }
    }

    /**
     * Base type from "Declaring Abstract Methods" with two behaviours that subclasses must supply.
     */
    public abstract static class Mammal {

        abstract void showHorn();

        abstract void eatLeaf();
    }

    /**
     * Partial concrete subclass used to illustrate that abstract classes may implement some—but not
     * all—abstract methods, leaving the remainder to further subclasses.
     */
    public abstract static class Rhino extends Mammal {

        @Override
        void showHorn() {
        }
    }

    /**
     * Concrete implementation that completes the contract introduced by {@link Mammal}.
     */
    public static class BlackRhino extends Rhino {

        @Override
        void eatLeaf() {
        }
    }

    /**
     * Alternative concrete subclass showing both abstract methods implemented directly.
     */
    public static class RhinoConcrete extends Mammal {

        @Override
        void showHorn() {
        }

        @Override
        void eatLeaf() {
        }
    }

    /**
     * Listing from "Invoking Abstract Methods in Constructors". The constructor calls the abstract
     * {@link #chew()} method, meaning the subclass override executes during object construction.
     */
    public abstract static class MammalChew {

        abstract CharSequence chew();

        public MammalChew() {
            // In real code this prints the subclass implementation
            var value = chew();
            if (value == null) {
                throw new IllegalStateException("chew returned null");
            }
        }
    }

    /** Concrete subclass confirming that the {@code chew()} contract is honoured at runtime. */
    public static class Platypus extends MammalChew {

        @Override
        public String chew() {
            return "yummy!";
        }
    }
}
