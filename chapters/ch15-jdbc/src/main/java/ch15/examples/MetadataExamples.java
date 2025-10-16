package ch15.examples;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates DatabaseMetaData usage.
 */
public final class MetadataExamples {

    private MetadataExamples() {
    }

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

    public static boolean supportsTransactions(Connection connection) throws SQLException {
        return connection.getMetaData().supportsTransactions();
    }
}
