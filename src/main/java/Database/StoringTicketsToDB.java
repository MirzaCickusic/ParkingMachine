package Database;

import Controler.CoinReceivingMechanism;
import Model.TicketObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoringTicketsToDB {

    private static String sqlQuery = "insert into tickets(timeCreated, totalPrice, hourlyRate, dayleRate) values (?, " +
            "?, ?, ?)";

    public static boolean addCustomer() {
        double totalPriceOfTicket = CoinReceivingMechanism.getTotal();

        try {
            Connection connection = DbConection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            statement.setString(1, TicketObject.getDateAndTimeTicketCreated());
            statement.setDouble(2, totalPriceOfTicket);
            statement.setDouble(3, GetParkingPricingInDB.getHourlyPrice());
            statement.setDouble(4, GetParkingPricingInDB.getDaylePrice());

            int affected = statement.executeUpdate();
            if (affected == 1) {
                System.out.println("\n---------------------");

                GetLastAddedUser.setUserID();
                TicketObject.setMoneyUserEntered(totalPriceOfTicket);

                connection.close();
                statement.close();
                return true;
            }

        } catch (SQLException e) {
            DbConection.sqlException(e);
        }

        return false;
    }


    public static void addTimeTicketLastsAndWhenItExpiresToDB(String timeTicketLasts, String dateAndTimeTicketExpires) {
        String sqlQuery = "insert into recipe(ID, totalLength, timeExpired) values (?, " +
                "?, ?)";

        try {
            Connection connection = DbConection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            statement.setInt(1, TicketObject.getID());
            statement.setString(2, timeTicketLasts);
            statement.setString(3, dateAndTimeTicketExpires);

            int affected = statement.executeUpdate();
            if (affected == 1) {
                connection.close();
                statement.close();
            }

        } catch (SQLException e) {
            DbConection.sqlException(e);
        }

    }
}
