package Controler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class AddingTimeToTicket {

    private static String timeTicketLasts;
    private static String dateAndTimeTicketExpires;

    public static void convertDecimalNumToTime(double decimalTimeTicketLasts, String dateTicketCreated) throws ParseException {

        int hours = (int) decimalTimeTicketLasts;
        int minutes = (int) (decimalTimeTicketLasts * 60) % 60;
        int seconds = (int) (decimalTimeTicketLasts * (60 * 60)) % 60;

        String timeTicketLasts = hours + ":" + minutes + ":" + seconds;
        String dateAndTimeTicketCreated = dateTicketCreated;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(dateAndTimeTicketCreated);

        date = Date.from(date.toInstant().plus(Duration.ofHours(hours)));
        date = Date.from(date.toInstant().plus(Duration.ofMinutes(minutes)));
        date = Date.from(date.toInstant().plus(Duration.ofSeconds(seconds)));

        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        setDateAndTimeTicketExpires(format2.format(date));
        setTimeTicketLasts(timeTicketLasts);
    }

    public static String getTimeTicketLasts() {
        return timeTicketLasts;
    }

    public static void setTimeTicketLasts(String timeTicketLasts) {
        AddingTimeToTicket.timeTicketLasts = timeTicketLasts;
    }

    public static String getDateAndTimeTicketExpires() {
        return dateAndTimeTicketExpires;
    }

    public static void setDateAndTimeTicketExpires(String dateAndTimeTicketExpires) {
        AddingTimeToTicket.dateAndTimeTicketExpires = dateAndTimeTicketExpires;
    }

    public static String convertDecimalNumberToTimeString(double decimalTimeTicketLasts) throws ParseException {

        int hours = (int) decimalTimeTicketLasts;
        int minutes = (int) (decimalTimeTicketLasts * 60) % 60;
        int seconds = (int) (decimalTimeTicketLasts * (60 * 60)) % 60;

        String timeTicketLasts = hours + ":" + minutes + ":" + seconds;
        return timeTicketLasts;
    }


}
