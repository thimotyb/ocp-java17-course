package ch10.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;

class StreamPipelineExamplesTest {

    @Test
    void mapFilterSortedPipelineWorks() {
        assertEquals(List.of("bear", "lion"), StreamPipelineExamples.mapAndFilter(List.of(" lion ", "fox", "bear")));
    }

    @Test
    void findFirstMatchesPrefix() {
        Optional<String> result = StreamPipelineExamples.findFirstStartingWith(List.of("zebra", "lion", "lemur"), "le");
        assertEquals(Optional.of("lemur"), result);
    }

    @Test
    void iterateGeneratesLimitedEvenNumbers() {
        assertEquals(List.of(0, 2, 4, 6, 8), StreamPipelineExamples.createInfiniteEvenNumbers(5));
    }

    @Test
    void primitiveStreamBoxedSquaresNumbers() {
        assertEquals(List.of(1, 4, 9, 16, 25), StreamPipelineExamples.primitiveStreamBoxed());
    }

    @Test
    void groupingAndPartitioning() {
        Map<Integer, List<String>> grouped = StreamPipelineExamples.groupingByLength(List.of("ant", "bear", "cougar"));
        assertEquals(List.of("ant"), grouped.get(3));
        Map<Boolean, List<String>> partitioned = StreamPipelineExamples.partitionByLength(List.of("ant", "bear", "cougar"));
        assertEquals(List.of("bear", "cougar"), partitioned.get(true));
    }

    @Test
    void joiningAndToMap() {
        assertEquals("[ant, bear, cougar]", StreamPipelineExamples.joiningNames(List.of("ant", "bear", "cougar")));
        Map<Integer, String> map = StreamPipelineExamples.toMapWithMerge(List.of("cat", "dog", "emu"));
        assertEquals("cat/dog/emu", map.get(3));
    }

    @Test
    void reduceOptionalConcatenatesValues() {
        assertEquals(Optional.of("lion-tiger-bear"), StreamPipelineExamples.reduceConcatenate(List.of("lion", "tiger", "bear")));
    }

    @Test
    void distinctSortedLimitCollectToSet() {
        Set<String> set = StreamPipelineExamples.sortedDistinctCapped(List.of("zebra", "ant", "zebra", "bear"), 2);
        assertTrue(set.contains("ant"));
        assertTrue(set.contains("bear"));
    }
}
