package ch09.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class GenericsExamplesTest {

    @Test
    void crateStoresGenericType() {
        var crate = new GenericsExamples.Crate<String>();
        crate.pack("Bananas");
        assertEquals("Bananas", crate.unpack());
    }

    @Test
    void shippableCollectsItems() {
        var crate = new GenericsExamples.ShippableCrate<Integer>();
        crate.ship(1);
        crate.ship(2);
        assertEquals(List.of(1, 2), crate.getItems());
    }

    @Test
    void singletonListUsesGenericMethod() {
        assertEquals(List.of("fox"), GenericsExamples.singletonList("fox"));
    }

    @Test
    void upperBoundWildcardCalculatesSum() {
        assertEquals(6.0, GenericsExamples.totalWeight(List.of(1, 2, 3)), 0.0001);
    }

    @Test
    void lowerBoundWildcardAllowsAddingIntegers() {
        List<Number> sink = new ArrayList<>();
        GenericsExamples.addNumbers(sink);
        assertEquals(List.of(1, 2), sink);
    }

    @Test
    void rawTypeAllowsMixedContent() {
        List<String> names = new ArrayList<>();
        GenericsExamples.rawTypePitfall(names);
        assertThrows(ClassCastException.class, () -> {
            for (String name : names) {
                name.length();
            }
        });
    }
}
