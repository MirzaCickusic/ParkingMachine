package View;

import Controler.CalculateTotalLengthOfParkingTicket;
import Controler.CoinReceivingMechanism;
import Database.GetParkingPricingInDB;
import Database.GettingTicketsFromDB;
import Database.SetParkingPricingInDB;
import Database.StoringTicketsToDB;

import java.util.Date;
import java.util.Scanner;

public class ParkingMachineMenu {

    private static Scanner scanner = new Scanner(System.in);

    public static boolean showMenu() {
        System.out.println("--------------------------------");
        System.out.println("WELCOME TO PARKING MACHINE");
        System.out.println("You have several options. Chose one of them (insert option number). Enter \"0\" to exit " +
                "the program: ");
        System.out.println("\n 1. Buy parking ticket\n 2. Set/Change hourly price of parking \n 3. Set/Change hourly " +
                "dayle of parking \n 4. Print all ticket ever issued");

        int optionChosen = scanner.nextInt();

        switch (optionChosen) {
            case 1:
                buyParkingTicket();
                return true;
            case 2:
                setHourlyPriceOfParking();
                return true;
            case 3:
                setDaylePriceOfParking();
                return true;
            case 4:
                printAllTicketEverIssued();
                return true;
        }

        return false;

    }

    private static void printAllTicketEverIssued() {

        GettingTicketsFromDB.printAllTicketIssued();

    }

    private static void setDaylePriceOfParking() {

        System.out.println("\nCurrent price is " + GetParkingPricingInDB.getDaylePrice() + "€ for full 24h of parking");
        System.out.println("Enter your new pricing: ");

        double newPriceForDayOfParking = scanner.nextDouble();

        SetParkingPricingInDB.updateDaylePricing(newPriceForDayOfParking);

        System.out.println("\nCurrent price is " + GetParkingPricingInDB.getDaylePrice() + "€ for hour of parking");

    }

    private static void setHourlyPriceOfParking() {

        System.out.println("\nCurrent price is " + GetParkingPricingInDB.getHourlyPrice() + "€ for hour of parking");
        System.out.println("Enter your new pricing: ");

        double newPriceForHourOfParking = scanner.nextDouble();

        SetParkingPricingInDB.updateHourlyPricing(newPriceForHourOfParking);
        //SetParkingPricingInDB.metoda(newPriceForHourOfParking);

        System.out.println("\nCurrent price is " + GetParkingPricingInDB.getHourlyPrice() + "€ for hour of parking");

    }

    private static void buyParkingTicket() {

        Date date = new Date();

        System.out.println("\nCurrent date and time is: " + date.toString());

        System.out.println("--------------------------------");
        System.out.println("Welcome to parking machine! These are our prices: \n- " + GetParkingPricingInDB.getHourlyPrice() + "€ for" +
                " hour of parking " +
                "\n- " + GetParkingPricingInDB.getDaylePrice() + "€ for a full 24h ticket");

        System.out.println("\nPlease pick a coins for entering in machine (0 would stop the input process):");
        System.out.println("\n 1. 0.50 € \n 2. 1.00 € \n 3. 2.00 €");

        CoinReceivingMechanism.coinReceivingMechanism();

        StoringTicketsToDB.addCustomer();

        CalculateTotalLengthOfParkingTicket.setTicketHourly_or_Dayle_andPrintResult();

    }
}
