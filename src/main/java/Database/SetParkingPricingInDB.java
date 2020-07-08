package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SetParkingPricingInDB {

    public static void initializeParkingPrices(double hourlyRate, double dayleRate) {
        String sqlQuery = "insert into price (hourlyRate, dayleRate) values (?, ?)";

        try {
            Connection connection = DbConection.getConnection();
            PreparedStatement statement = connection.prepareCall(sqlQuery);
            statement.setDouble(1, hourlyRate);
            statement.setDouble(2, dayleRate);

            int affected = statement.executeUpdate();
            if (affected == 1) {
            }
        } catch (SQLException e) {
            DbConection.sqlException(e);
        }
    }

    public static boolean setHourlyPrice(double pricePerHour) {

        String sqlQuery = "update price set hourlyRate = ? where hourlyRate = ?";

        try {
            Connection connection = DbConection.getConnection();
            PreparedStatement statement = connection.prepareCall(sqlQuery);
            statement.setDouble(1, pricePerHour);
            statement.setDouble(2, GetParkingPricingInDB.getHourlyPrice());

            int affected = statement.executeUpdate();
            if (affected == 1) {
                return true;
            }
        } catch (SQLException e) {
            DbConection.sqlException(e);
        }
        return false;
    }

    public static boolean setDaylePrice(double pricePerDay) {

        String sqlQuery = "update price set dayleRate = ? where dayleRate = ?";

        try {
            Connection connection = DbConection.getConnection();
            PreparedStatement statement = connection.prepareCall(sqlQuery);
            statement.setDouble(1, pricePerDay);
            statement.setDouble(2, GetParkingPricingInDB.getDaylePrice());

            int affected = statement.executeUpdate();

            if (affected == 1) {
                return true;
            }
        } catch (SQLException e) {
            DbConection.sqlException(e);
        }
        return false;
    }

    public static void updateHourlyPricing(double pricePerHour) {

        String sqlQuery = "select * from tickets";

        try {
            Connection connection = DbConection.getConnection();
            PreparedStatement statement = connection.prepareCall(sqlQuery);
            ResultSet resultSet = statement.executeQuery();

            setHourlyPrice(pricePerHour);

            while (resultSet.next()) {
                int ID = resultSet.getObject("ID", Integer.class);

                updateHourlyPriceOnAllRowsByID(ID, pricePerHour);
            }
        } catch (SQLException e) {
            DbConection.sqlException(e);
        }
    }

    private static void updateHourlyPriceOnAllRowsByID(int ID, double pricePerHour) {
        String sqlQuery = "update tickets set hourlyRate = ? where id = ?";

        try {
            Connection connection = DbConection.getConnection();
            PreparedStatement statement = connection.prepareCall(sqlQuery);
            statement.setDouble(1, pricePerHour);
            statement.setInt(2, ID);

            int affected = statement.executeUpdate();
            if (affected == 1) {
            }
        } catch (SQLException e) {
            DbConection.sqlException(e);
        }
    }

    public static void updateDaylePricing(double daylePrice) {

        String sqlQuery = "select * from tickets";

        try {
            Connection connection = DbConection.getConnection();
            PreparedStatement statement = connection.prepareCall(sqlQuery);
            ResultSet resultSet = statement.executeQuery();

            setDaylePrice(daylePrice);

            while (resultSet.next()) {
                int ID = resultSet.getObject("ID", Integer.class);

                updateDaylePriceOnAllRowsByID(ID, daylePrice);
            }
        } catch (SQLException e) {
            DbConection.sqlException(e);
        }
    }

    private static void updateDaylePriceOnAllRowsByID(int ID, double daylePrice) {
        String sqlQuery = "update tickets set dayleRate = ? where id = ?";

        try {
            Connection connection = DbConection.getConnection();
            PreparedStatement statement = connection.prepareCall(sqlQuery);
            statement.setDouble(1, daylePrice);
            statement.setInt(2, ID);

            int affected = statement.executeUpdate();
            if (affected == 1) {
            }
        } catch (SQLException e) {
            DbConection.sqlException(e);
        }
    }


//    public static boolean changeWhenTicketExpiresForAllTickets(double pricePerHour) {
//
//        String sqlQuery = "select * from recipe";
//        String sql = "select decimalTime from tickets where ID = ?";
//        String sql3 = "update recipe set totalLength = ? where ID = ?";
//        String sql4 = "select timeCreated from tickets where ID = ?";
//        String sql5 = "update recipe set timeExpired = ? where ID = ?";
//
//
//
//        try {
//            Connection connection = DbConection.getConnection();
//            PreparedStatement statement = connection.prepareCall(sqlQuery);
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                int ID = resultSet.getObject(1, Integer.class);
//
//                PreparedStatement statement1 = connection.prepareCall(sql);
//                statement.setInt(1, ID);
//                ResultSet resultSet1 = statement1.executeQuery();
//                while (resultSet1.next()) {
//                    double decimalTime = resultSet.getObject(1, Double.class);
//                    String timeFromDecimal = AddingTimeToTicket.convertDecimal(decimalTime);
//                    PreparedStatement statement2 = connection.prepareCall(sql3);
//                    statement2.setString(1, timeFromDecimal);
//                    statement2.setInt(2, ID);
//                    statement.executeQuery();
//
//                    PreparedStatement statement3 = connection.prepareCall(sql4);
//                    statement3.setInt(1, ID);
//                    ResultSet resultSet2 = statement3.executeQuery();
//
//                    while (resultSet2.next()) {
//                        String timeCreated = resultSet2.getObject(1, String.class);
//                        AddingTimeToTicket.convertDecimalNumToTime(decimalTime, timeCreated);
//
//                        String newTicketExpTime = AddingTimeToTicket.getDateAndTimeTicketExpires();
//                        PreparedStatement statement4 = connection.prepareCall(sql5);
//                        statement4.setString(1, newTicketExpTime);
//                        statement4.setInt(2, ID);
//                        statement4.executeQuery();
//                    }
//                }
//
//            }
//
//        } catch (SQLException e) {
//            DbConection.sqlException(e);
//        } catch (ParseException parseException) {
//            System.out.println(parseException);
//        }
//        return false;
//    }

}
