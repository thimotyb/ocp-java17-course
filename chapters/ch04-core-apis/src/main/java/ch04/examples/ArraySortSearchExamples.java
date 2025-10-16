package ch04.examples;

import java.util.Arrays;

public final class ArraySortSearchExamples {

    private ArraySortSearchExamples() {
    }

    public static int[] sortNumbers() {
        int[] numbers = {6, 9, 1};
        Arrays.sort(numbers);
        return numbers;
    }

    public static String[] sortStrings() {
        String[] strings = {"10", "9", "100"};
        Arrays.sort(strings);
        return strings;
    }

    public static int[] binarySearchResults() {
        int[] numbers = {2, 4, 6, 8};
        return new int[] {
            Arrays.binarySearch(numbers, 2),
            Arrays.binarySearch(numbers, 4),
            Arrays.binarySearch(numbers, 1),
            Arrays.binarySearch(numbers, 3),
            Arrays.binarySearch(numbers, 9)
        };
    }

    public static int[] binarySearchUnsorted() {
        int[] numbers = new int[] {3, 2, 1};
        return new int[] {
            Arrays.binarySearch(numbers, 2),
            Arrays.binarySearch(numbers, 3)
        };
    }

    public static int compareIntArrays() {
        return Arrays.compare(new int[] {1}, new int[] {2});
    }

    public static int mismatchEqual() {
        return Arrays.mismatch(new int[] {1}, new int[] {1});
    }

    public static int mismatchDifferentCase() {
        return Arrays.mismatch(new String[] {"a"}, new String[] {"A"});
    }

    public static int mismatchLength() {
        return Arrays.mismatch(new int[] {1, 2}, new int[] {1});
    }
}
