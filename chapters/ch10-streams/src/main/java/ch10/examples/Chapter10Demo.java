package ch10.examples;

import java.util.List;

public final class Chapter10Demo {

    private Chapter10Demo() {
    }

    public static void main(String[] args) {
        System.out.println("Average: " + OptionalExamples.average(List.of(90, 100)).orElse(-1.0));
        System.out.println("Filtered names: " + StreamPipelineExamples.mapAndFilter(List.of(" lion ", "fox", "bear")));
        System.out.println("Square numbers: " + StreamPipelineExamples.primitiveStreamBoxed());
        System.out.println("Grouping By Length: " + StreamPipelineExamples.groupingByLength(List.of("ant", "bear", "cougar")));
        System.out.println("Summary Stats: " + PrimitiveStreamExamples.summaryStats(1, 5));
    }
}
