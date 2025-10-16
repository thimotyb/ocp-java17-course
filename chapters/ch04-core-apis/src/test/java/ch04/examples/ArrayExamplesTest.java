package ch04.examples;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ArrayExamplesTest {

    @Test
    void bugsAliasAndCastingBehaveAsDescribed() {
        Object[] info = ArrayDeclarationsExamples.bugsAlias();
        assertEquals(Boolean.TRUE, info[0]);
        assertTrue(((String) info[1]).startsWith("["));
        assertTrue(ArrayDeclarationsExamples.arrayStoreExceptionExample() instanceof Exception);
        assertEquals("updated", ArrayDeclarationsExamples.arrayCastingExample());
    }

    @Test
    void mammalsAndNumbers() {
        int[] lengths = ArrayDeclarationsExamples.mammalsArray();
        assertEquals(3, lengths[0]);
        assertArrayEquals(new String[] {"5", "6", "7", "8", "9", "10", "11", "12", "13", "14"},
                ArrayDeclarationsExamples.fillNumbers());
    }

    @Test
    void sortAndSearchExamples() {
        assertArrayEquals(new int[] {1, 6, 9}, ArraySortSearchExamples.sortNumbers());
        assertArrayEquals(new String[] {"10", "100", "9"}, ArraySortSearchExamples.sortStrings());
        assertArrayEquals(new int[] {0, 1, -1, -2, -5}, ArraySortSearchExamples.binarySearchResults());
    }

    @Test
    void compareAndMismatch() {
        assertTrue(ArraySortSearchExamples.compareIntArrays() < 0);
        assertEquals(-1, ArraySortSearchExamples.mismatchEqual());
        assertEquals(0, ArraySortSearchExamples.mismatchDifferentCase());
        assertEquals(1, ArraySortSearchExamples.mismatchLength());
    }
}
