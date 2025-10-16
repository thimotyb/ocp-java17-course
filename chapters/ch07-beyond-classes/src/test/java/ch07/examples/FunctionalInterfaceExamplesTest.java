package ch07.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class FunctionalInterfaceExamplesTest {

    @Test
    void lambdaTargetsFunctionalInterface() {
        List<Integer> runs = new ArrayList<>();
        FunctionalInterfaceExamples runner = runs::add;
        runner.sprint(10);
        runner.sprint(15);
        assertEquals(List.of(10, 15), runs);
    }

    @Test
    void helperCapturesAdditionalRuns() {
        FunctionalInterfaceExamples recorder = speed -> { };
        List<Integer> recorded = FunctionalInterfaceExamples.captureRuns(recorder, 3, 4);
        assertEquals(List.of(3, 4, 3, 4), recorded);
    }
}
