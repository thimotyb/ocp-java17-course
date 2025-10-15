package ch02.comparison;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class ComparisonPlaygroundTest {

    @Test
    void verifiesIntegerCachingBehaviour() {
        assertTrue(ComparisonPlayground.smallIntegerCacheHit());
        assertFalse(ComparisonPlayground.largeIntegerCacheMiss());
    }

    @Test
    void checksStringReferenceBehaviour() {
        assertTrue(ComparisonPlayground.internedStringEquals());
        assertTrue(ComparisonPlayground.trimmedStringSameReference("java"));
        assertFalse(ComparisonPlayground.trimmedStringSameReference(" java "));
    }

    @Test
    void delegatesToObjectsEquals() {
        assertTrue(ComparisonPlayground.objectsEquals(List.of(1, 2), List.of(1, 2)));
        assertFalse(ComparisonPlayground.objectsEquals(List.of(1), null));
    }

    @Test
    void usesPatternMatchingInstanceof() {
        assertTrue(ComparisonPlayground.patternMatch("zookeeper"));
        assertFalse(ComparisonPlayground.patternMatch(10));
    }
}
