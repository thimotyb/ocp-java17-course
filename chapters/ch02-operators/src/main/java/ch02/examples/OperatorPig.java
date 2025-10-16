package ch02.examples;

public final class OperatorPig {

    private OperatorPig() {
    }

    public static Result evaluate() {
        int pig = (short) 4;
        pig = pig++;
        long goat = (int) 2;
        goat -= 1.0;
        return new Result(pig, goat);
    }

    public static void main(String[] args) {
        Result result = evaluate();
        System.out.print(result.pig() + " - " + result.goat());
    }

    public record Result(int pig, long goat) {
    }
}
