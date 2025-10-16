package ch08.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class BuiltInFunctionalExamplesTest {

    @Test
    void builtInInterfacesBehaveAsExpected() {
        assertTrue(BuiltInFunctionalExamples.nonEmptyPredicate().test("hi"));
        LocalDate today = BuiltInFunctionalExamples.todaySupplier().get();
        assertEquals(LocalDate.now(), today);
        List<String> names = new ArrayList<>();
        BuiltInFunctionalExamples.listAppender(names).accept("Zebra");
        assertEquals(List.of("Zebra"), names);
        assertEquals(Integer.valueOf(4), BuiltInFunctionalExamples.lengthFunction().apply("lion"));
        assertEquals("TIGER", BuiltInFunctionalExamples.upperOperator().apply("tiger"));
        assertTrue(BuiltInFunctionalExamples.containsPredicate().test("hippopotamus", "pot"));
        assertEquals("bea", BuiltInFunctionalExamples.substringFunction().apply("bear", 3));
        assertEquals(Integer.valueOf(7), BuiltInFunctionalExamples.sumOperator().apply(3, 4));
        StringBuilder builder = new StringBuilder();
        BuiltInFunctionalExamples.appendConsumer().accept("lion", builder);
        assertEquals("lion", builder.toString());
    }
}
