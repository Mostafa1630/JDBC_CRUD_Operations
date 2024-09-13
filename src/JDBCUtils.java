import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {

    // Database URL, with the database name and SSL option disabled
    private static final String URL = "jdbc:mysql://localhost:3306/test_db?useSSL=false";

    // Username for connecting to the database
    private static final String USER = "root";

    // Password for the database user
    private static final String PASSWORD = "";

    // Method to establish a connection to the database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Method to print details of SQLException when an error occurs
    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                // Prints the stack trace of the exception
                e.printStackTrace(System.err);

                // Prints SQLState, which provides information about the error
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());

                // Prints the specific error code for the SQL error
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());

                // Prints the detailed message of the SQL error
                System.err.println("Message: " + e.getMessage());

                // Loop to print the cause of the exception, if there is one
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

