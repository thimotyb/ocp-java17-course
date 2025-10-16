package ch02.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class OperatorPriceTest {

    @Test
    void evaluatesExpressions() {
        assertEquals(14, OperatorPrice.simpleExpression());
        assertEquals(48, OperatorPrice.expressionWithParentheses());
        assertEquals(48, OperatorPrice.expressionAfterPromotion());
    }
}
