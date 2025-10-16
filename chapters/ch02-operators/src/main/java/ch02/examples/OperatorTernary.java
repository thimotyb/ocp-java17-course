package ch02.examples;

public final class OperatorTernary {

    private OperatorTernary() {
    }

    public static Result evaluate() {
        int a = 2, b = 4, c = 2;
        int first = (a > 2 ? --c : b++);
        int second = (b = (a != c ? a : b++));
        int third = (a > b ? (b < c ? b : 2) : 1);
        return new Result(first, second, third, a, b, c);
    }

    public static void main(String[] args) {
        Result result = evaluate();
        System.out.println(result.first());
        System.out.println(result.second());
        System.out.println(result.third());
    }

    public record Result(int first, int second, int third, int a, int b, int c) {
    }
}
