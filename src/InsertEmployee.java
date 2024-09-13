//This operation inserts a new record into the database.

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertEmployee {

    private static final String INSERT_EMPLOYEES_SQL = "INSERT INTO employees (name, email, country, salary) VALUES (?, ?, ?, ?);";

    public  void insertRecord(String name, String email, String country, double salary) throws SQLException {
            // connection database from class while creat this
        try(Connection connection =JDBCUtils.getConnection();
            // Creating a statement using connection object
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEES_SQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, country);
            preparedStatement.setDouble(4, salary);
            // Executing the query
            preparedStatement.executeUpdate();

        }catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
    }
}
