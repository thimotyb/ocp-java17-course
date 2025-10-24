package ch14.examples;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Demonstrates the serialization mechanisms detailed in Chapter 14 "Serializing Data".
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c14.xhtml">OCP Java SE 17 Study Guide – Chapter 14: Serializing Data</a>
 */
public final class SerializationExamples {

    private SerializationExamples() {
    }

    /** Serializable record representing the data transfer object used in the text. */
    public record Animal(String name, int age) implements Serializable {
    }

    /** Writes an {@link Animal} to a byte array via {@link ObjectOutputStream}. */
    public static byte[] serialize(Animal animal) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream(); ObjectOutputStream out = new ObjectOutputStream(baos)) {
            out.writeObject(animal);
            return baos.toByteArray();
        }
    }

    /** Reads an {@link Animal} instance back via {@link ObjectInputStream}. */
    public static Animal deserialize(byte[] data) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data); ObjectInputStream in = new ObjectInputStream(bais)) {
            return (Animal) in.readObject();
        }
    }
}
