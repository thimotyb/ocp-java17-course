package ch08.examples;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LambdaSyntaxExamplesTest {

    @Test
    void lambdasHandleDifferentSyntaxVariants() {
        assertTrue(LambdaSyntaxExamples.fullSyntax().test(""));
        assertTrue(LambdaSyntaxExamples.inferredType().test("hello"));
        LambdaSyntaxExamples.singleStatement().accept("output");
        assertTrue(LambdaSyntaxExamples.multiParameter().test("penguin", "pen"));
        assertFalse(LambdaSyntaxExamples.varKeyword().test("oops"));
    }
}
