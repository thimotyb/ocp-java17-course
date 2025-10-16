package ch07.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class EncapsulationExamples {

    private EncapsulationExamples() {
    }

    public static final class ZooInventory {

        private final List<String> animals = new ArrayList<>();

        public void addAnimal(String name) {
            animals.add(name);
        }

        public List<String> getAnimals() {
            return Collections.unmodifiableList(animals);
        }
    }
}
