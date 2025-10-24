package ch04.examples;

import java.util.Arrays;

/**
 * Demonstrates Arrays utility methods for sorting and searching in Chapter 4: Core APIs.
 *
 * <p>From Chapter 4: Using Arrays Utility Methods</p>
 *
 * <p>Key concepts demonstrated:</p>
 * <ul>
 *   <li>Arrays.sort() - sorts array in natural order (modifies in place)</li>
 *   <li>String sorting - alphabetical/lexicographic order ("10" < "9")</li>
 *   <li>Arrays.binarySearch() - searches sorted array, returns index or negative insertion point</li>
 *   <li>Binary search on unsorted arrays - unpredictable results</li>
 *   <li>Negative return values: -(insertion point) - 1</li>
 *   <li>Arrays.compare() - compares arrays lexicographically (negative, 0, positive)</li>
 *   <li>Arrays.mismatch() - finds first index where arrays differ, -1 if equal</li>
 * </ul>
 *
 * @see java.util.Arrays
 */
public final class ArraySortSearchExamples {

    private ArraySortSearchExamples() {
    }

    /**
     * Demonstrates Arrays.sort() with numeric array.
     *
     * <p>sort() modifies the array in place, sorting in ascending natural order.
     * For primitives, natural order is numeric order.</p>
     *
     * @return [1, 6, 9] - sorted in ascending order
     */
    public static int[] sortNumbers() {
        int[] numbers = {6, 9, 1};
        Arrays.sort(numbers);  // In-place sort: [1, 6, 9]
        return numbers;
    }

    /**
     * Demonstrates Arrays.sort() with String array.
     *
     * <p>Strings sort in lexicographic (alphabetical) order.
     * Important: "10" < "100" < "9" because comparison is character-by-character.</p>
     *
     * @return ["10", "100", "9"] - lexicographic order, NOT numeric order
     */
    public static String[] sortStrings() {
        String[] strings = {"10", "9", "100"};
        Arrays.sort(strings);  // Lexicographic: "10" < "100" < "9"
        return strings;
    }

    /**
     * Demonstrates Arrays.binarySearch() on a sorted array.
     *
     * <p>binarySearch() returns:</p>
     * <ul>
     *   <li>Index of element if found (>= 0)</li>
     *   <li>-(insertion point) - 1 if not found (< 0)</li>
     * </ul>
     *
     * <p>Array must be sorted before calling binarySearch().</p>
     *
     * @return [0, 1, -1, -2, -5] for searches of 2, 4, 1, 3, 9 in array [2,4,6,8]
     *         0: found at index 0
     *         1: found at index 1
     *         -1: not found, would insert at index 0: -(0)-1 = -1
     *         -2: not found, would insert at index 1: -(1)-1 = -2
     *         -5: not found, would insert at index 4: -(4)-1 = -5
     */
    public static int[] binarySearchResults() {
        int[] numbers = {2, 4, 6, 8};  // Must be sorted
        return new int[] {
            Arrays.binarySearch(numbers, 2),   // 0 (found at index 0)
            Arrays.binarySearch(numbers, 4),   // 1 (found at index 1)
            Arrays.binarySearch(numbers, 1),   // -1 (insert at 0: -(0)-1)
            Arrays.binarySearch(numbers, 3),   // -2 (insert at 1: -(1)-1)
            Arrays.binarySearch(numbers, 9)    // -5 (insert at 4: -(4)-1)
        };
    }

    /**
     * Demonstrates Arrays.binarySearch() on an UNSORTED array.
     *
     * <p>WARNING: binarySearch() requires a sorted array.
     * On unsorted arrays, results are unpredictable and undefined.</p>
     *
     * @return unpredictable results - array is not sorted
     */
    public static int[] binarySearchUnsorted() {
        int[] numbers = new int[] {3, 2, 1};  // NOT sorted - undefined behavior!
        return new int[] {
            Arrays.binarySearch(numbers, 2),  // Unpredictable
            Arrays.binarySearch(numbers, 3)   // Unpredictable
        };
    }

    /**
     * Demonstrates Arrays.compare() for lexicographic array comparison.
     *
     * <p>compare() returns:</p>
     * <ul>
     *   <li>Negative if first array is "less than" second</li>
     *   <li>Zero if arrays are equal</li>
     *   <li>Positive if first array is "greater than" second</li>
     * </ul>
     *
     * @return negative value - [1] < [2]
     */
    public static int compareIntArrays() {
        return Arrays.compare(new int[] {1}, new int[] {2});  // Negative: 1 < 2
    }

    /**
     * Demonstrates Arrays.mismatch() with equal arrays.
     *
     * <p>mismatch() returns the index of the first differing element,
     * or -1 if arrays are equal.</p>
     *
     * @return -1 - arrays are identical
     */
    public static int mismatchEqual() {
        return Arrays.mismatch(new int[] {1}, new int[] {1});  // -1 (equal)
    }

    /**
     * Demonstrates Arrays.mismatch() with different case.
     *
     * <p>String comparison is case-sensitive: "a" != "A"</p>
     *
     * @return 0 - first element differs at index 0
     */
    public static int mismatchDifferentCase() {
        return Arrays.mismatch(new String[] {"a"}, new String[] {"A"});  // 0 (differ at index 0)
    }

    /**
     * Demonstrates Arrays.mismatch() with different lengths.
     *
     * <p>When arrays have same elements up to the shorter length,
     * mismatch returns the length of the shorter array.</p>
     *
     * @return 1 - arrays match at index 0, differ at index 1 (second array ends)
     */
    public static int mismatchLength() {
        return Arrays.mismatch(new int[] {1, 2}, new int[] {1});  // 1 (differ at index 1)
    }
}
