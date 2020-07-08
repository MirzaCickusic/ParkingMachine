package Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TicketObject {

    private static int ID;
    private static String dateAndTimeTicketCreated;
    private static String dateAndTimeTicketExpires;
    private static double moneyUserEntered;


    public static String getDateAndTimeTicketExpires() {
        return dateAndTimeTicketExpires;
    }

    public static void setDateAndTimeTicketExpires(String dateAndTicket) {
        dateAndTimeTicketExpires = dateAndTicket;
    }

    public static String getDateAndTimeTicketCreated() {
        return dateAndTimeTicketCreated;
    }

    public static void setDateAndTimeTicketCreated(String dateAndTime) {
        dateAndTimeTicketCreated = dateAndTime;
    }


    public static void setTicketToDayleTicket() {
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.now().plusDays(1);
        String dayleTicketEndTimeAndDate = FOMATTER.format(date);
        setDateAndTimeTicketExpires(dayleTicketEndTimeAndDate);

    }


    public static int getID() {
        return ID;
    }

    public static void setID(int newID) {
        ID = newID;
    }


    public static double getMoneyUserEntered() {
        return moneyUserEntered;
    }

    public static void setMoneyUserEntered(double moneyUserEntered) {
        TicketObject.moneyUserEntered = moneyUserEntered;
    }
}
