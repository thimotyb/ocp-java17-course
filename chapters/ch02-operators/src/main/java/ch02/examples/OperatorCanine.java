package ch02.examples;

public final class OperatorCanine {

    private OperatorCanine() {
    }

    public static Result evaluate() {
        boolean canine = true, wolf = true;
        int teeth = 20;
        canine = (teeth != 10) ^ (wolf = false);
        return new Result(canine, teeth, wolf);
    }

    public static void main(String[] args) {
        Result result = evaluate();
        System.out.println(result.canine() + ", " + result.teeth() + ", " + result.wolf());
    }

    public record Result(boolean canine, int teeth, boolean wolf) {
    }
}
