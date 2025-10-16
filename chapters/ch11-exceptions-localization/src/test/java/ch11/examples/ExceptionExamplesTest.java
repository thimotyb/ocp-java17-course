package ch11.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class ExceptionExamplesTest {

    @Test
    void safeDivideThrowsOnZero() {
        assertThrows(ArithmeticException.class, () -> ExceptionExamples.safeDivide(5, 0));
        assertEquals(2, ExceptionExamples.safeDivide(4, 2));
    }

    @Test
    void multiCatchWrapsException() {
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> ExceptionExamples.multiCatchExample(List.of("one")));
        assertTrue(exception.getCause() instanceof IndexOutOfBoundsException);
    }

    @Test
    void finallyOverridesTryReturn() {
        assertEquals(20, ExceptionExamples.finallyOverridesReturn());
    }

    @Test
    void tryWithResourcesReportsSuppressed() throws Exception {
        List<String> events = ExceptionExamples.tryWithResources();
        assertTrue(events.contains("caught RuntimeException"));
        assertTrue(events.stream().anyMatch(e -> e.startsWith("suppressed")));
    }

    @Test
    void customCheckedExceptionThrowsWhenTriggered() {
        assertThrows(ExceptionExamples.CustomCheckedException.class, () -> ExceptionExamples.throwCustomChecked(true));
    }
}
