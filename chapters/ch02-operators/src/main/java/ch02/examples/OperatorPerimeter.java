package ch02.examples;

public final class OperatorPerimeter {

    private OperatorPerimeter() {
    }

    public static int perimeter(int height, int length) {
        var perimeter = 2 * height + 2 * length;
        return perimeter;
    }

    public static int perimeterWithParentheses(int height, int length) {
        var perimeter = ((2 * height) + (2 * length));
        return perimeter;
    }
}
