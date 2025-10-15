package ch02.assignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CompoundOperationsTest {

    @Test
    void multiplyUsesImplicitCast() {
        assertEquals(21, CompoundOperations.multiply(7, 3L));
    }

    @Test
    void addToShortPromotesAndCastsBack() {
        assertEquals(8, CompoundOperations.addToShort((short) 5, 3));
    }

    @Test
    void assignmentExpressionReturnsValue() {
        assertTrue(CompoundOperations.toggleWithAssignment(false));
        assertEquals(6, CompoundOperations.chainedAssignmentSum());
    }
}
