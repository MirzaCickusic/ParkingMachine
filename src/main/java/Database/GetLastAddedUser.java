package Database;

import Controler.CoinReceivingMechanism;
import Controler.SetParkingPricing;
import Model.TicketObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetLastAddedUser {

    public static boolean getUserID() {
        String sqlQuery = "SELECT ID FROM tickets ORDER BY id DESC LIMIT 1";

        try {
            Connection connection = DbConection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            ResultSet rs =statement.executeQuery();

            if (rs.next()) {

                TicketObject.setID(rs.getInt("ID"));

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
