import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//This operation deletes a record from the database.
public class DeleteEmployee {
    private static final String DELETE_EMPLOYEES_SQL = "DELETE FROM employees WHERE id = ?;";

    public void deleteRecord(int id) throws SQLException {
        // Establishing a Connection
        try (Connection connection = JDBCUtils.getConnection();
             // Creating a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEES_SQL)) {
            // Setting parameter
            preparedStatement.setInt(1, id); // Deleting record with the provided ID
            // Executing the query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
    }
}
