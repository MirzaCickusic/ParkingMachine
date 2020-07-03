package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SetParkingPricingInDB {

    public static boolean setHourlyPrice(double pricePerHour) {

        String sqlQuery = "insert into price (hourlyRate) values (?)";

        try {
            Connection connection = DbConection.getConnection();
            PreparedStatement statement = connection.prepareCall(sqlQuery);
            statement.setDouble(1, pricePerHour);
            int affected = statement.executeUpdate();
            if (affected == 1) {
                System.out.println("Price per hour sated!");
                return true;
            }
        } catch (SQLException e) {
            DbConection.sqlException(e);
        }
        return false;
    }


    public static boolean setDaylePrice(double daylePrice) {

        String sqlQuery = "insert into price (dayleRate) values (?)";

        try {
            Connection connection = DbConection.getConnection();
            PreparedStatement statement = connection.prepareCall(sqlQuery);
            statement.setDouble(1, daylePrice);
            int affected = statement.executeUpdate();
            if (affected == 1) {
                System.out.println("Price per hour sated!");
                return true;
            }
        } catch (SQLException e) {
            DbConection.sqlException(e);
        }
        return false;
    }


}
