package ch06.examples;

/**
 * Showcases abstract class listings and behaviour.
 */
public final class AbstractExamples {

    private AbstractExamples() {
    }

    public abstract static class Canine {

        public abstract String getSound();

        public void bark() {
            System.out.println(getSound());
        }
    }

    public static class Wolf extends Canine {

        @Override
        public String getSound() {
            return "Wooooooof!";
        }
    }

    public static class Fox extends Canine {

        @Override
        public String getSound() {
            return "Squeak!";
        }
    }

    public static class Coyote extends Canine {

        @Override
        public String getSound() {
            return "Yip!";
        }
    }

    public abstract static class Animal {

        public abstract String getName();
    }

    public abstract static class BigCat extends Animal {

        protected abstract void roar();
    }

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

    public abstract static class Mammal {

        abstract void showHorn();

        abstract void eatLeaf();
    }

    public abstract static class Rhino extends Mammal {

        @Override
        void showHorn() {
        }
    }

    public static class BlackRhino extends Rhino {

        @Override
        void eatLeaf() {
        }
    }

    public static class RhinoConcrete extends Mammal {

        @Override
        void showHorn() {
        }

        @Override
        void eatLeaf() {
        }
    }

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

    public static class Platypus extends MammalChew {

        @Override
        public String chew() {
            return "yummy!";
        }
    }
}
