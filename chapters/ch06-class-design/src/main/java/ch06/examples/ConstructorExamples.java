package ch06.examples;

import java.util.Objects;

/**
 * Collects the constructor listings from Chapter 6.
 */
public final class ConstructorExamples {

    private ConstructorExamples() {
    }

    public static final class Turtle {

        private String name;

        public Turtle() {
            name = "John Doe";
        }

        public Turtle(int age) {
            name = "Age:" + age;
        }

        public Turtle(long age) {
            name = "Long:" + age;
        }

        public Turtle(String newName, String... favoriteFoods) {
            name = newName + ":" + favoriteFoods.length;
        }

        public String getName() {
            return name;
        }
    }

    public static final class Rabbit1 {
    }

    public static final class Rabbit2 {

        public Rabbit2() {
        }
    }

    public static final class Rabbit3 {

        public Rabbit3(boolean b) {
            Objects.requireNonNull(b);
        }
    }

    public static final class Rabbit4 {

        private Rabbit4() {
        }
    }

    public static final class RabbitsMultiply {

        public static boolean[] create() {
            return new boolean[] {
                new Rabbit1() != null,
                new Rabbit2() != null,
                new Rabbit3(true) != null
            };
        }
    }

    public static final class Hamster {

        private String color;
        private int weight;

        public Hamster(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public Hamster(int weight) {
            this(weight, "brown");
        }

        public String getColor() {
            return color;
        }

        public int getWeight() {
            return weight;
        }
    }

    public static class Animal {

        private int age;

        public Animal(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }
    }

    public static final class Zebra extends Animal {

        public Zebra(int age) {
            super(age);
        }

        public Zebra() {
            this(4);
        }
    }

    public static final class Gorilla extends Animal {

        private String name;

        public Gorilla(int age) {
            super(age);
            this.name = "Gorilla";
        }

        public Gorilla() {
            super(5);
            this.name = "Gorilla";
        }

        public String getName() {
            return name;
        }
    }

    public static final class Donkey {

        public Donkey() {
            super();
        }
    }

    public static class Mammal {

        public Mammal(int age) {
        }
    }

    public static class Seal extends Mammal {

        public Seal() {
            super(0);
        }
    }

    public static class Elephant extends Mammal {

        public Elephant() {
            super(10);
        }

        public Elephant(int age) {
            super(age);
        }
    }
}
