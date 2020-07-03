package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetParkingPricingInDB {

    public static double getHourlyPrice() {

        String sqlQuery = "select hourlyRate from price";

        try {
            Connection connection = DbConection.getConnection();
            PreparedStatement statement = connection.prepareCall(sqlQuery);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                double hourlyPriceFromDB = resultSet.getDouble(1);
                return hourlyPriceFromDB;
            }
        } catch (SQLException e) {
            DbConection.sqlException(e);
        }
        return 0;
    }


    public static double getDaylePrice() {

        String sqlQuery = "select dayleRate from price";

        try {
            Connection connection = DbConection.getConnection();
            PreparedStatement statement = connection.prepareCall(sqlQuery);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                double daylePriceFromDB = resultSet.getDouble(2);
                return daylePriceFromDB;
            }
        } catch (SQLException e) {
            DbConection.sqlException(e);
        }
        return 0;
    }
}
