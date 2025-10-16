# Chapter 15 – JDBC

## Learning Objectives
- Establish database connections using JDBC drivers and `DriverManager`.
- Execute queries and updates with `Statement` and `PreparedStatement`, processing results via `ResultSet`.
- Manage transactions (`commit`, `rollback`, savepoints) and control auto-commit behaviour.
- Use `DatabaseMetaData` and `ResultSetMetaData` for schema inspection.

## Chapter Summary
### JDBC Fundamentals
- Load drivers (auto-registration in JDBC 4+) and obtain connections via `DriverManager.getConnection`.
- Use `Statement` for simple SQL and `PreparedStatement` for parameterized queries to prevent SQL injection.
- Retrieve results with `ResultSet.next`, `getXxx`, `updateXxx`, and `close` resources promptly (try-with-resources).

### Transactions
- Auto-commit mode commits each statement automatically; disable with `setAutoCommit(false)` for manual control.
- Use `commit` to persist changes, `rollback` to undo, and savepoints for partial rollbacks.

### Metadata and Utilities
- `DatabaseMetaData` exposes features: table lists, supported SQL features, transaction capabilities.
- `ResultSetMetaData` provides column names, types, and precision information.

## Practical Exercises
1. **Savepoints** – Extend transaction logic to use savepoints and test partial rollbacks.
2. **Batch Updates** – Add examples using `PreparedStatement.addBatch()` and `executeBatch()`.
3. **Resource Cleanup** – Implement custom utility methods using try-with-resources for DB operations.
4. **Column Metadata** – Use `ResultSetMetaData` to programmatically print columns and types.
5. **Connection Pooling** – Experiment with a simple connection pool or `DataSource` implementation.

## Run the Examples
```bash
# Ensure Java 17 is active
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk use java 17.0.14-tem

# Compile the Chapter 15 module
mvn -pl chapters/ch15-jdbc compile

# Run the demo
java -cp chapters/ch15-jdbc/target/classes ch15.examples.Chapter15Demo

# Execute the tests
mvn -pl chapters/ch15-jdbc -Dtest='ch15.examples.*Test' test
```

## Exam Prep (1Z0-829 style)
1. Which interface extends `PreparedStatement` for retrieving generated keys?
   - A. `CallableStatement`
   - B. `ResultSet`
   - C. `Statement`
   - D. `DatabaseMetaData`
2. What happens when auto-commit is disabled and `commit()` is not called?
   - A. Changes are automatically committed
   - B. Changes are discarded on connection close
   - C. Changes are visible immediately
   - D. The driver throws an exception
3. Which method returns column values from `ResultSet`?
   - A. `getColumnCount()`
   - B. `getString(int)`
   - C. `getColumnType()`
   - D. `getTableName()`
4. What does `uses DatabaseMetaData.getTables()` return?
   - A. `ResultSet` with table metadata
   - B. `List<String>`
   - C. `Table` objects
   - D. `Map<String, Object>`
5. Which statement executes parameterized SQL?
   - A. `Statement`
   - B. `PreparedStatement`
   - C. `CallableStatement`
   - D. `ResultSet`

<details>
<summary>Answers</summary>
1: C  
2: B  
3: B  
4: A  
5: B  
</details>

## Next Steps
- Integrate JDBC with connection pools and transaction managers.
- Explore ORM frameworks (e.g., JPA) built upon JDBC fundamentals.
