package ch15.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransactionExamplesTest {

    private Connection connection;

    @BeforeEach
    void setup() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite::memory:");
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate("CREATE TABLE tickets (id INTEGER PRIMARY KEY, count INTEGER NOT NULL)");
            stmt.executeUpdate("INSERT INTO tickets (id, count) VALUES (1, 10)");
            stmt.executeUpdate("INSERT INTO tickets (id, count) VALUES (2, 5)");
        }
    }

    @AfterEach
    void cleanup() throws SQLException {
        connection.close();
    }

    @Test
    void transferTicketsCommits() throws SQLException {
        TransactionExamples.transferTickets(connection, 1, 2, 3);
        try (Statement stmt = connection.createStatement(); var rs = stmt.executeQuery("SELECT count FROM tickets WHERE id=1")) {
            rs.next();
            assertEquals(7, rs.getInt(1));
        }
        try (Statement stmt = connection.createStatement(); var rs = stmt.executeQuery("SELECT count FROM tickets WHERE id=2")) {
            rs.next();
            assertEquals(8, rs.getInt(1));
        }
    }
}
