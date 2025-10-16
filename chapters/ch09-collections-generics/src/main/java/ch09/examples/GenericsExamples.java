package ch09.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates custom generic classes, methods, and wildcards.
 */
public final class GenericsExamples {

    private GenericsExamples() {
    }

    public static final class Crate<T> {

        private T contents;

        public void pack(T item) {
            this.contents = item;
        }

        public T unpack() {
            return contents;
        }
    }

    public interface Shippable<T> {

        void ship(T t);
    }

    public static final class ShippableCrate<T> implements Shippable<T> {

        private final List<T> items = new ArrayList<>();

        @Override
        public void ship(T t) {
            items.add(t);
        }

        public List<T> getItems() {
            return List.copyOf(items);
        }
    }

    public static <T> List<T> singletonList(T value) {
        return List.of(value);
    }

    public static double totalWeight(List<? extends Number> numbers) {
        return numbers.stream().mapToDouble(Number::doubleValue).sum();
    }

    public static void addNumbers(List<? super Integer> sink) {
        sink.add(1);
        sink.add(2);
    }

    public static void rawTypePitfall(List list) {
        list.add(Boolean.TRUE);
    }
}
