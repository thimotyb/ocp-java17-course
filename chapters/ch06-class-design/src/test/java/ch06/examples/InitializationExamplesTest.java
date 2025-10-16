package ch06.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class InitializationExamplesTest {

    @Test
    @Order(1)
    void hippoSequenceMatchesStaticInitializationOrder() {
        InitializationExamples.clearOutput();
        assertEquals(List.of("A", "B", "C"), InitializationExamples.hippoSequence());
    }

    @Test
    @Order(2)
    void mouseHouseAssignsFinalFieldsOnce() {
        var defaultHouse = new InitializationExamples.MouseHouse();
        var themedHouse = new InitializationExamples.MouseHouse("Treehouse");
        assertEquals(10, defaultHouse.getVolume());
        assertEquals(null, defaultHouse.getType());
        assertEquals("Treehouse", themedHouse.getType());
    }

    @Test
    @Order(3)
    void zooTicketsInitializationRunsStaticsBeforeConstructor() {
        InitializationExamples.clearOutput();
        InitializationExamples.ZooTickets.generate();
        List<String> output = InitializationExamples.getOutput();
        assertEquals("BestZoo-", output.get(output.size() - 2));
        assertEquals("z-", output.get(output.size() - 1));
        if (output.size() == 4) {
            assertEquals(List.of("0-", "10-", "BestZoo-", "z-"), output);
        }
    }

    @Test
    @Order(4)
    void chimpanzeeCallsParentConstructorsFirst() {
        InitializationExamples.clearOutput();
        new InitializationExamples.Chimpanzee();
        assertEquals(List.of("Primate-", "Ape1-", "Chimpanzee-"), InitializationExamples.getOutput());
    }

    @Test
    @Order(5)
    void cuttlefishShowsMixedStaticAndInstanceOrder() {
        InitializationExamples.clearOutput();
        new InitializationExamples.Cuttlefish();
        assertEquals(List.of("0", "swimmy", "1", "Constructor"), InitializationExamples.getOutput());
    }

    @Test
    @Order(6)
    void okapiFollowsComplexConstructorFlow() {
        InitializationExamples.clearOutput();
        new InitializationExamples.Okapi(1);
        assertEquals(List.of("A", "F", "B", "E", "C", "H", "G"), InitializationExamples.getOutput());
        InitializationExamples.clearOutput();
        new InitializationExamples.Okapi(2);
        assertEquals(List.of("B", "E", "C", "H", "G"), InitializationExamples.getOutput());
    }
}
