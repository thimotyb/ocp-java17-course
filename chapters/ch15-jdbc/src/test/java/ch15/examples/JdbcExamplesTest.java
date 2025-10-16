package ch15.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JdbcExamplesTest {

    private Connection connection;

    @BeforeEach
    void setup() throws Exception {
        connection = DriverManager.getConnection("jdbc:sqlite::memory:");
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("CREATE TABLE animal (id INTEGER PRIMARY KEY, name TEXT NOT NULL)");
        }
    }

    @AfterEach
    void cleanup() throws Exception {
        connection.close();
    }

    @Test
    void insertAndQueryAnimals() throws Exception {
        JdbcExamples.insertAnimal(connection, new JdbcExamples.ZooAnimal(1, "lion"));
        JdbcExamples.insertAnimal(connection, new JdbcExamples.ZooAnimal(2, "tiger"));
        List<JdbcExamples.ZooAnimal> animals = JdbcExamples.queryAnimals(connection);
        assertEquals(2, animals.size());
        assertEquals("lion", animals.get(0).getName());
    }

    @Test
    void connectionFailsWithInvalidUrl() {
        assertThrows(Exception.class, () -> JdbcExamples.connect("jdbc:invalid:url"));
    }
}
