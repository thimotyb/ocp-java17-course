package ch15.examples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Illustrates the transaction workflow described in Chapter 15 "Managing Transactions"—disabling
 * auto-commit, executing multiple statements, committing, and rolling back on failure.
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c15.xhtml">OCP Java SE 17 Study Guide – Chapter 15: Managing Transactions</a>
 */
public final class TransactionExamples {

    private TransactionExamples() {
    }

    /**
     * Performs a transfer between two rows, ensuring rollback on error and restoring the previous
     * auto-commit state.
     */
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
