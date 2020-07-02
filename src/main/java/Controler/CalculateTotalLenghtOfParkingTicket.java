package Controler;

import Model.TicketObject;

public class CalculateTotalLenghtOfParkingTicket {

    private static String timeTicketExpires;
    private static String timeTicketLasts;

    public static String getTotalTime() {
        return timeTicketExpires;
    }

    public static String getTimeTicketExpires() {
        return timeTicketExpires;
    }

    static void setTimeTicketExpires(String newTotalTime) {
        timeTicketExpires = newTotalTime;
    }

    public static String calculateTimeTicketLasts(String totalPriceOfTicket) {

        if (Integer.valueOf(totalPriceOfTicket) >= 5) {
            TicketObject.setTicketToDayleTicket();
            setTimeTicketExpires(TicketObject.getDateAndTimeTicketExpires());
            setTimeTicketLasts("24:00:00");

            System.out.println("Dayle ticket activated. Dayle ticket lasts 24h!");

            return timeTicketExpires;

        }

        if (Integer.valueOf(totalPriceOfTicket) == 1) {
            TicketObject.setParkingForOneHour();
            setTimeTicketLasts("01:00:00");

            return timeTicketExpires;
        } else if (Integer.valueOf(totalPriceOfTicket) == 2) {
            TicketObject.setParkingForTwoHour();
            setTimeTicketLasts("02:00:00");

            return timeTicketExpires;
        } else if (Integer.valueOf(totalPriceOfTicket) == 4) {
            TicketObject.setParkingForFourHour();
            setTimeTicketLasts("04:00:00");

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
