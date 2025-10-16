package ch14.examples;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Demonstrates basic serialization.
 */
public final class SerializationExamples {

    private SerializationExamples() {
    }

    public record Animal(String name, int age) implements Serializable {
    }

    public static byte[] serialize(Animal animal) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream(); ObjectOutputStream out = new ObjectOutputStream(baos)) {
            out.writeObject(animal);
            return baos.toByteArray();
        }
    }

    public static Animal deserialize(byte[] data) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data); ObjectInputStream in = new ObjectInputStream(bais)) {
            return (Animal) in.readObject();
        }
    }
}
