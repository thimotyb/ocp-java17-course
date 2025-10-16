package ch06.examples;

/**
 * Mirrors Chapter 6 inheritance, access, and reference examples.
 */
public final class InheritanceExamples {

    private InheritanceExamples() {
    }

    public static class BigCat {

        protected double size;
    }

    public static class Jaguar extends BigCat {

        public Jaguar() {
            size = 10.2;
        }

        public double printDetails() {
            return size;
        }
    }

    public static class Spider {

        // public void printDetails() { System.out.println(size); } // DOES NOT COMPILE
    }

    public static class Flamingo {

        private String color;

        public void setColor(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }
    }

    public static class DuckData {

        private String color;
        private int height;
        private int length;

        public void setData(int length, int theHeight) {
            length = this.length; // demonstration of a mistake
            height = theHeight;
            this.color = "white";
        }

        public String summary() {
            return length + " " + height + " " + color;
        }
    }

    public static class Reptile {

        protected int speed = 10;
    }

    public static class Crocodile extends Reptile {

        protected int speed = 20;

        public int getSpeed() {
            return speed;
        }

        public int getParentSpeed() {
            return super.speed;
        }
    }

    public static class ZooLabel {

        protected String label = "Zoo";
    }

    public static class GiftShop extends ZooLabel {

        private String label = "Gift Shop";

        public String printData() {
            String a = label;
            String b = this.label;
            String c = super.label;
            return a + "-" + b + "-" + c;
        }
    }
}
