package ch02.examples;

public final class OperatorWaterQuality {

    private OperatorWaterQuality() {
    }

    public static Result evaluate() {
        int ph = 7, vis = 2;
        boolean clear = vis > 1 & (vis < 9 || ph < 2);
        boolean safe = (vis > 2) && (ph++ > 1);
        boolean tasty = 7 <= --ph;
        return new Result(clear, safe, tasty, ph, vis);
    }

    public record Result(boolean clear, boolean safe, boolean tasty, int ph, int vis) {
    }
}
