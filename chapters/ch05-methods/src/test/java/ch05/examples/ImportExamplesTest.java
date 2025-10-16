package ch05.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class ImportExamplesTest {

    @Test
    void importsCreateLists() {
        List<String> list = new ImportExamples.Imports().createList();
        assertEquals(List.of("one", "two"), list);
    }

    @Test
    void zooParkingUsesStaticImportStyle() {
        List<String> list = new ImportExamples.ZooParking().createList();
        assertEquals(List.of("one", "two"), list);
    }
}
