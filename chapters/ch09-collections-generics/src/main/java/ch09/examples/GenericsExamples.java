package ch09.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Consolidates the custom generic type listings from Chapter 9 "Using Generics". The nested types
 * and helper methods reinforce the syntax for type parameters, wildcard bounds, and raw-type pitfalls
 * highlighted in the chapter.
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c09.xhtml">OCP Java SE 17 Study Guide – Chapter 9: Using Generics</a>
 */
public final class GenericsExamples {

    private GenericsExamples() {
    }

    /**
     * Generic container matching the "Crate" example; shows how type parameters travel with
     * instance methods.
     */
    public static final class Crate<T> {

        private T contents;

        /** Packs an item of type {@code T}. */
        public void pack(T item) {
            this.contents = item;
        }

        /** @return the packed item, reinforcing how generics preserve type information */
        public T unpack() {
            return contents;
        }
    }

    public interface Shippable<T> {

        /** Ships an item of type {@code T}. */
        void ship(T t);
    }

    /**
     * Implementation used in the chapter to demonstrate generic classes implementing generic
     * interfaces.
     */
    public static final class ShippableCrate<T> implements Shippable<T> {

        private final List<T> items = new ArrayList<>();

        @Override
        public void ship(T t) {
            items.add(t);
        }

        /**
         * @return immutable snapshot of shipped items, emphasising that generic collections retain
         *     their element type
         */
        public List<T> getItems() {
            return List.copyOf(items);
        }
    }

    /**
     * Generic method example using a type parameter declared on the method itself.
     *
     * @param value element to wrap
     * @param <T> type of element
     * @return immutable singleton list
     */
    public static <T> List<T> singletonList(T value) {
        return List.of(value);
    }

    /**
     * Upper-bounded wildcard demo showing safe reading of {@code ? extends Number} collections.
     *
     * @param numbers numeric list
     * @return total calculated via {@link Number#doubleValue()}
     */
    public static double totalWeight(List<? extends Number> numbers) {
        return numbers.stream().mapToDouble(Number::doubleValue).sum();
    }

    /**
     * Lower-bounded wildcard example allowing addition of {@link Integer} values into any
     * supertype list.
     */
    public static void addNumbers(List<? super Integer> sink) {
        sink.add(1);
        sink.add(2);
    }

    /**
     * Raw-type cautionary example straight from the text: inserting an incompatible value compiles
     * but causes runtime issues.
     */
    public static void rawTypePitfall(List list) {
        list.add(Boolean.TRUE);
    }
}
