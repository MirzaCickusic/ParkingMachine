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
        String sqlQuery = "select * from tickets";

        try {
            Connection connection = DbConection.getConnection();
            PreparedStatement statement = connection.prepareCall(sqlQuery, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                StringBuffer sb = new StringBuffer();

                int ID = resultSet.getObject("ID", Integer.class);
                String ticketCreatedTime = resultSet.getObject("timeCreated", String.class);
                double ticketPrice = resultSet.getObject("totalPrice", Double.class);

                sb.append("Ticket number " + ID + ". ");
                sb.append("Issued at time: " + ticketCreatedTime + " for amount of " + ticketPrice + "€");

                System.out.println(sb.toString());
            }


        } catch (SQLException e) {
            DbConection.sqlException(e);
        }
    }

    public static void printRecipe() {
        String sqlQuery = "select * from tickets where ID = ?";

        try {
            Connection connection = DbConection.getConnection();
            PreparedStatement statement = connection.prepareCall(sqlQuery, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            statement.setInt(1, (Integer) TicketObject.getID());

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                StringBuffer sb = new StringBuffer();

                String timeTicketIssued = resultSet.getObject("timeCreated", String.class);
                String timeTicketExpires = resultSet.getObject("timeExpired", String.class);
                String ticketLength = resultSet.getObject("totalLength", String.class);

                System.out.println("\n---------------------");
                sb.append("Ticket created at: " + timeTicketIssued + " Thank you for your purchase!");
                sb.append("\nTicket expires at: " + timeTicketExpires);
                sb.append("\nThat gives your " + ticketLength + " to use our parking!");
                sb.append(" We are watching you O_o ..");
                System.out.println("\n---------------------");

                System.out.println(sb.toString());
            }


        } catch (SQLException e) {
            DbConection.sqlException(e);
        }
    }
}
