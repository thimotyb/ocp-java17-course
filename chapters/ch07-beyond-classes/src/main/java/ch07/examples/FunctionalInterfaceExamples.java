package ch07.examples;

import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
public interface FunctionalInterfaceExamples {

    void sprint(int speed);

    default String description() {
        return "Generic sprint";
    }

    static FunctionalInterfaceExamples fromList(List<Integer> speeds) {
        return speed -> speeds.add(speed);
    }

    static List<Integer> captureRuns(FunctionalInterfaceExamples runner, int... values) {
        List<Integer> recorded = java.util.Arrays.stream(values).boxed().collect(Collectors.toList());
        FunctionalInterfaceExamples combined = FunctionalInterfaceExamples.fromList(recorded);
        for (int value : values) {
            runner.sprint(value);
            combined.sprint(value);
        }
        return recorded;
    }
}
