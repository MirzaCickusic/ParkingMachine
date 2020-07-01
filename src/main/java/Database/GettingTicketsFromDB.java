package Database;

import java.sql.*;

public class GettingTicketsFromDB {

    public static int getNumberOfTicketsIssued() {

        String sqlQuery = "call ticketCount(@count)";

        try {
            Connection connection = DbConection.getConnection();
            CallableStatement statement = connection.prepareCall(sqlQuery);

            statement.registerOutParameter(1, Types.INTEGER);
            statement.execute();

            int count = statement.getInt(1);

            return count;

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

            if (resultSet.next()) {
                StringBuffer sb = new StringBuffer();

                int ID = resultSet.getObject("ID", Integer.class);
                String ticketCreatedTime = resultSet.getObject("timeCreated", String.class);
                double ticketPrice = resultSet.getObject("ticketPrice", Double.class);

                sb.append("Ticket number " + ID + ". ");
                sb.append("Issued at time: " + ticketCreatedTime + " for amount of:" + ticketPrice);

                System.out.println(sb.toString());
            }


        } catch (SQLException e) {
            DbConection.sqlException(e);
        }
    }

}
