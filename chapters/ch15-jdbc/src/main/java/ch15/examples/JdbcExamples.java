package ch15.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates JDBC API snippets from Chapter 15.
 */
public final class JdbcExamples {

    private JdbcExamples() {
    }

    public static class ZooAnimal {

        private final int id;
        private final String name;

        public ZooAnimal(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static List<ZooAnimal> queryAnimals(Connection connection) throws SQLException {
        List<ZooAnimal> animals = new ArrayList<>();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery("SELECT id, name FROM animal ORDER BY id")) {
            while (rs.next()) {
                animals.add(new ZooAnimal(rs.getInt("id"), rs.getString("name")));
            }
        }
        return animals;
    }

    public static int insertAnimal(Connection connection, ZooAnimal animal) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO animal (id, name) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, animal.getId());
            ps.setString(2, animal.getName());
            int updated = ps.executeUpdate();
            return updated;
        }
    }

    public static Connection connect(String url) throws SQLException {
        return DriverManager.getConnection(url);
    }
}
