package ch15.examples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Illustrates transaction management.
 */
public final class TransactionExamples {

    private TransactionExamples() {
    }

    public static void transferTickets(Connection connection, int fromId, int toId, int amount) throws SQLException {
        boolean oldAutoCommit = connection.getAutoCommit();
        connection.setAutoCommit(false);
        try (PreparedStatement withdraw = connection.prepareStatement("UPDATE tickets SET count = count - ? WHERE id = ?"); PreparedStatement deposit = connection.prepareStatement("UPDATE tickets SET count = count + ? WHERE id = ?")) {
            withdraw.setInt(1, amount);
            withdraw.setInt(2, fromId);
            withdraw.executeUpdate();
            deposit.setInt(1, amount);
            deposit.setInt(2, toId);
            deposit.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw e;
        } finally {
            connection.setAutoCommit(oldAutoCommit);
        }
    }
}
