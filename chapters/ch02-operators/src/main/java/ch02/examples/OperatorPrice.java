package ch02.examples;

public final class OperatorPrice {

    private OperatorPrice() {
    }

    public static int simpleExpression() {
        int price = 2 * 5 + 3 * 4 - 8;
        return price;
    }

    public static int expressionWithParentheses() {
        int price = 2 * ((5 + 3) * 4 - 8);
        return price;
    }

    public static int expressionAfterPromotion() {
        int price = 2 * 24;
        return price;
    }
}
