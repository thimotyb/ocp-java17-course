package ch02.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class OperatorPerimeterTest {

    @Test
    void matchesParenthesizedCalculation() {
        int standard = OperatorPerimeter.perimeter(3, 5);
        int parenthesized = OperatorPerimeter.perimeterWithParentheses(3, 5);
        assertEquals(standard, parenthesized);
        assertEquals(16, standard);
    }
}
