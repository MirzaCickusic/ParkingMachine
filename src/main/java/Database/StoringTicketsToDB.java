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

    private static String totalPriceOfTicket = CoinReceivingMechanism.getTotal();
    private static String totalLengthOfTicket = CalculateTotalLenghtOfParkingTicket.getTimeTicketLasts();
    private static String timeTicketExpires = CalculateTotalLenghtOfParkingTicket.calculateTimeTicketLasts(totalPriceOfTicket);


    public static boolean addCustomer() {
        try {
            Connection connection = DbConection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlQuery);

            statement.setString(1, TicketObject.getDateAndTimeTicketCreated());
            statement.setString(2, totalPriceOfTicket);
            statement.setString(3, SetParkingPricing.setHourlyPrice(2));
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
