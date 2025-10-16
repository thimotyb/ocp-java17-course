package ch02.examples;

public final class OperatorDivisionModulus {

    private OperatorDivisionModulus() {
    }

    public static int[] divisions(int value, int divisor) {
        return new int[] {value / divisor, value % divisor};
    }

    public static int[][] demo() {
        return new int[][] {
            {9 / 3, 9 % 3},
            {10 / 3, 10 % 3},
            {11 / 3, 11 % 3},
            {12 / 3, 12 % 3}
        };
    }
}
