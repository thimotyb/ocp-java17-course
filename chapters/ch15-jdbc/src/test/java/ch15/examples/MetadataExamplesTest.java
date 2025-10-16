package ch15.examples;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MetadataExamplesTest {

    private Connection connection;

    @BeforeEach
    void setup() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite::memory:");
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("CREATE TABLE mammals (id INTEGER PRIMARY KEY, name TEXT NOT NULL)");
        }
    }

    @AfterEach
    void cleanup() throws SQLException {
        connection.close();
    }

    @Test
    void listTablesAndCheckTransactions() throws SQLException {
        List<String> tables = MetadataExamples.listTables(connection, null);
        assertTrue(tables.stream().map(String::toLowerCase).anyMatch(name -> name.contains("mammals")));
        MetadataExamples.supportsTransactions(connection);
    }
}
