package ch14.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class SerializationExamplesTest {

    @Test
    void serializeAndDeserializeRecord() throws IOException, ClassNotFoundException {
        var animal = new SerializationExamples.Animal("lion", 5);
        byte[] bytes = SerializationExamples.serialize(animal);
        var restored = SerializationExamples.deserialize(bytes);
        assertEquals(animal, restored);
    }
}
