package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TicketObject {

    private static int ID;
    private static String dateAndTimeTicketCreated;
    private static String dateAndTimeTicketExpires;


    public static String getDateAndTimeTicketExpires() {
        return dateAndTimeTicketExpires;
    }

    public static void setDateAndTimeTicketExpires(String jo) {
        dateAndTimeTicketExpires = jo;
    }

    public static String getDateAndTimeTicketCreated() {
        return dateAndTimeTicketCreated;
    }

    public static void setDateAndTimeTicketCreated(String date) {
        dateAndTimeTicketCreated = date;
    }


    public static void setTicketToDayleTicket() {
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.now().plusDays(1);
        String dayleTicketEndTimeAndDate = FOMATTER.format(date);
        setDateAndTimeTicketExpires(dayleTicketEndTimeAndDate);

    }

    public static String setParkingForOneHour() {
        return dateFormatter(1);
    }

    public static String setParkingForTwoHour() {
        return dateFormatter(2);

    }

    public static String setParkingForFourHour() {
       return dateFormatter(4);

    }

    public static Object getID() {
        return ID;
    }

    public static void setID(int newID) {
        ID = newID;
    }

    static String dateFormatter(int hoursToBeAddedToTicketLength) {

        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.now().plusHours(hoursToBeAddedToTicketLength);
        String dayleTicketEndTimeAndDate = FOMATTER.format(date);

        setDateAndTimeTicketExpires(dayleTicketEndTimeAndDate);

        return dayleTicketEndTimeAndDate;
    }
}
