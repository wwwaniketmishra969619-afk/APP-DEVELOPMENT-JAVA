import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

    public static void main(String[] args) {

        // Database URL
        String url = "jdbc:mysql://localhost:3306/mydatabase";

        // Database credentials
        String username = "root";
        String password = "your_password";  // 🔴 Add your MySQL password here

        Connection connection = null;

        try {
            // Load MySQL JDBC Driver (optional for newer versions, but good practice)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            connection = DriverManager.getConnection(url, username, password);

            System.out.println("Connected to the database successfully!");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
            e.printStackTrace();

        } finally {
            // Close connection
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}