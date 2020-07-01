package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConection {

    private static String url = "jdbc:mysql://localhost:3306/ParkingMachine";
    private static String root = "root";
    private static String password = "pasvord";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, root, password);
    }

    public static void sqlException(SQLException e) {
        System.out.println("Error message " + e.getMessage());
        System.out.println("Error code " + e.getErrorCode());
        System.out.println("SQL state " + e.getSQLState());
    }
}
