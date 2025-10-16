package ch05.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class StaticExamplesTest {

    @Test
    void staticFieldsAreSharedAcrossInstances() {
        var penguin1 = new StaticExamples.Penguin();
        var penguin2 = new StaticExamples.Penguin();
        penguin1.setName("Lilly");
        StaticExamples.Penguin.setNameOfTallestPenguin("Lilly");
        penguin2.setName("Willy");
        StaticExamples.Penguin.setNameOfTallestPenguin("Willy");
        assertEquals("Willy", StaticExamples.Penguin.getNameOfTallestPenguin());
        assertEquals("Lilly", penguin1.getName());
        assertEquals("Willy", penguin2.getName());
    }

    @Test
    void staticVariableAccessViaNullReferenceStillWorks() {
        StaticExamples.Snake.hiss = 4;
        StaticExamples.Snake snake = new StaticExamples.Snake();
        snake = null;
        assertEquals(4, StaticExamples.Snake.hiss);
        StaticExamples.Snake.hiss = 5;
        assertEquals(5, StaticExamples.Snake.hiss);
    }

    @Test
    void staticMethodRequiresInstanceForInstanceMembers() {
        var ray = new StaticExamples.MantaRay();
        StaticExamples.MantaRay.callThird(ray);
        assertThrows(IllegalStateException.class, () -> {
            var problemRay = new StaticExamples.MantaRay();
            try {
                var field = StaticExamples.MantaRay.class.getDeclaredField("name");
                field.setAccessible(true);
                field.set(problemRay, null);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException(e);
            }
            StaticExamples.MantaRay.callThird(problemRay);
        });
    }

    @Test
    void counterTracksInstances() {
        new StaticExamples.Counter();
        new StaticExamples.Counter();
        assertEquals(2, StaticExamples.Counter.getCount());
    }

    @Test
    void zooInventoryAllowsMutationOfArrayContents() {
        StaticExamples.ZooInventoryManager.setTreat(0, "popcorn");
        assertEquals("popcorn", StaticExamples.ZooInventoryManager.treats().get(0));
    }

    @Test
    void timeConstantsComputeSecondsPerHour() {
        assertEquals(3600, StaticExamples.TimeConstants.secondsPerHour());
    }
}
