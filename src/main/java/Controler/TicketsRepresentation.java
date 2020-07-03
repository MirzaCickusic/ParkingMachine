package Controler;

import Database.GettingTicketsFromDB;

public class TicketsRepresentation {

    //Mehanizam ispisivanja individualne karte
    public void individualTicketRepresentation(double ticketPrice) {


    }

    //Mehanizam ispisivanja svih izdatih karata
    public static void allTicketsRepresentation() {

        System.out.println("\nTotal number of tickets issued: " + GettingTicketsFromDB.getNumberOfTicketsIssued());

        System.out.println("\nList of all individual tickets: \n");

        GettingTicketsFromDB.printAllTicketIssued();
    }
}
