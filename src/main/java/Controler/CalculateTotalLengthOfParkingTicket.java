package Controler;

import Database.DbConection;
import Database.GettingTicketsFromDB;
import Database.StoringTicketsToDB;
import Model.TicketObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class CalculateTotalLengthOfParkingTicket {

    public static boolean setTicketHourly_or_Dayle_andPrintResult() {

        if (GetStatusIsFullDayTicketFromDB()) {
            TicketObject.setTicketToDayleTicket();
            StoringTicketsToDB.addTimeTicketLastsAndWhenItExpiresToDB("24:00:00", TicketObject.getDateAndTimeTicketExpires());
            GettingTicketsFromDB.printRecipe("24:00:00", TicketObject.getDateAndTimeTicketExpires());
            return true;
        } else if (!GetStatusIsFullDayTicketFromDB()) {
            getingTimeAndDateTicketLastsAndExpires();
            return true;
        } else {
            System.out.println("\nSOMETHING WENT WRONG. PLEASE RESTART THE PROGRAM!");
            return false;
        }

    }

    private static boolean GetStatusIsFullDayTicketFromDB() {
        String sqlQuery = "select dayleTicketActive from tickets where id = ?";

        try {
            Connection connection = DbConection.getConnection();
            PreparedStatement statement = connection.prepareCall(sqlQuery, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            statement.setInt(1, TicketObject.getID());

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                boolean isActive = resultSet.getBoolean("dayleTicketActive");

                if (isActive) {
                    return true;
                }

            }

        } catch (SQLException e) {
            DbConection.sqlException(e);
        }

        return false;
    }

    public static void getingTimeAndDateTicketLastsAndExpires() {
        String sqlQuery = "select decimalTime from tickets where ID = ?";

        try {
            Connection connection = DbConection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, TicketObject.getID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                double decimalTimeTicketLasts = resultSet.getObject(1, Double.class);

                AddingTimeToTicket.convertDecimalNumToTime(decimalTimeTicketLasts, TicketObject.getDateAndTimeTicketCreated());

                StoringTicketsToDB.addTimeTicketLastsAndWhenItExpiresToDB(AddingTimeToTicket.getTimeTicketLasts(),
                        AddingTimeToTicket.getDateAndTimeTicketExpires());

                GettingTicketsFromDB.printRecipe(AddingTimeToTicket.getTimeTicketLasts(), AddingTimeToTicket.getDateAndTimeTicketExpires());

            }

        } catch (SQLException e) {
            DbConection.sqlException(e);
        } catch (ParseException p) {
            System.err.println(p);
        }
    }
}
