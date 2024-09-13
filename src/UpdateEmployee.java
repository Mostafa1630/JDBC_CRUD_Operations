import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//This operation updates existing records in the database.
public class UpdateEmployee {

    private static final String UPDATE_EMPLOYEES_SQL = "UPDATE employees SET name = ?, email = ?, country = ?, salary = ? WHERE id = ?;";

    public void updateRecord(int id, String name, String email, String country, double salary) throws SQLException {
        // Establishing a Connection
        try (Connection connection = JDBCUtils.getConnection();
             // Creating a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEES_SQL)) {
            // Setting parameters
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, country);
            preparedStatement.setDouble(4, salary);
            preparedStatement.setInt(5, id); // Updating record with the provided ID
            // Executing the query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
    }
}
