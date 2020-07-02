package Database;

import Controler.CalculateTotalLenghtOfParkingTicket;
import Controler.CoinReceivingMechanism;
import Controler.SetParkingPricing;
import Model.TicketObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoringTicketsToDB {

    private static String sqlQuery = "insert into tickets(timeCreated, totalPrice, hourlyRate, dayleTicket, " +
            "totalLength, timeExpired) values (?, ?, ?, ?, ?, ?)";



    public static boolean addCustomer() {
        String totalPriceOfTicket = CoinReceivingMechanism.getTotal();
        String timeTicketExpires = CalculateTotalLenghtOfParkingTicket.calculateTimeTicketLasts(totalPriceOfTicket);
        String totalLengthOfTicket = CalculateTotalLenghtOfParkingTicket.getTimeTicketLasts();

        try {
            Connection connection = DbConection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            statement.setString(1, TicketObject.getDateAndTimeTicketCreated());
            statement.setString(2, totalPriceOfTicket);
            statement.setString(3, SetParkingPricing.setHourlyRate(1));
            statement.setString(4,
                    SetParkingPricing.setDaylePrice(CoinReceivingMechanism.getTotal()));
            statement.setString(5, totalLengthOfTicket);
            statement.setString(6, timeTicketExpires);

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
