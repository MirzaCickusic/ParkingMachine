package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TicketObject {

    private static int ID;
    private static String dateAndTimeTicketCreated;
    private static String dateAndTimeTicketExpires;
    private static int totalTicketPrice;

    public static String getDateAndTimeTicketExpires() {
        return dateAndTimeTicketExpires;
    }

    public static void setDateAndTimeTicketExpires(String dateAndTimeTicketExpires) {
        TicketObject.dateAndTimeTicketExpires = dateAndTimeTicketExpires;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public static String getDateAndTimeTicketCreated() {
        return dateAndTimeTicketCreated;
    }

    public static void setDateAndTimeTicketCreated(String date) {
        dateAndTimeTicketCreated = date;
    }

    public int getTotalTicketPrice() {
        return totalTicketPrice;
    }

    public void setTotalTicketPrice(int totalTicketPrice) {
        this.totalTicketPrice = totalTicketPrice;
    }

    public static void setTicketToDayleTicket() {
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ");
        LocalDateTime date = LocalDateTime.now().plusDays(1);
        String dayleTicketEndTimeAndDate = FOMATTER.format(date);
        dateAndTimeTicketExpires = dayleTicketEndTimeAndDate;


    }

    public static void setParkingForOneHour() {
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ");
        LocalDateTime date = LocalDateTime.now().plusHours(1);
        String dayleTicketEndTimeAndDate = FOMATTER.format(date);
        dateAndTimeTicketExpires = dayleTicketEndTimeAndDate;
    }

    public static void setParkingForTwoHour() {
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ");
        LocalDateTime date = LocalDateTime.now().plusHours(2);
        String dayleTicketEndTimeAndDate = FOMATTER.format(date);
        dateAndTimeTicketExpires = dayleTicketEndTimeAndDate;
    }

    public static void setParkingForFourHour() {
        DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ");
        LocalDateTime date = LocalDateTime.now().plusHours(4);
        String dayleTicketEndTimeAndDate = FOMATTER.format(date);
        dateAndTimeTicketExpires = dayleTicketEndTimeAndDate;
    }
}
