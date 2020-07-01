package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoringTicketsToDB {

    private static String sqlQuery = "call addCustomer(?,?)";

    public boolean addCustomer(String timeExpired, String ticketPrice) {
        try {
            Connection connection = DbConection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            statement.setString(1, timeExpired);
            statement.setString(2, ticketPrice);

            int affected = statement.executeUpdate();
            if (affected == 1) {
                System.out.println("Ticked stored successfully!");
                connection.close();
                statement.close();
                return true;
            }

        } catch (SQLException e) {
            DbConection.sqlException(e);
        }

        return false;
    }
}
