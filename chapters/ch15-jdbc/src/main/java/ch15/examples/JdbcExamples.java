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
 * Demonstrates core JDBC operations from Chapter 15 "Working with JDBC" including establishing
 * connections, executing queries, and using prepared statements.
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c15.xhtml">OCP Java SE 17 Study Guide – Chapter 15: Working with JDBC</a>
 */
public final class JdbcExamples {

    private JdbcExamples() {
    }

    /** Simple POJO representing a zoo animal row. */
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

    /**
     * Executes a plain {@link Statement} and maps rows to {@link ZooAnimal} objects.
     */
    public static List<ZooAnimal> queryAnimals(Connection connection) throws SQLException {
        List<ZooAnimal> animals = new ArrayList<>();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery("SELECT id, name FROM animal ORDER BY id")) {
            while (rs.next()) {
                animals.add(new ZooAnimal(rs.getInt("id"), rs.getString("name")));
            }
        }
        return animals;
    }

    /**
     * Inserts a record using a {@link PreparedStatement}, matching the chapter's parameterized
     * statement example.
     */
    public static int insertAnimal(Connection connection, ZooAnimal animal) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement("INSERT INTO animal (id, name) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, animal.getId());
            ps.setString(2, animal.getName());
            int updated = ps.executeUpdate();
            return updated;
        }
    }

    /** @return JDBC connection obtained via {@link DriverManager#getConnection(String)}. */
    public static Connection connect(String url) throws SQLException {
        return DriverManager.getConnection(url);
    }
}
