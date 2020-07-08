package Database;

import Model.TicketObject;

import java.sql.*;

public class GettingTicketsFromDB {

    public static int getNumberOfTicketsIssued() {

        String sqlQuery = "SELECT COUNT(*) FROM tickets";

        try {
            Connection connection = DbConection.getConnection();
            CallableStatement statement = connection.prepareCall(sqlQuery);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                int count = resultSet.getObject(1, Integer.class);
                return count;
            }

        } catch (SQLException e) {
            DbConection.sqlException(e);
        }
        return -1;
    }

    public static void printAllTicketIssued() {
        String sqlQuery = "SELECT tickets.id, tickets.timeCreated, tickets.totalPrice, recipe.timeExpired\n" +
                "FROM recipe\n" +
                "INNER JOIN tickets ON recipe.id=tickets.id;";

        try {
            Connection connection = DbConection.getConnection();
            PreparedStatement statement = connection.prepareCall(sqlQuery, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            ResultSet resultSet = statement.executeQuery();

            System.out.println("\n");

            while (resultSet.next()) {
                StringBuffer sb = new StringBuffer();

                int ID = resultSet.getObject("ID", Integer.class);
                String ticketCreatedTime = resultSet.getObject("timeCreated", String.class);
                double ticketPrice = resultSet.getObject("totalPrice", Double.class);
                String dateAndTimeTicketExpires = resultSet.getObject("timeExpired", String.class);

                sb.append("Ticket number " + ID + ". ");
                sb.append("Issued at time: " + ticketCreatedTime + " for amount of " + ticketPrice + "€");
                sb.append(" Ticket will expire at: " + dateAndTimeTicketExpires);

                System.out.println(sb.toString());
            }


        } catch (SQLException e) {
            DbConection.sqlException(e);
        }
    }


    public static void printRecipe(String timeTicketLasts, String dateAndTimeTicketExpires) {

        String sqlQuery = "select * from tickets where ID = ?";

        try {
            Connection connection = DbConection.getConnection();
            PreparedStatement statement = connection.prepareCall(sqlQuery, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            statement.setInt(1, TicketObject.getID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                StringBuffer sb = new StringBuffer();

                String timeTicketIssued = resultSet.getObject("timeCreated", String.class);
                double change = resultSet.getObject("money_change", Integer.class);


                sb.append("\nTicket created at: " + timeTicketIssued + " Thank you for your purchase!");
                sb.append("\nTicket expires at: " + dateAndTimeTicketExpires);
                sb.append("\nThat gives your " + timeTicketLasts + " to use our parking!");
                sb.append("\nYour change (kusur) is " + change + "€");
                sb.append("\n\nWe are watching you O_o ..\n");

                System.out.println(sb.toString());

            }


        } catch (SQLException e) {
            DbConection.sqlException(e);
        }

    }
}
