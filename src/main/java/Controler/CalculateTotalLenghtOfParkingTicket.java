package Controler;

import Model.TicketObject;

public class CalculateTotalLenghtOfParkingTicket {

    private static String timeTicketExpires;
    private static String timeTicketLasts;

    static void setTimeTicketExpires(String newTotalTime) {
        timeTicketExpires = newTotalTime;
    }

    public  static String calculateTimeTicketLasts(String totalPriceOfTicket) {

        if (Double.parseDouble(totalPriceOfTicket) >= 5) {
            TicketObject.setTicketToDayleTicket();
            setTimeTicketExpires(TicketObject.getDateAndTimeTicketExpires());
            setTimeTicketLasts("24:00:00");

            System.out.println("Dayle ticket activated");

            return timeTicketExpires;
        }

        if (Double.parseDouble(totalPriceOfTicket) == 1) {
            setTimeTicketLasts("01:00:00");
            setTimeTicketExpires(TicketObject.setParkingForOneHour());

            return timeTicketExpires;
        } else if (Double.parseDouble(totalPriceOfTicket) == 2) {
            setTimeTicketLasts("02:00:00");
            setTimeTicketExpires(TicketObject.setParkingForTwoHour());

            return timeTicketExpires;
        } else if (Double.parseDouble(totalPriceOfTicket) == 4) {
            setTimeTicketLasts("04:00:00");
            setTimeTicketExpires(TicketObject.setParkingForFourHour());

            return timeTicketExpires;
        } else {
            System.out.println("Money you entered does not match the expected intake. Take your money and try again!");
        }

        return null;
    }

    public static String getTimeTicketLasts() {
        return timeTicketLasts;
    }

    public static void setTimeTicketLasts(String timeTicketLasts) {
        CalculateTotalLenghtOfParkingTicket.timeTicketLasts = timeTicketLasts;
    }
}
