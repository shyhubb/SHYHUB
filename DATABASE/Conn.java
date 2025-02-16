package DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    private static final String dbname = "jdbc:mysql://localhost:3306/bank";
    private static final String admin = "root";
    private static final String pass = "";

    public static Connection new_Connection() {
        try {
            // Manually load the MySQL JDBC driver (for older versions of Java)
            Class.forName("com.mysql.cj.jdbc.Driver"); // Explicitly load the driver
            return DriverManager.getConnection(dbname, admin, pass);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: Failed to connect to the server");
            e.printStackTrace();  // Print the stack trace to know more about the error
        }
        return null;
    }

    public static void close_Connection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error: Failed to close connection");
                e.printStackTrace();  // Log the exception for debugging
            }
        }
    }
}