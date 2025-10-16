package ch02.examples;

public final class OperatorSamples {

    private OperatorSamples() {
    }

    public static int[] evaluate() {
        int sample1 = (2 * 4) % 3;
        int sample2 = 3 * 2 % 3;
        int sample3 = 5 * (1 % 2);
        return new int[] {sample1, sample2, sample3};
    }
}
