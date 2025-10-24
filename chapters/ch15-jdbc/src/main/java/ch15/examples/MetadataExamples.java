package ch15.examples;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Mirrors the Chapter 15 DatabaseMetaData examples for inspecting schema objects and driver
 * capabilities.
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c15.xhtml">OCP Java SE 17 Study Guide – Chapter 15: Working with JDBC</a>
 */
public final class MetadataExamples {

    private MetadataExamples() {
    }

    /**
     * Retrieves table names for the specified schema pattern using
     * {@link DatabaseMetaData#getTables(String, String, String, String[])}.
     */
    public static List<String> listTables(Connection connection, String schemaPattern) throws SQLException {
        List<String> tables = new ArrayList<>();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet rs = metaData.getTables(null, schemaPattern, "%", new String[] {"TABLE"})) {
            while (rs.next()) {
                tables.add(rs.getString("TABLE_NAME"));
            }
        }
        return tables;
    }

    /** @return whether the database reports transaction support. */
    public static boolean supportsTransactions(Connection connection) throws SQLException {
        return connection.getMetaData().supportsTransactions();
    }
}
